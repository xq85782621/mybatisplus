package com.meizhi.entity.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
public class DepartmentVo {

    private Integer deptId;

    // 上级部门ID
    private Integer parentId;

    // 部门名称
    private String deptName;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date modifyTime;

    // 部门人数
    private Integer deptNumber;

    private List<DepartmentVo> children;
}
