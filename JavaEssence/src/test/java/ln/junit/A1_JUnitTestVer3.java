package ln.junit;

import org.apache.log4j.Logger;

import junit.framework.TestCase;
import ln.reflection.A1_NewObject;

/**
 * 如何產生此Class:New -> JUnit Test Case, 選擇New JUnit 3 test<br />
 * Class under test:選擇MyMath<br />
 * 繼承TestCase，測試方法為test開頭<br />
 * setUp = @Before, tearDown = @After<br />
 * 測試方法: Run As -> JUnit Test<br />
 * 
 * @author Ina Chen
 */
public class A1_JUnitTestVer3 extends TestCase {
    private static Logger logger = Logger.getLogger(A1_JUnitTestVer3.class);

    @Override
    protected void setUp() throws Exception {
        logger.info("setUp");
    }

    @Override
    protected void tearDown() throws Exception {
        logger.info("tearDown");
    }

    
	public void testDiv() {
	    logger.info("testDiv");
		assertEquals(new MyMath().div(10, 2), 5);
	}
}
