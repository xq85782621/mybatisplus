package com.meizhi.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meizhi.common.response.PageResult;
import com.meizhi.entity.response.UserVo;
import com.meizhi.mapper.AddressMapper;
import com.meizhi.model.Address;
import com.meizhi.model.User;
import com.meizhi.entity.request.UserSaveParams;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 查询用户详情
     */
    public UserVo userDetail(Integer id){
        User user = userMapper.selectById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }




    /**
     * 用户新增
     */
    public boolean userAdd(UserSaveParams userSaveParams){
        Address address = new Address();
        BeanUtils.copyProperties(userSaveParams, address);
        addressMapper.insert(address);
        User user = new User();
        BeanUtils.copyProperties(userSaveParams, user);
        if(StrUtil.isNotBlank(userSaveParams.getBirthday())){
            user.setBirthday(DateUtil.parseDate(userSaveParams.getBirthday()));
        }
        user.setAddressId(address.getAddressId());
        int insert = userMapper.insert(user);
        return insert == 1 ;
    }



    /**
     * 带条件分页查询用户列表
     */
    public PageResult<UserVo>  userList(UserQueryParams params){
        Page<UserVo> page = new Page<>(params.getPageNo(), params.getPageSize());
        IPage<UserVo> userVoIPage = userMapper.selectUserList( page, params);
        PageResult<UserVo> result = new PageResult<>();
        result.setRows(userVoIPage.getRecords());
        result.setTotal(userVoIPage.getTotal());
        return result;
    }

}


