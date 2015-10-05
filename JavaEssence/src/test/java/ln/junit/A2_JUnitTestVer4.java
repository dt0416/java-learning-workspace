package ln.junit;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 如何產生此Class:New -> JUnit Test Case, 選擇New JUnit 4 test<br />
 * Class under test:選擇MyMath<br />
 * 通常@Before的方法會命名成setUp, 在@After會命名成tearDown與Junit3版本較一致
 * 測試方法: Run As -> JUnit Test<br />
 * 
 * @author Ina Chen
 */
public class A2_JUnitTestVer4 {
    private static Logger logger = Logger.getLogger(A2_JUnitTestVer4.class);

    /**
     * 在此Class測試前執行此方法
     * 必須為static
     * 只會執行一次
     */
    @BeforeClass
    public static void init() {
        logger.info("init");
    }
    
    /**
     * 在此Class測試後執行此方法
     * 必須為static
     * 只會執行一次
     */
    @AfterClass
    public static void destory() {
        logger.info("destory");
    }
    
    /**
     * 每個測試方法前皆會執行
     * 需加上@Before
     */
    @Before
    public void setUp() {
        logger.info("setUp");
    }
    
    /**
     * 每個測試方法後皆會執行
     * 需加上@After
     */
    @After
    public void tearDown() {
        logger.info("tearDown");
    }

	@Test
	public void testDiv() {
        logger.info("testDiv");
		assertEquals(5, new MyMath().div(10, 2));
	}

    @Test
    public void testEmpty() {
        logger.info("testEmpty");
    }
    
    
    /**
     * 測試確定會拋出ArithmeticException
     */
    @Test(expected=ArithmeticException.class)
    public void testThrowException() {
        logger.info("testThrowException");
        int retult = new MyMath().div(10, 0);
        logger.info(retult);
    }
    
    /**
     * 測試執行期間小於10毫秒
     */
    @Test(timeout=10)
    public void testRunDuration() {
        logger.info("testRunDuration");
    }
}
