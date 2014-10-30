package ln.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import ln.mybatis.model.RoomWithUser;
import ln.mybatis.model.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * join範例
 * room與user關係為『1對多』
 * select結果可能多筆，但會將room distinct後映射至room
 * 並將user映射至room裡的user屬性
 * 
 * @author Ian Chen
 */
public class A7_JoinWithOneToMany {
    private SqlSession sqlSession;
    private static Logger logger = Logger.getLogger(A7_JoinWithOneToMany.class);

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
    public void testJoin() {
        try {
            List<RoomWithUser> rooms = sqlSession.selectList("ln.mybatis.mapper.Room.selectAllRoom");
            for (RoomWithUser roomWithUser : rooms) {
                logger.info("RoomId:" + roomWithUser.getId() + ", RoomAddress:" + roomWithUser.getAddress());
                for (User user : roomWithUser.getUsers()) {
                    logger.info("UserId:" + user.getId() + ", UserName:" + user.getName());
                }
            }
            logger.info("Finish");
        } catch (Exception ex) {
            logger.error("join with one to many fail", ex);
            fail("join with one to many fail");
        }
    }
}
