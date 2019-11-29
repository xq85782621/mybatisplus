package com.meizhi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meizhi.common.response.PageResult;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.entity.request.UserSaveParams;
import com.meizhi.entity.response.DepartmentVo;
import com.meizhi.entity.response.UserDetail;
import com.meizhi.entity.response.UserVo;
import com.meizhi.mapper.DepartmentMapper;
import com.meizhi.mapper.UserMapper;
import com.meizhi.mapper.UserRoleMapper;
import com.meizhi.model.User;
import com.meizhi.model.UserRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * 分页查询用户列表
     */
    public PageResult<UserVo>  userList(UserQueryParams params){
        // 得到所有的部门idList包含子部门
        List<DepartmentVo> departmentVoList = departmentMapper.departmentVOList(params.getDeptId());
        List<Integer> deptIdList = departmentService.getDeptIdList(departmentVoList);
        deptIdList.add(params.getDeptId());
        params.setDeptIdList(deptIdList);

        Page<UserVo> page = new Page<>(params.getPageNo(), params.getPageSize());
        // page.setSearchCount(false);
        IPage<UserVo> userVoIPage = userMapper.userList(page, params);
        PageResult<UserVo> result = new PageResult<>();
        result.setRows(userVoIPage.getRecords());
        result.setTotal(userVoIPage.getTotal());
        return result;
    }


    /**
     * 新增用户
     */
    public boolean userAdd(UserSaveParams params){
        User user = new User();
        BeanUtils.copyProperties(params, user);
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        user.setStatus(0);
        int insert = userMapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        userRole.setRoleId(params.getRoleId());
        int userRoleInsert = userRoleMapper.insert(userRole);
        return insert == 1 && userRoleInsert == 1;
    }

    /**
     * 更新用户
     * 分配角色
     */
    public boolean userUpdate(Integer userId,UserSaveParams params){
        User user = userMapper.selectById(userId);
        BeanUtils.copyProperties(params,user);
        user.setModifyTime(new Date());
        Integer roleId = params.getRoleId();
        userRoleMapper.update(null, new UpdateWrapper<UserRole>().set("role_id",roleId).eq("user_id", user.getUserId()));
        return userMapper.updateById(user) == 1 ;
    }

    /**
     * 删除用户
     */
    public boolean userDelete(Integer userId){
        int i = userMapper.deleteById(userId);
        userRoleMapper.delete(new QueryWrapper<UserRole>().eq("user_id", userId));
        return i == 1;
    }


    /**
     * 用户详情
     */
    public UserDetail userDetail(Integer userId){
        User user = userMapper.selectById(userId);
        List<UserRole> userRoles = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", userId));
        UserRole userRole = userRoles.get(0);
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(user, userDetail);
        userDetail.setRoleId(userRole.getRoleId());
        return userDetail;
    }







}
