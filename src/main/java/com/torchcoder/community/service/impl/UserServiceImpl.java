package com.torchcoder.community.service.impl;

import com.torchcoder.community.dao.UserMapper;
import com.torchcoder.community.entity.User;
import com.torchcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HouYongJu
 * @create 2021-10-01 20:55
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
