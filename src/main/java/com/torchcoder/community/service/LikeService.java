package com.torchcoder.community.service;


import org.springframework.stereotype.Service;

@Service
public interface LikeService {

    // 点赞
    public void like(int userId, int entityType, int entityId);

    // 查询某实体点赞的数量
    public long findEntityLikeCount(int entityType, int entityId) ;

    // 查询某人对某实体的点赞状态
    public int findEntityLikeStatus(int userId, int entityType, int entityId);

}
