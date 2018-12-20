package com.xcy.springbootredis.mapper;

import com.xcy.springbootredis.model.UserWeb;
import com.xcy.springbootredis.util.MyMapper;

public interface UserWebMapper extends MyMapper<UserWeb> {

    UserWeb getOneUserById(Integer id);

}