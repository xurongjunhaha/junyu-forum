package com.junyu.forum.system.req;

import com.junyu.forum.entities.SysRole;
import com.junyu.forum.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "SysRoleREQ对象", description = "角色查询条件")
public class SysRoleREQ extends BaseRequest<SysRole> {

    @ApiModelProperty(value = "角色名称")
    private String name;

}
