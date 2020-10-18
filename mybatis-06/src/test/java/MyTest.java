import com.lu.dao.StudentMapper;
import com.lu.dao.TeacherMapper;
import com.lu.pojo.Student;
import com.lu.pojo.Teacher;
import com.lu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testGetTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testGetStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> student = mapper.getStudent();
        for (Student stu : student) {
            System.out.println(stu);
        }

        sqlSession.close();
    }

    @Test
    public void testGetStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> student = mapper.getStudent2();
        for (Student stu : student) {
            System.out.println(stu);
        }

        sqlSession.close();
    }
}
