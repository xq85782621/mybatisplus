package com.meizhi.entity.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleVo {
    // 角色ID
    private Integer roleId;

    // 角色名称
    private String roleName;

    // 角色描述
    private String remark;

    private Integer roleNumber;
}
