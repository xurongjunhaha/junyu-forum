package com.junyu.forum.article.req;

import com.junyu.forum.util.base.BaseRequest;
import com.junyu.forum.entities.Label;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "LabelREQ对象", description = "标签查询条件")
@Data
@Accessors(chain = true)
public class LabelREQ extends BaseRequest<Label> {

    @ApiModelProperty(value="标签名称")
    private String name;

    @ApiModelProperty(value="分类id")
    private String categoryId;

}
