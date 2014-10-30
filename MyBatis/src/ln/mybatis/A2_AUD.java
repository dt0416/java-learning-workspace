package ln.mybatis;

import static org.junit.Assert.*;
import ln.mybatis.model.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Insert、Update、Delete
 * 
 * @author Ian Chen
 */
public class A2_AUD {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A2_AUD.class);

    @Before
    public void before() {
        // 透過MyBatisUtil建立SqlSession
        sqlSession = MyBatisUtil.createSession();
    }

    @After
    public void after() {
        MyBatisUtil.closeSession(sqlSession);
    }
    
    /**
     * 新增學生
     */
    @Test
    public void testInsert() {
        try {
            Student student = new Student();
            student.setId(9);
            student.setName("MyBatisTest");
            student.setEmail("mybatis@apache.org");
            student.setAge(18);
            sqlSession.insert("ln.mybatis.mapper.Student.insert", student);

            // 務必要commit
            sqlSession.commit();
            logger.info("Insert Finish");
        } catch (Exception ex) {
            sqlSession.rollback();
            logger.error("Insert fail", ex);
            fail("Insert fail");
        }
    }

    /**
     * 修改學生
     */
    @Test
    public void testUpdate() {
        try {
            Student student = new Student();
            student.setId(9);
            student.setName("MyBatisTest1");
            student.setEmail("mybatis1@apache.org");
            student.setAge(19);
            sqlSession.update("ln.mybatis.mapper.Student.update", student);
            
            // 務必要commit
            sqlSession.commit();
            logger.info("Update Finish");
        } catch (Exception ex) {
            sqlSession.rollback();
            logger.error("Update fail", ex);
            fail("Update fail");
        }
    }

    /**
     * 刪除學生
     */
    @Test
    public void testDelete() {
        try {
            sqlSession.delete("ln.mybatis.mapper.Student.delete", 9);
            
            // 務必要commit
            sqlSession.commit();
            logger.info("Delete Finish");
        } catch (Exception ex) {
            sqlSession.rollback();
            logger.error("Delete fail", ex);
            fail("Delete fail");
        }
    }
}
