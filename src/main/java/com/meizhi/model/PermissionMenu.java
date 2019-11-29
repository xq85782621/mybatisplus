package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("t_permission_menu")
@Getter
@Setter
@ToString
public class PermissionMenu {

    // 权限ID
    private Integer permission_id;

    // 菜单icon
    private String menuIcon;

    // 排序
    private String menuOrder;

}
