package ln.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * TestSuite可同時測試多個測試類別
 * 
 * @author Ian Chen
 */
@RunWith(Suite.class)
@SuiteClasses({A1_JUnitTestVer3.class, A2_JUnitTestVer4.class, A3_CombineHamcrest.class})
public class A4_TestSuite {

}
