package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("t_user_role")
@Getter
@Setter
@ToString
public class UserRole {

    private Integer userId;

    private Integer roleId;

}
