package com.xcy.springbootredis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xcy.springbootredis.model.UserWeb;
import com.xcy.springbootredis.service.UserService;
import com.xcy.springbootredis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xcy
 * @Description
 * @Date 2018/12/20 23:03
 * @Version 1.0
 */
@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    //存取字符串
    @RequestMapping("test01")
    public Object test01(){
        redisTemplate.opsForValue().set("name","xcy");
        return redisTemplate.opsForValue().get("name");
    }

    //存取对象
    @RequestMapping("test02")
    public Object test02(){

        UserWeb userWeb = userService.getOneUser(1);
        String s = JSONObject.toJSONString(userWeb);

        redisTemplate.opsForValue().set("user",s);
        return redisTemplate.opsForValue().get("user");
    }

    //使用RedisUtils完成存取
    @RequestMapping("test03")
    public Object test03(){

        UserWeb userWeb = userService.getOneUser(2);
        String s = JSONObject.toJSONString(userWeb);

        redisUtils.set("user03",s);
        return redisUtils.get("user03");
    }

}
