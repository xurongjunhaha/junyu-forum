package com.junyu.forum.article.req;

import com.junyu.forum.util.base.BaseRequest;
import com.junyu.forum.entities.Advert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "AdvertREQ对象", description = "广告查询条件")
public class AdvertREQ extends BaseRequest<Advert> {

    @ApiModelProperty(value = "广告标题")
    private String title;

    @ApiModelProperty(value = "状态（0:禁用，1:正常）")
    private Integer status;

}
