package com.meizhi.api;

import com.meizhi.common.response.ResponseResult;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.entity.request.UserSaveParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "用户管理", description = "用户相关接口")
public interface UserControllerApi {


    @ApiOperation(value = "用户列表", notes = "带条件分页查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页数", required = true, paramType = "query", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示", required = true, paramType = "query", dataType = "int", defaultValue = "5"),
    })
    ResponseResult userList(UserQueryParams params);


    @ApiOperation(value = "用户新增", notes = "添加新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "string",required =true),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string",required =true),
            @ApiImplicitParam(name = "deptId", value = "部门id", paramType = "query", dataType = "int",required =true),
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "query", dataType = "string",required =true),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "mobile", value = "手机号", paramType = "query", dataType = "string",required =true),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, paramType = "query", dataType = "int"),
    })
    ResponseResult userAdd(UserSaveParams userSaveParams);


    @ApiOperation(value = "用户更新", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "deptId", value = "部门id", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "mobile", value = "手机号", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "sex", value = "性别",  paramType = "query", dataType = "int"),
    })
    ResponseResult userUpdate( Integer userId,UserSaveParams userSaveParams);



    @ApiOperation(value = "删除用户", notes = "根据id来删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path", dataType = "int"),
    })
    ResponseResult userDelete(Integer userId);
}
