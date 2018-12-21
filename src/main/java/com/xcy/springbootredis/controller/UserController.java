package com.xcy.springbootredis.controller;

import com.xcy.springbootredis.model.UserWeb;
import com.xcy.springbootredis.service.UserService;
import com.xcy.springbootredis.utils.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "getOneUser",method = RequestMethod.GET)
    public Object getOneUser(){
        //UserWeb userWeb1 = userService.getOneUser(4);
        //String s1 = FastJsonUtils.convertObjectToJSON(userWeb1);
        //System.out.println(s1);

        //UserWeb userWeb2 = userService.getOneUser(4);
        //String s2 = FastJsonUtils.toJSONNoFeatures(userWeb2);
        //System.out.println(s2);

        Object o = FastJsonUtils.toBean("{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}");

        UserWeb userWeb = FastJsonUtils.toBean("{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}", UserWeb.class);

        Object[] array = FastJsonUtils.toArray("[{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}]");
        Object[] array1 = FastJsonUtils.toArray("[{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}]", UserWeb.class);

        //List<UserWeb> userList = userService.getUserList();
        //String string = FastJsonUtils.toJSONStringNoFeatures(userList);
        //List<UserWeb> userWebList = FastJsonUtils.toList(string, UserWeb.class);
        Map<Object, Object> map = FastJsonUtils.toMap("{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}");

        String s = FastJsonUtils.mapToString(map);
        return s;
    }

}
