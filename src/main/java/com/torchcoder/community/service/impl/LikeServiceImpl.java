package com.torchcoder.community.service.impl;

import com.torchcoder.community.service.LikeService;
import com.torchcoder.community.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author HouYongJu
 * @create 2021-10-06 15:26
 */
@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void like(int userId, int entityType, int entityId) {
        // 生成redis中点赞的key
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(entityType, entityId);
        // 点赞功能 没有则点赞 存在则取消
        boolean isMember = redisTemplate.opsForSet().isMember(entityLikeKey, userId);
        if (isMember) {
            redisTemplate.opsForSet().remove(entityLikeKey, userId);
        } else {
            redisTemplate.opsForSet().add(entityLikeKey, userId);
        }
    }

    @Override
    public long findEntityLikeCount(int entityType, int entityId) {
        // 查询某实体点赞的数量
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(entityType, entityId);
        return redisTemplate.opsForSet().size(entityLikeKey);
    }

    @Override
    public int findEntityLikeStatus(int userId, int entityType, int entityId) {
        // 查询某人对某实体的点赞状态
        String entityLikeKey = RedisKeyUtil.getEntityLikeKey(entityType, entityId);
        return redisTemplate.opsForSet().isMember(entityLikeKey, userId) ? 1 : 0;
    }
}
