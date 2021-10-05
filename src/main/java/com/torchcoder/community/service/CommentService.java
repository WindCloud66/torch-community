package com.torchcoder.community.service;

import com.torchcoder.community.entity.Comment;

import java.util.List;

/**
 * @author HouYongJu
 * @create 2021-10-04 19:59
 */
public interface CommentService {
    // 返回评论
    public List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit) ;
    // 返回评论数量
    public int findCommentCount(int entityType, int entityId);

    public int addComment(Comment comment);
}
