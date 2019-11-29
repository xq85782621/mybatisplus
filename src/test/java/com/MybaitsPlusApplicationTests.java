package com;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meizhi.Application;
import com.meizhi.common.response.PageResult;
import com.meizhi.entity.request.RoleQueryParams;
import com.meizhi.entity.response.RoleVo;
import com.meizhi.mapper.RoleMapper;
import com.meizhi.mapper.UserMapper;
import com.meizhi.mapper.UserRoleMapper;
import com.meizhi.model.Role;
import com.meizhi.model.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MybaitsPlusApplicationTests {


    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserMapper userMapper;


    @Test
    public void test2() {
        RoleQueryParams params = new RoleQueryParams();
        Page<Role> rolePage = new Page<>(params.getPageNo(), params.getPageSize());
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(params.getRoleName())) {
            roleQueryWrapper = new QueryWrapper<Role>().like("role_name", "%" + params.getRoleName() + "%");
        }

        IPage<Role> roleIPage = roleMapper.selectPage(rolePage, roleQueryWrapper);


       // roleMapper.delete(new QueryWrapper<Role>().eq("epuipment_id", 2));

        System.out.println("--");

        String a = "ss";
        // po -> vo
        List<Role> records = roleIPage.getRecords();
        List<RoleVo> userRoles  = records.stream().map(role ->{
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(role, roleVo);
            roleVo.setRoleNumber(userRoleMapper.selectCount(new QueryWrapper<UserRole>().eq("role_id", role.getRoleId())));
            return roleVo;
        }).collect(Collectors.toList());

        String s = JSONUtil.toJsonStr(userRoles);
        System.err.println(s);


        PageResult<RoleVo> roleVoPageResult = new PageResult<>(roleIPage.getTotal(), userRoles);

        System.err.println(JSONUtil.toJsonStr(roleVoPageResult));
    }


    public static void main(String[] args) {

        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleName("角色111");
        Role role2= new Role();
        role.setRoleName("角色222");

        roleList.add(role);
        roleList.add(role2);


        String s = JSONUtil.toJsonStr(role);
        System.err.println(s);

    }




}
