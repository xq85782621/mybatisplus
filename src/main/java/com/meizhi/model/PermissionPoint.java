package com.meizhi.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("t_permission_point")
@Getter
@Setter
@ToString
public class PermissionPoint {

    // 主键ID
    private Integer permissionId;

    // 按钮class
    private String pointClass;

    // 按钮icon
    private String pointIcon;


}
