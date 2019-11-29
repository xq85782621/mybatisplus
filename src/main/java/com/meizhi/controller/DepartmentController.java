package com.meizhi.controller;

import com.meizhi.api.DepartmentControllerApi;
import com.meizhi.common.response.ResponseResult;
import com.meizhi.entity.request.DepartmentSaveParams;
import com.meizhi.entity.response.DepartmentVo;
import com.meizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController implements DepartmentControllerApi {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 部门列表
     */
    @GetMapping("/list/{deptId}")
    public ResponseResult departmentVoList(@PathVariable("deptId") Integer deptId) {
        List<DepartmentVo> departmentVoList = departmentService.departmentList(deptId);
        return new ResponseResult(departmentVoList);
    }

    @GetMapping("/{deptId}")
    public ResponseResult departmentDetail(@PathVariable("deptId") Integer deptId) {
        DepartmentVo departmentVo = departmentService.departmentDetail(deptId);
        return new ResponseResult(departmentVo);
    }
    

    /**
     * 新增部门
     */
    @PostMapping
    public ResponseResult departmentAdd(DepartmentSaveParams params) {
        departmentService.departmentAdd(params);
        return new ResponseResult();
    }


    /**
     * 部门更新
     */
    @PutMapping("/{deptId}")
    public ResponseResult departmentUpdate(@PathVariable Integer deptId, String deptName) {
        departmentService.departmentUpdate(deptId, deptName);
        return new ResponseResult();
    }


    /**
     * 部门删除
     */
    @DeleteMapping("/{deptId}")
    public ResponseResult departmentDelete(@PathVariable Integer deptId) {
        departmentService.departmentDelete(deptId);
        return new ResponseResult();
    }


}
