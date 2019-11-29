package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@TableName("role_permission")
@Getter
@Setter
@ToString
public class RolePermission {

    private Integer roleId;

    private Integer permissionId;

}
