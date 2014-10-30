package ln.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisUtil {
    private static SqlSessionFactory factory;
    private static Logger logger = Logger.getLogger(MyBatisUtil.class);
    
    static {
        try {
            String resource = "ln/mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            
            // 建立SqlSessionFactory
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException ex) {
            logger.error(ex);
        }
    }
    
    public static SqlSession createSession() {
        return factory.openSession();
    }
    
    public static void closeSession(SqlSession session) {
        if (session != null) session.close();
    }
}
