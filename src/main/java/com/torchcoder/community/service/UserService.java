package com.torchcoder.community.service;

import com.torchcoder.community.dao.UserMapper;
import com.torchcoder.community.entity.LoginTicket;
import com.torchcoder.community.entity.User;
import com.torchcoder.community.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author HouYongJu
 * @create 2021-10-01 20:54
 */
public interface UserService extends CommunityConstant {
    public User findUserById(int id);

    public Map<String,Object> register(User user);

    public int activation(int userId, String code);

    public Map<String, Object> login(String username, String password, int expiredSeconds);

    void logout(String ticket);

    LoginTicket findLoginTicket(String ticket);

    public int updateHeader(int userId, String headerUrl);
}
