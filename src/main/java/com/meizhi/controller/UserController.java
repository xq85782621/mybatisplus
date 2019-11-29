package com.meizhi.controller;

import cn.hutool.json.JSONUtil;
import com.meizhi.api.UserControllerApi;
import com.meizhi.common.response.PageResult;
import com.meizhi.common.response.ResponseResult;
import com.meizhi.entity.request.UserQueryParams;
import com.meizhi.entity.request.UserSaveParams;
import com.meizhi.entity.response.UserDetail;
import com.meizhi.entity.response.UserVo;
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
     * 分页查询用户列表
     */
    @PostMapping("/query")
    public ResponseResult userList(@Validated UserQueryParams params) {
        System.err.println("==============");
        System.err.println(JSONUtil.toJsonStr(params));
        System.err.println("==============");
        PageResult<UserVo> result = userService.userList(params);
        return new ResponseResult(result);
    }


    /**
     * 新增用户
     */
    @PostMapping
    public ResponseResult userAdd(@Validated (value = UserSaveParams.Add.class) UserSaveParams userSaveParams) {
        userService.userAdd(userSaveParams);
        return new ResponseResult();
    }


    /**
     * 更新用户
     */
    @PutMapping("/{id}")
    public ResponseResult userUpdate( @PathVariable(value = "id") Integer userId,
            @Validated(value = UserSaveParams.Update.class) UserSaveParams userSaveParams){
        userService.userUpdate(userId,userSaveParams);
        return new ResponseResult();
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{userId}")
    public ResponseResult userDelete(@PathVariable(value = "userId") Integer userId){
        userService.userDelete(userId);
        return new ResponseResult();
    }

    /**
     * 用户详情
     */
    @GetMapping("/{userId}")
    public ResponseResult userDetail(@PathVariable  Integer userId){
        UserDetail user = userService.userDetail(userId);
        return new ResponseResult(user);
    }


}
