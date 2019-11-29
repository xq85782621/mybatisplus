package com.meizhi.api;

import com.meizhi.common.response.ResponseResult;
import com.meizhi.entity.request.DepartmentSaveParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "部门管理", description = "部门相关接口")
public interface DepartmentControllerApi {

    @ApiOperation(value = "部门列表", notes = "树桩结构的部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptId", value = "父级id(传0为查所有)", required = true, paramType = "path", dataType = "int"),
    })
    ResponseResult departmentVoList(Integer deptId);


    @ApiOperation(value = "新增部门", notes = "新增部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父级id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "deptName", value = "部门名称", required = true, paramType = "query", dataType = "string"),
    })
    ResponseResult departmentAdd(DepartmentSaveParams params);


    @ApiOperation(value = "更新部门", notes = "更新部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptId", value = "部门id", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "deptName", value = "部门名称", required = true, paramType = "query", dataType = "string"),
    })
    ResponseResult departmentUpdate(Integer deptId, String deptName);

    @ApiOperation(value = "删除部门", notes = "删除部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptId", value = "部门id", required = true, paramType = "path", dataType = "int"),
    })
    ResponseResult departmentDelete(Integer deptId);
}
