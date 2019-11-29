package com.meizhi.controller;

import com.meizhi.common.response.PageResult;
import com.meizhi.common.response.ResponseResult;
import com.meizhi.entity.request.RoleQueryParams;
import com.meizhi.entity.response.RoleVo;
import com.meizhi.model.Role;
import com.meizhi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询角色列表
     */
    @PostMapping("/query")
    public ResponseResult roleList(RoleQueryParams params) {
        PageResult<RoleVo> pageResult = roleService.roleList(params);
        return new ResponseResult(pageResult);
    }

    @GetMapping("/all")
    public ResponseResult roleAll(){
        List<Role> roles = roleService.roleAll();
        return new ResponseResult(roles);
    }

    /**
     * 新增角色
     */
    @PostMapping
    public ResponseResult roleAdd(@NotBlank(message = "角色姓名不能为空") String roleName,
                                  @NotBlank(message = "角色描述不能为空") String remark){
        roleService.roleAdd(roleName, remark);
        return new ResponseResult();
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{roleId}")
    public ResponseResult roleDelete(@PathVariable Integer roleId){
        roleService.roleDelete(roleId);
        return new ResponseResult();
    }

    /**
     * 角色基本信息
     */
    @GetMapping("/{roleId}")
    public ResponseResult roleDetail(@PathVariable Integer roleId){
        RoleVo roleVo = roleService.roleDetail(roleId);
        return new ResponseResult(roleVo);
    }

    /**
     * 更新角色基本信息
     */
    @PutMapping("/{roleId}")
    public ResponseResult roleUpdate(@PathVariable Integer roleId, String roleName,String remark){
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        role.setRemark(remark);
        roleService.roleUpdate(role);
        return new ResponseResult();
    }



}
