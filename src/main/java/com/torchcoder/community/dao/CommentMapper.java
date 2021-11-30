package com.torchcoder.community.dao;


import com.torchcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     *  分页查询帖子的评论
     * @param entityType 评论类型
     * @param entityId 具体某个帖子ID
     */
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    int selectCountByEntity(int entityType, int entityId);

    int insertComment(Comment comment);

    Comment selectCommentById(int id);
}
