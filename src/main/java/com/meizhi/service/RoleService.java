package com.meizhi.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meizhi.common.response.PageResult;
import com.meizhi.entity.request.RoleQueryParams;
import com.meizhi.entity.response.RoleVo;
import com.meizhi.mapper.RoleMapper;
import com.meizhi.mapper.RolePermissionMapper;
import com.meizhi.mapper.UserRoleMapper;
import com.meizhi.model.Role;
import com.meizhi.model.RolePermission;
import com.meizhi.model.UserRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 分页查询角色列表
     */
    public PageResult<RoleVo> roleList(RoleQueryParams params) {

        // condition
        Page<Role> rolePage = new Page<>(params.getPageNo(), params.getPageSize());
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(params.getRoleName())) {
            roleQueryWrapper.like("role_name", "%" + params.getRoleName() + "%");
        }

        // query
        IPage<Role> roleIPage = roleMapper.selectPage(rolePage, roleQueryWrapper);

        // po -> vo
        List<Role> records = roleIPage.getRecords();
        List<RoleVo> roleVoList = records.stream().map(role ->{
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(role, roleVo);
            roleVo.setRoleNumber(userRoleMapper.selectCount(new QueryWrapper<UserRole>().eq("role_id", role.getRoleId())));
            return roleVo;
        }).collect(Collectors.toList());

        // return
        return new PageResult<>(roleIPage.getTotal(), roleVoList);
    }

    /**
     * 所有的角色
     */
    public List<Role> roleAll() {
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }


    /**
     * 新增角色
     */
    public boolean roleAdd(String roleName, String remark) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setRemark(remark);
        return roleMapper.insert(role) == 1;
    }


    /**
     * 删除角色
     */
    public boolean roleDelete(Integer roleId) {
        int i = roleMapper.deleteById(roleId);
        if (i == 1) {
            rolePermissionMapper.delete(new QueryWrapper<RolePermission>().eq("role_id", roleId));
        }
        return i == 1;
    }


    /**
     * 角色详情
     */
    public RoleVo roleDetail(Integer roleId){
        Role role = roleMapper.selectById(roleId);
        Integer roleNumber = userRoleMapper.selectCount(new QueryWrapper<UserRole>().eq("role_id", roleId));
        RoleVo roleVo = new RoleVo();
        BeanUtils.copyProperties(role, roleVo);
        roleVo.setRoleNumber(roleNumber);
        return roleVo;
    }

    /**
     * 更新基本信息
     * @return
     */
    public boolean roleUpdate(Role role){
        int i = roleMapper.updateById(role);
        return i == 1;
    }


}
