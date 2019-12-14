package com.meizhi.zDemo.lambdaDemo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.meizhi.entity.response.RoleVo;
import com.meizhi.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class demo {


    public static void main(String[] args) {
        List<Role> roleList = new ArrayList<>();
        Role role1 = new Role();
        role1.setRoleName("普通用户");
        role1.setRemark("测试用户");
        Role role2 = new Role();
        role2.setRoleName("管理员");
        role2.setRemark("权限很高");
        roleList.add(role1);
        roleList.add(role2);

        List<RoleVo> roleVoList =  roleList.stream().map(role -> {
            RoleVo roleVo = new RoleVo();
            BeanUtil.copyProperties(role, roleVo);
            roleVo.setRoleNumber(5);
            return roleVo;
        }).collect(Collectors.toList());

        System.err.println(JSONUtil.toJsonStr(roleVoList));

    }
}
