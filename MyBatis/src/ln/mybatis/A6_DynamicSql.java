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
 * 動態Sql
 * 
 * @author Ian Chen
 */
public class A6_DynamicSql {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A6_DynamicSql.class);

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
    public void testDynamic() {
        try {
            Map para = new HashMap();
            Map paraNoFilter = new HashMap();
            para.put("name", "%Mybatis%");
            para.put("age", 20);
            List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectDynamicStudent", para);
            List<Student> studentsNoFilter = sqlSession.selectList("ln.mybatis.mapper.Student.selectDynamicStudent", paraNoFilter);
            assertNotSame(students.size(), studentsNoFilter.size()); // 驗證筆數不一樣多
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("dynamic sql fail", ex);
            fail("dynamic sql fail");
        }
    }
}
