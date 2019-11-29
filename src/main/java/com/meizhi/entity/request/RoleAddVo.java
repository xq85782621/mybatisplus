package com.meizhi.entity.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class RoleAddVo {

    String roleName;
    String remark;
    List<Integer> ids;
}
