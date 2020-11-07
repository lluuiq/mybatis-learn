package com.lu.dao;

import com.lu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    int addBook(Blog blog);

    // 查询博客
    List<Blog> queryBlogIF(Map map);
    // sql片段实现
    List<Blog> queryBlogIF2(Map map);

    // 查询指定的博客
    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogTrim(Map map);

    // 更新博客
    int updateBlog(Map map);

    // foreach 查询第1、2、3号的博客
    List<Blog> queryBlogForeach(Map map);
}
