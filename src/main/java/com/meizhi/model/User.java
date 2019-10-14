package com.meizhi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@TableName("user")
@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer userId;

    private String name;

    private Integer sex;

    private Date birthday;

    private Integer addressId;

}
