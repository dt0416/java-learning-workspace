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
 * 分頁Sql，需根據不同DB在mapper裡撰寫不同SQL
 * 
 * @author Ian Chen
 */
public class A5_PagingSql {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A5_PagingSql.class);

    @Before
    public void before() {
        // 透過MyBatisUtil建立SqlSession
        sqlSession = MyBatisUtil.createSession();
    }

    @After
    public void after() {
        MyBatisUtil.closeSession(sqlSession);
    }
    
    private static final int PAGE_SIZE = 3; // 每頁顯示筆數
    private static final int PAGE_OFFSET = 1; // 頁數
    @Test
    public void testPaging() {
        try {
            Map para = new HashMap();
            para.put("pageOffset", (PAGE_OFFSET-1)*PAGE_SIZE);
            para.put("pageSize", PAGE_SIZE);
            List<Student> students = sqlSession.selectList("ln.mybatis.mapper.Student.selectPagingStudent", para);
            for (Student student : students) {
                logger.info("ID:" + student.getId() + ", Name:" + student.getName());
            }
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("paging sql fail", ex);
            fail("paging sql fail");
        }
    }
    
    @Test
    public void testPagingCount() {
        try {
            Map para = new HashMap();
            int count = sqlSession.selectOne("ln.mybatis.mapper.Student.selectPagingStudentCount");
            logger.info("pagingCount:" + count);
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("paging sql count fail", ex);
            fail("paging sql count fail");
        }
    }
}
