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
 * 第一支MyBatis範例
 * 
 * @author Ian Chen
 */
public class A0_FirstMyBatis {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A0_FirstMyBatis.class);

    @Before
    public void before() {
        String resource = "ln/mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 建立SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 建立SqlSession
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        sqlSession.close();
    }
    
    @Test
    public void testFirstMyBatis() {
        List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectAllStudent");
        for (Student student : students) {
            logger.info("ID:" + student.getId() + ", Name:" + student.getName());
        }
        logger.info("Finish");
    }
}
