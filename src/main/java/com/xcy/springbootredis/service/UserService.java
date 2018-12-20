package com.xcy.springbootredis.service;

import com.xcy.springbootredis.model.UserWeb;

import java.util.List;

/**
 * @Author xcy
 * @Description
 * @Date 2018/12/20 22:47
 * @Version 1.0
 */
public interface UserService {
    List<UserWeb> getUserList();

    UserWeb getOneUser(Integer id);
}
