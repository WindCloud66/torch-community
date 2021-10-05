package com.torchcoder.community.MapperTest;

import com.torchcoder.community.dao.DiscussPostMapper;
import com.torchcoder.community.dao.LoginTicketMapper;
import com.torchcoder.community.dao.MessageMapper;
import com.torchcoder.community.dao.UserMapper;
import com.torchcoder.community.entity.DiscussPost;
import com.torchcoder.community.entity.LoginTicket;
import com.torchcoder.community.entity.Message;
import com.torchcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author HouYongJu
 * @create 2021-10-01 18:21
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        //liubei
        User byName = userMapper.selectByName("liubei");
        System.out.println(byName);

        User user1 = userMapper.selectByEmail("nowcoder21@sina.com");
        System.out.println(user1);

    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
//        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
//        for(DiscussPost post : list) {
//            System.out.println(post);
//        }
//
//        int rows = discussPostMapper.selectDiscussPostRows(0);
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(158);
        discussPost.setTitle("wind");
        discussPost.setContent("cloud");
        int i = discussPostMapper.insertDiscussPost(discussPost);
        System.out.println(i);
    }

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc", 1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }


    @Test
    public void testSelectLetters() {
        List<Message> list = messageMapper.selectConversations(111, 0, 20);
        for (Message message : list) {
            System.out.println(message);
        }
        System.out.println("-----------------------------------");
        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);
        System.out.println("-----------------------------------");
        list = messageMapper.selectLetters("111_112", 0, 10);
        for (Message message : list) {
            System.out.println(message);
        }
        System.out.println("-----------------------------------");
        count = messageMapper.selectLetterCount("111_112");
        System.out.println(count);
        System.out.println("-----------------------------------");
        count = messageMapper.selectLetterUnreadCount(131, "111_131");
        System.out.println(count);

    }
}
