package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@TableName("t_dept")
@Getter
@Setter
@ToString
public class Department {


    // 部门ID
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;

    // 上级部门ID
    private Integer parentId;

    // 部门名称
    private String deptName;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date modifyTime;

}
