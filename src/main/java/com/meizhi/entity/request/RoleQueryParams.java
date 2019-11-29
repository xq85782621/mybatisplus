package com.meizhi.entity.request;

import com.meizhi.common.request.BaseParams;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleQueryParams  extends BaseParams {

    private String roleName;

//    @DateValidation(message = "开始时间格式错误")
//    private String startTime;
//
//    @DateValidation(message = "结束时间格式错误")
//    private String endTime;

}
