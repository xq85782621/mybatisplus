package com.meizhi.api;

import com.meizhi.entity.request.UserSaveParams;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.common.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "用户管理", description = "用户相关接口")
public interface UserControllerApi {

    @ApiOperation(value = "用户详情", notes = "根据id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "int" ),
    })
    ResponseResult userDetail(Integer id);


    @ApiOperation(value = "用户列表", notes = "带条件分页查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页数", required = true, paramType = "query", dataType = "int" ,defaultValue ="1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示", required = true, paramType = "query", dataType = "int" ,defaultValue ="5"),
            @ApiImplicitParam(name = "name", value = "用户名(模糊查询)", paramType = "query", dataType = "string" ),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "query", dataType = "string" ),
            @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "string" ),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "string" ),
    })
    ResponseResult userList(UserQueryParams params);


    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", paramType = "query", dataType = "string" ),
            @ApiImplicitParam(name = "sex", value = "性别",required = true,  paramType = "query", dataType = "int" ),
            @ApiImplicitParam(name = "birthday", value = "生日", paramType = "query", dataType = "string" ),
            @ApiImplicitParam(name = "address", value = "住址", paramType = "query", dataType = "string" ),
            @ApiImplicitParam(name = "zipCode", value = "邮编", paramType = "query", dataType = "string" ),
    })
    @ApiOperation(value = "用户新增", notes = "添加新用户")
    ResponseResult userAdd(UserSaveParams userSaveParams);
}
