package com.meizhi.entity.request;


import com.meizhi.common.validation.IntRangeValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import javax.validation.groups.Default;

/**
 * 新增或更新时用来封装前端传递的数据并校验
 */
@Getter
@Setter
public class UserSaveParams {

    @NotEmpty(message = "用户名不能为空", groups = {Add.class})
    private String username;

    @NotEmpty(message = "密码不能为空", groups = {Add.class})
    private String password;

    @NotNull(message = "部门id不能为空", groups = {Add.class})
    private Integer deptId;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Null(groups = {Add.class}, message = "不需要传入status")
    @IntRangeValidation(range = "0,1" , message = "用户状态只能为0,1")
    private Integer status;

    @Pattern(regexp = "^[1][3,4,5,8][0-9]{9}$" ,message = "手机号格式不正确")
    private String mobile;

    @IntRangeValidation(range = "0,1,2" , message = "性别类型只能为0,1,2")
    private Integer sex ; // 0 为未设置

    @NotNull(message = "角色id不能为空", groups = {Add.class})
    private Integer roleId;

    //添加校验
    public interface Add extends Default {
    }

    //更新校验
    public interface Update extends Default {
    }

}
