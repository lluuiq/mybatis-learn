import com.lu.dao.BlogMapper;
import com.lu.pojo.Blog;
import com.lu.utils.IDutils;
import com.lu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        //blog.setId(IDutils.getID());
        blog.setId("1");
        blog.setTitle("Mybatis-foreach");
        blog.setAuthor("测试foreach");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBook(blog);

        //blog.setId(IDutils.getID());
        blog.setId("2");
        blog.setTitle("Java-foreach");
        mapper.addBook(blog);

        //blog.setId(IDutils.getID());
        blog.setId("3");
        blog.setTitle("Spring-foreach");
        mapper.addBook(blog);

        //blog.setId(IDutils.getID());
        blog.setId("4");
        blog.setTitle("微服务-foreach");
        mapper.addBook(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIFTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title", "Java");
        hashMap.put("author", "狂神说");

        List<Blog> blogs = mapper.queryBlogIF(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogIF2Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title", "Spring");
        hashMap.put("author", "狂神说");

        List<Blog> blogs = mapper.queryBlogIF2(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        //hashMap.put("title", "Java");
        //hashMap.put("author", "狂神说");
        hashMap.put("views", 9999);

        List<Blog> blogs = mapper.queryBlogChoose(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        map.put("title", "java2");
        map.put("author", "lluuiq");
        map.put("id", "a73302c51c9f4cacb5eda193b2c471c0");

        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeachTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}