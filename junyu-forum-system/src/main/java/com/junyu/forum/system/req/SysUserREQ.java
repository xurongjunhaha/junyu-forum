package com.junyu.forum.system.req;

import com.junyu.forum.entities.SysUser;
import com.junyu.forum.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "SysUserREQ对象", description = "用户查询条件")
public class SysUserREQ extends BaseRequest<SysUser> {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String mobile;

}
