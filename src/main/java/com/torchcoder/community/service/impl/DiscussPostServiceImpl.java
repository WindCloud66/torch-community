package com.torchcoder.community.service.impl;

import com.torchcoder.community.dao.DiscussPostMapper;
import com.torchcoder.community.entity.DiscussPost;
import com.torchcoder.community.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HouYongJu
 * @create 2021-10-01 20:50
 */
@Service
public class DiscussPostServiceImpl implements DiscussPostService {
    @Autowired
    DiscussPostMapper discussPostMapper;

    @Override
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    @Override
    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
