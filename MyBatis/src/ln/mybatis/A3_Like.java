package ln.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import ln.mybatis.model.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 使用like
 * 必需將百分比(%)加在參數裡，無法直接寫在mapping xml裡
 * 
 * @author Ian Chen
 */
public class A3_Like {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A3_Like.class);

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
    public void testLike() {
        try {
            List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectLike", "%Batis%");
            for (Student student : students) {
                logger.info("ID:" + student.getId() + ", Name:" + student.getName());
            }
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("select like fail", ex);
            fail("select like fail");
        }
    }
}
