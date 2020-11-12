package com.junyu.forum.article.feign;

import com.junyu.forum.article.service.IArticleService;
import com.junyu.forum.article.service.ILabelService;
import com.junyu.forum.entities.Label;
import com.junyu.forum.feign.IFeignArticleController;
import com.junyu.forum.feign.req.UserInfoREQ;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "被远程调用的文章微服务接口", description = "被远程调用的文章微服务接口")
@RestController // 不要少了
public class FeignArticleController implements IFeignArticleController {

    @Autowired
    private ILabelService labelService;

    @Override
    public List<Label> getLabelListByIds(List<String> labelIds) {
        // IService<Label>中已经实现了此批量查询标签信息功能，mybatis-plus已经提供的
        return labelService.listByIds(labelIds);
    }

    @Autowired
    private IArticleService articleService;

    @Override
    public boolean updateUserInfo(UserInfoREQ req) {
        return articleService.updateUserInfo(req);
    }


}
