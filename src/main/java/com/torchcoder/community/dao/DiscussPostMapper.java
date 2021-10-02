package com.torchcoder.community.dao;

import com.torchcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HouYongJu
 * @create 2021-10-01 20:23
 */
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    // 只有一个参数,并且在<if>里使用,则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
