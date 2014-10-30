package ln.mybatis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ln.mybatis.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 使用MyBatisUtil取得SqlSession
 * @author Ian Chen
 */
public class A1_UseUtil {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A1_UseUtil.class);

    @Before
    public void before() {
        // 透過MyBatisUtil建立SqlSession
        sqlSession = MyBatisUtil.createSession();
    }

    @After
    public void after() {
        MyBatisUtil.closeSession(sqlSession);
    }
    
    @Test
    public void testUseMyBatisUtil() {
        // 撈取全部學生
        List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectAllStudent");
        for (Student student : students) {
            logger.info("ID:" + student.getId() + ", Name:" + student.getName());
        }
        logger.info("Finish");
    }
}
