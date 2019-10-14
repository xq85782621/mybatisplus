package com.meizhi.entity.request;

import com.meizhi.common.request.BaseParams;
import com.meizhi.common.validation.DateValidation;
import com.meizhi.common.validation.SexValidation;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserQueryParams extends BaseParams {

    private String name;

    @SexValidation(range = "0,1,2" , message = "性别类型只能为0,1,2")
    private Integer sex;

    @DateValidation(format="yyyy-MM-dd",message = "开始时间格式错误")
    private String startTime;

    @DateValidation(format="yyyy-MM-dd",message = "结束时间格式错误")
    private String endTime;

}
