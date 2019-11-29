package com.meizhi.entity.request;

import com.meizhi.common.request.BaseParams;
import com.meizhi.common.validation.DateValidation;
import com.meizhi.common.validation.IntRangeValidation;
import com.meizhi.common.validation.StrRangeValidation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 查询用户列表时封装查询条件并校验
 */

@Setter
@Getter
@ToString
public class UserQueryParams extends BaseParams {

    // 用户名,模糊搜索
    private String username;

    // 手机号
    private String mobile;

    @IntRangeValidation(range = "0,1,2" , message = "性别类型只能为0,1,2")
    private Integer sex;

    private Integer status;

    // 根据部门id搜索,包含子部门(前端只需要传递当前搜索部门的id)
    private Integer deptId;

    // 查询字段
    @StrRangeValidation(ranges = "create_time,  modify_time,  last_login_time",message = "查询类型错误")
    private String sortType;

    // 根据查询字段搜索的开始时间
    @DateValidation(format="yyyy-MM-dd hh:mm:ss",message = "开始时间格式错误")
    private String startTime;

    // 根据查询字段搜索的结束时间
    @DateValidation(format="yyyy-MM-dd hh:mm:ss",message = "结束时间格式错误")
    private String endTime;

    // swagger页面中忽略该参数
    @ApiModelProperty(hidden = true)
    private List<Integer> deptIdList;

}
