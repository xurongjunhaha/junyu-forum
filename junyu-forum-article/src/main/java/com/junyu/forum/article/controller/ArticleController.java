package com.junyu.forum.article.controller;


import com.junyu.forum.article.service.IArticleService;
import com.junyu.forum.article.req.ArticleREQ;
import com.junyu.forum.article.req.ArticleUserREQ;
import com.junyu.forum.entities.Article;
import com.junyu.forum.util.base.Result;
import com.junyu.forum.util.enums.ArticleStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章信息表 前端控制器
 * </p>
 *
 * @author 梦学谷-www.mengxuegu.com
 */
@Api(value = "文章管理接口", description = "文章管理接口, 提供文章的增删改查")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    // 在请求方法之前会校验用户是否有对应的权限，如果有则可以调用到此方法，没有则调用失败
    @PreAuthorize("hasAuthority('article:search')")
    @ApiOperation("根据文章标题和状态查询文章分页列表接口")
    @PostMapping("/search") // 192.168.0.11:8001/article/article/search
    public Result search(@RequestBody ArticleREQ req) {
        return articleService.queryPage(req);
    }

    // 有查看或者审核权限即可调用此接口
    @PreAuthorize("hasAnyAuthority('article:view', 'article:audit')")
    @ApiOperation("查询文章详情接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @GetMapping("/{id}")
    public Result view(@PathVariable String id) {
        // 获取认证信息对象
//        Authentication authentication
//                = SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationDetails details =
//                (OAuth2AuthenticationDetails)authentication.getDetails();
//        Map<String, Object> map = (Map<String, Object>) details.getDecodedDetails();
//        Map<String, Object>  userInfo = (Map<String, Object>) map.get("userInfo");
//        userInfo.get("uid");
        return articleService.findArticleAndLabelById(id);
    }


    @ApiOperation("修改文章信息接口")
    @PutMapping // put 请求 192.168.0.11:8001/article/article
    public Result update(@RequestBody Article article) {
        return articleService.updateOrSave(article);
    }

    @ApiOperation("新增文章信息接口")
    @PostMapping
    public Result save(@RequestBody Article article) {
        return articleService.updateOrSave(article);
    }

    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @ApiOperation("删除文章接口")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        // 假删除，只是将状态更新
       return articleService.updateStatus(id, ArticleStatusEnum.DELETE);
    }

    @PreAuthorize("hasAuthority('article:audit')")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @ApiOperation("审核通过接口")
    @GetMapping("/audit/success/{id}")
    public Result success(@PathVariable("id") String id) {
        // 审核通过
        return articleService.updateStatus(id, ArticleStatusEnum.SUCCESS);
    }

    @PreAuthorize("hasAuthority('article:audit')")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @ApiOperation("审核不通过接口")
    @GetMapping("/audit/fail/{id}")
    public Result fail(@PathVariable("id") String id) {
        // 审核不通过
        return articleService.updateStatus(id, ArticleStatusEnum.FAIL);
    }

    @ApiOperation("根据用户ID查询公开或未公开的文章列表接口")
    @PostMapping("/user") // /article/user
    public Result findListByUserId(@RequestBody ArticleUserREQ req) {
        return articleService.findListByUserId(req);
    }

    @ApiImplicitParams({
       @ApiImplicitParam(name = "id", value = "文章ID", required = true),
       @ApiImplicitParam(name = "count", value = "点赞数", required = true)
    })
    @ApiOperation("更新点赞数")
    @PutMapping("/thumb/{id}/{count}")
    public Result updataThumhup(@PathVariable("id") String id,
                                @PathVariable("count") int count) {
        return articleService.updateThumhup(id, count);
    }

    @ApiOperation("统计审核通过且公开的文章总记录数")
    @GetMapping("/total")
    public Result getArticleTotal() {
        return articleService.getArticleTotal();
    }

    @ApiOperation("统计各分类下的文章数")
    @GetMapping("/category/total")
    public Result categoryTotal() {
        return articleService.selectCategoryTotal();
    }

    @ApiOperation("统计近6个月发布的文章数")
    @GetMapping("/month/total")
    public Result monthArticleTotal() {
        return articleService.selectMonthArticleTotal();
    }
}
