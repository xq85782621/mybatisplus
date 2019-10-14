package com.meizhi.controller;

import com.meizhi.api.UserControllerApi;
import com.meizhi.common.code.UserCode;
import com.meizhi.common.exception.CustomException;
import com.meizhi.entity.request.UserSaveParams;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.common.response.PageResult;
import com.meizhi.common.response.ResponseResult;
import com.meizhi.entity.response.UserVo;
import com.meizhi.model.User;
import com.meizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {


    @Autowired
    private UserService userService;

    /**
     * 查询用户详情
     */
    @GetMapping("/{id}")
    public ResponseResult userDetail(@PathVariable Integer id) {
        UserVo user = userService.userDetail(id);
        if (user == null) {
            throw new CustomException(UserCode.USER_NOT_EXIST);
        }
        return new ResponseResult(user);
    }

    @GetMapping("/test/{id}")
    public String userDetail2(@PathVariable Integer id) {
        UserVo user = userService.userDetail(id);
        if (user == null) {
            throw new CustomException(UserCode.USER_NOT_EXIST);
        }
        return user.getName();
    }

    /**
     * 带条件分页查询用户列表
     */
    @GetMapping
    public ResponseResult userList(@Validated UserQueryParams params) {
        PageResult<UserVo> result = userService.userList(params);
        return new ResponseResult(result);
    }


    /**
     * 用户新增
     */
    @PostMapping
    public ResponseResult userAdd(@Validated(value = UserSaveParams.Add.class) UserSaveParams userSaveParams) {
        userService.userAdd(userSaveParams);
        return new ResponseResult();
    }




}
