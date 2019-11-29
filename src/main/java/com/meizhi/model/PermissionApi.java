package com.meizhi.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("t_permission_api")
@Getter
@Setter
@ToString
public class PermissionApi {

    // 主键ID
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;

    // 请求类型
    private String apiMethod;

    // 请求url
    private String apiUrl;

}
