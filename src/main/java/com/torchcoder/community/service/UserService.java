package com.torchcoder.community.service;

import com.torchcoder.community.dao.UserMapper;
import com.torchcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author HouYongJu
 * @create 2021-10-01 20:54
 */
public interface UserService {
    public User findUserById(int id);
}
