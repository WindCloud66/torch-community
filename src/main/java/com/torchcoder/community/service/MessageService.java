package com.torchcoder.community.service;


import com.torchcoder.community.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {


    // 查询当前用户的会话列表,针对每个会话只返回一条最新的私信.
    public List<Message> findConversations(int userId, int offset, int limit);
    // 查询当前用户的会话数量.
    public int findConversationCount(int userId);
    // 查询某个会话所包含的私信列表.
    public List<Message> findLetters(String conversationId, int offset, int limit);
    // 查询某个会话所包含的私信数量.
    public int findLetterCount(String conversationId) ;
    // 查询未读私信的数量
    public int findLetterUnreadCount(int userId, String conversationId) ;
    // 添加私信
    public int addMessage(Message message);
    // 读取私信
    public int readMessage(List<Integer> ids);
    // 查询某个主题下最新的通知
    public Message findLatestNotice(int userId, String topic);
    // 查询某个主题所包含的通知数量
    public int findNoticeCount(int userId, String topic);
    // 查询未读的通知的数量
    public int findNoticeUnreadCount(int userId, String topic);

    List<Message> findNotices(int id, String topic, int offset, int limit);
}
