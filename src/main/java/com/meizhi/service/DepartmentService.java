package com.meizhi.service;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.meizhi.common.code.DepartmentCode;
import com.meizhi.common.exception.CustomException;
import com.meizhi.entity.request.DepartmentSaveParams;
import com.meizhi.entity.response.DepartmentVo;
import com.meizhi.mapper.DepartmentMapper;
import com.meizhi.mapper.UserMapper;
import com.meizhi.model.Department;
import com.meizhi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 部门列表
     */
    public List<DepartmentVo> departmentList(Integer deptId) {
        List<DepartmentVo> departmentVoList = departmentMapper.departmentVOList(deptId);
        return departmentVoList;
    }


    /**
     * 部门新增
     */
    public boolean departmentAdd(DepartmentSaveParams params) {
        List<Department> departmentList = departmentMapper.selectList(new QueryWrapper<Department>().eq("parent_id", params.getParentId()));
        for (Department department : departmentList) {
            String deptName = department.getDeptName();
            if (StrUtil.equalsIgnoreCase(deptName, params.getDeptName())) {
                // 同级部门出现重名了
                throw new CustomException(DepartmentCode.DEPT_EXIST);
            }
        }
        Department department = new Department();
        BeanUtil.copyProperties(params, department);
        department.setCreateTime(new Date());
        department.setModifyTime(new Date());
        int insert = departmentMapper.insert(department);
        return insert == 1;
    }

    /**
     * 部门详情
     */
    public DepartmentVo departmentDetail(Integer deptId){
        Department department = departmentMapper.selectById(deptId);
        if(ObjectUtil.isNull(department)){
            throw new CustomException(DepartmentCode.DEPT_NOT_EXIST);
        }
        // 得到部门人数,可能该部门存在子部门 一并查出
        List<DepartmentVo> departmentVoList = departmentMapper.departmentVOList(deptId);
        List<Integer> deptIdList = getDeptIdList(departmentVoList);
        deptIdList.add(deptId);
        Integer number = userMapper.selectCount(new QueryWrapper<User>().in("dept_id", deptIdList));
        DepartmentVo departmentVo = new DepartmentVo();
        BeanUtil.copyProperties(department, departmentVo);
        departmentVo.setDeptNumber(number);
        return departmentVo;
    }




    /**
     * 部门更新
     */
    public boolean departmentUpdate(Integer deptId, String deptName) {
        Department dept = departmentMapper.selectById(deptId);
        if (ObjectUtil.isNull(dept)) {
            throw new CustomException(DepartmentCode.DEPT_NOT_EXIST);
        }
        List<Department> departmentList = departmentMapper.selectList(new QueryWrapper<Department>().eq("parent_id", dept.getParentId()));
        for (Department department : departmentList) {
            String deptNameTemp = department.getDeptName();
            Integer deptIdTemp = department.getDeptId();
            if (StrUtil.equalsIgnoreCase(deptName, deptNameTemp) && !deptIdTemp.equals(deptId)) {
                // 同级部门出现重名了
                throw new CustomException(DepartmentCode.DEPT_EXIST);
            }
        }
        dept.setModifyTime(new Date());
        dept.setDeptName(deptName);
        int i = departmentMapper.updateById(dept);
        return i == 1;
    }


    /**
     * 部门删除
     */
    public boolean departmentDelete(Integer deptId) {
        List<Department> departmentList = departmentMapper.selectList(new QueryWrapper<Department>().eq("parent_id", deptId));
        if (ArrayUtil.isNotEmpty(departmentList)) {
            throw new CustomException(DepartmentCode.DEPT_EXIST_CHILDREN);
        }
        int i = departmentMapper.deleteById(deptId);
        if (i == 1) {
            userMapper.update(null, new UpdateWrapper<User>().eq("dept_id", deptId).set("dept_id", null));
        }
        return i == 1;
    }


    /**
     * 递归得到所有的子部门id
     */
    public List<Integer> getDeptIdList(List<DepartmentVo> departmentVoList) {
        List<Integer> deptIdList = new ArrayList<>();
        for (DepartmentVo departmentVo : departmentVoList) {
            deptIdList.add(departmentVo.getDeptId());
            if (ObjectUtil.isNotEmpty(departmentVo.getChildren())) {
                List<Integer> deptIdListTemp = getDeptIdList(departmentVo.getChildren());
                deptIdList.addAll(deptIdListTemp);
            }
        }
        return deptIdList;
    }






}
