package com.junyu.forum.article.req;

import com.junyu.forum.util.base.BaseRequest;
import com.junyu.forum.entities.Article;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="ArticleUserREQ对象", description = "获取指定用户文章的查询条件")
public class ArticleUserREQ extends BaseRequest<Article> {

    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;

    @ApiModelProperty(value = "是否公开（0：不公开，1：公开）", required = true)
    private Integer isPublic; // P是大写

}
