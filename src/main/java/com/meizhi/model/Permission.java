package com.meizhi.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("t_permission")
@Getter
@Setter
@ToString
public class Permission {

    // 权限ID
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer id;

    // 权限描述
    private String description;

    // 权限名称
    private String name;

    // 权限类型 1为菜单 2为按钮 3为API
    private Integer type;

    // 菜单所属的父菜单 / 按钮所属的菜单
    private String parentId;


}
