package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@Data
@TableName("address")
public class Address {

    @TableId(value = "id", type = IdType.AUTO)
    @TableField(fill = FieldFill.INSERT )
    private Integer addressId;

    private String address;

    @TableField(value = "zip_code")
    private String zipCode;
}
