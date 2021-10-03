package com.torchcoder.community.util;

import com.torchcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author HouYongJu
 * @create 2021-10-03 14:49
 */
@Component
public class HostHolder {

    private  ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }

}
