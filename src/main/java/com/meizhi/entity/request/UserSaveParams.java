package com.meizhi.entity.request;


import com.meizhi.common.validation.DateValidation;
import com.meizhi.common.validation.SexValidation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;
import java.util.Date;

/**
 * 新增或更新时用来封装前端传递的数据
 */
@Getter
@Setter
public class UserSaveParams {

    @Null(groups = {Add.class}, message = "不需要传入ID")
    @NotNull(groups = {Update.class}, message = "ID不能为空")
    private Integer userId;

    @NotNull(message = "用户名不能为空", groups = {Add.class})
    private String name;

    @SexValidation(range = "0,1,2" , message = "性别类型只能为0,1,2")
    private Integer sex = 0; // 0 为未设置

    @DateValidation(format = "yyyy-MM-dd")
    private String birthday;

    private String address;

    private String zipCode;

    //添加校验
    public interface Add extends Default {
    }

    //更新校验
    public interface Update extends Default {
    }

}
