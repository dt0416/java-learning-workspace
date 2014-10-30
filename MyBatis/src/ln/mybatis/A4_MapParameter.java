package ln.mybatis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ln.mybatis.model.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * parameter為多個值使用map傳遞
 * 
 * @author Ian Chen
 */
public class A4_MapParameter {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A4_MapParameter.class);

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
    public void testMultiParameter() {
        try {
            Map para = new HashMap();
            para.put("name", "%Mybatis%");
            para.put("age", 19);
            List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectMutliWhere", para);
            for (Student student : students) {
                logger.info("ID:" + student.getId() + ", Name:" + student.getName());
            }
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("select mutli paramter fail", ex);
            fail("select mutli paramter fail");
        }
    }
    
    @Test
    public void testMultiParameter2() {
        try {
            Map para = new HashMap();
            para.put("name", "%Mybatis%");
            para.put("age", 19);
            List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectMutliWhere2", para);
            for (Student student : students) {
                logger.info("ID:" + student.getId() + ", Name:" + student.getName());
            }
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("select mutli paramter2 fail", ex);
            fail("select mutli paramter2 fail");
        }
    }
}
