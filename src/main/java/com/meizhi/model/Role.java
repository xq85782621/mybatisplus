package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("t_role")
@Getter
@Setter
@ToString
public class Role {

    // 角色ID
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    // 角色名称
    private String roleName;

    // 角色描述
    private String remark;

}
