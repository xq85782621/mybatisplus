package com.meizhi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.entity.response.UserVo;
import com.meizhi.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserMapper extends BaseMapper<User> {

    IPage<UserVo>  selectUserList(Page page, @Param("params") UserQueryParams params);


}
