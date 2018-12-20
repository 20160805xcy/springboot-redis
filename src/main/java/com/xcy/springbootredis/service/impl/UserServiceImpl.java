package com.xcy.springbootredis.service.impl;

import com.xcy.springbootredis.mapper.UserWebMapper;
import com.xcy.springbootredis.model.UserWeb;
import com.xcy.springbootredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xcy
 * @Description
 * @Date 2018/12/20 22:50
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserWebMapper userWebMapper;
    @Override
    public List<UserWeb> getUserList() {
        List<UserWeb> userWebList = userWebMapper.selectAll();
        return userWebList;
    }

    @Override
    public UserWeb getOneUser(Integer id) {
        UserWeb userWeb = userWebMapper.selectByPrimaryKey(id);
        return userWeb;
    }
}
