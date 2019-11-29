package com.meizhi.entity.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DepartmentDetailVo {

    private Integer deptId;

    // 部门名称
    private String deptName;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date modifyTime;



}
