package com.junyu.forum.article.api;

import com.junyu.forum.article.service.ICategoryService;
import com.junyu.forum.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此控制层接口，不需要通过身份认证就可以调用到
 */
@Api(value = "分类管理API接口", description = "分类管理API接口，不需要通过身份认证就可以直接访问")
@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("获取所有正常状态的分类-公开API接口")
    @GetMapping("/list") // 请求 192.168.0.11:8001/article/api/category/list
    public Result list() {
        return categoryService.findAllNormal();
    }

    @ApiOperation("查询正常状态的分类及分类下的所有标签-公开API接口")
    @GetMapping("/label/list") // 192.168.0.11:8001/article/api/category/label/list
    public Result findCategoryAndLabel() {
        return categoryService.findCategoryAndLabel();
    }


}
