package com.meizhi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meizhi.entity.response.DepartmentVo;
import com.meizhi.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    public List<DepartmentVo> departmentVOList(Integer deptId);


}
