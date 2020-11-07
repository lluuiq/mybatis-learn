import com.lu.dao.UserMapper;
import com.lu.pojo.User;
import com.lu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void queryUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        System.out.println("=======================mapper 查询，一级二级都没缓存，走数据库, 查询ID=1的用户");
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("=======================sqlSession.close() 将查询结果丢到二级缓存");
        sqlSession.close();

        System.out.println("=======================mapper2 查询，发现了sqlSession.close()丢到二级缓存中的 ID=1的用户数据，走二级缓存");
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);

        System.out.println("====================== mapper2 查询，二级没有ID=2的用户，一级也没找到，走数据库");
        User user3 = mapper2.queryUserById(2);
        System.out.println(user3);

        System.out.println("====================== mapper2 查询，二级没有ID=2的用户，一级里找到了刚刚查询出来的缓存，走一级缓存");
        User user4 = mapper2.queryUserById(2);
        System.out.println(user4);

        sqlSession2.close();
    }
}
