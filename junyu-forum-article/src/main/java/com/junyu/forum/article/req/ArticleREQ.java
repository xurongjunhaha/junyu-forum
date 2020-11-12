package com.junyu.forum.article.req;

import com.junyu.forum.util.base.BaseRequest;
import com.junyu.forum.entities.Article;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "ArticleREQ对象", description = "文章查询条件")
public class ArticleREQ extends BaseRequest<Article> {

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "状态（0: 已删除, 1:未审核，2:审核通过，3：审核未通过）")
    private Integer status;

}
