package com.meizhi.entity.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentSaveParams {



    // 上级部门ID
    private Integer parentId = 0;

    // 部门名称
    private String deptName;



}
