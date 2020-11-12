package com.junyu.forum.article.req;

import com.junyu.forum.util.base.BaseRequest;
import com.junyu.forum.entities.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分类请求类，封装查询条件
 */
@ApiModel(value = "CategoryREQ条件对象", description = "类别查询条件")
@Data
@Accessors(chain = true)
public class CategoryREQ extends BaseRequest<Category> {

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 状态：(1: 正常，0：禁用)
     */
    @ApiModelProperty(value = "状态：(1: 正常，0：禁用)")
    private Integer status;


}
