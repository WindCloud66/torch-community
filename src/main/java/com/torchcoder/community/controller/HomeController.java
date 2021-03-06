package com.torchcoder.community.controller;

import com.torchcoder.community.entity.DiscussPost;
import com.torchcoder.community.entity.Page;
import com.torchcoder.community.entity.User;
import com.torchcoder.community.service.DiscussPostService;
import com.torchcoder.community.service.LikeService;
import com.torchcoder.community.service.UserService;
import com.torchcoder.community.util.CommunityConstant;
import com.torchcoder.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HouYongJu
 * @create 2021-10-01 21:02
 */
@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        // spring MVC 自动实例化 Model 和 Page, 并将Page注入 Model
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        // Map 对应者 帖子 以及 发帖用户
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        // TODO userService.findUserById(post.getUserId()); 可以使用batch批量查询减小对数据库的访问
        if(list != null){
            for(DiscussPost post : list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);

                long likeCount = likeService.findEntityLikeCount(CommunityConstant.ENTITY_TYPE_POST, post.getId());
                map.put("likeCount", likeCount);

                discussPosts.add(map);

            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(@CookieValue("ticket") String ticket) {
        // TODO ticket 全表扫描
        userService.logout(ticket);
        return "redirect:/login";
    }


    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }

}
