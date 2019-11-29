package com.meizhi.entity.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserVo {

    // 用户ID
    private Integer userId;

    // 用户名
    private String username;

    // 部门名称
    private String deptName;

    // 邮箱
    private String email;

    // 联系电话
    private String mobile;

    // 性别 1男 2女 0保密
    private Integer sex;

    // 状态 0锁定 1有效
    private Integer status;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    // 最后登录时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    // 描述
    private String description;

    // 头像
    private String avatar;

    // 角色名称
    private String roleName;

}
