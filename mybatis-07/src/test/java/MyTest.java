import com.lu.dao.TeacherMapper;
import com.lu.pojo.Teacher;
import com.lu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testGetTeachers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    // 获取指定的老师的老师信息与他的学生的信息
    @Test
    public void testGetTeacherStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherStudent = mapper.getTeacherStudent(1);
        System.out.println(teacherStudent);
        sqlSession.close();
    }
}
