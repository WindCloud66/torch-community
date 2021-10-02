package com.torchcoder.community.service;

import com.torchcoder.community.entity.DiscussPost;

import java.util.List;

/**
 * @author HouYongJu
 * @create 2021-10-01 20:48
 */

public interface DiscussPostService {
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit);

    public int findDiscussPostRows(int userId);
}
