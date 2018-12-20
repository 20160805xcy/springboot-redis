package com.xcy.springbootredis.controller;

import com.xcy.springbootredis.model.UserWeb;
import com.xcy.springbootredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xcy
 * @Description
 * @Date 2018/12/20 22:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserList",method = RequestMethod.GET)
    public Object getUserList(){
        List<UserWeb> userList = userService.getUserList();
        return userList;
    }


}
