package com.meizhi.controller;

import io.swagger.annotations.Api;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class BaseController {

    @RequestMapping("/404.do")
    public String notExistsPage() {
        return "访问的页面不存在s";
    }
}
