package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <pre> NullString. </pre>
 *
 * @author Ian Chen
 */
public class NullString {

  /**
   * 與null連接的結果會加上「null」字串.
   */
  @Test
  public void testNullConnectString() {
    String nullString = null;
    String test = nullString + "test";
    assertEquals("nulltest", test);
    test = "test" + nullString;
    assertEquals("testnull", test);
  }

  /**
   * "".equals(null)的結果為false.
   */
  @Test
  public void testNullEquals() {
    String nullString = null;
    assertFalse("".equals(nullString));
  }

  /**
   * 第2個參數是null會丟出NullPointerException.
   */
  @Test(expected = NullPointerException.class)
  public void testNullReplace() {
    System.out.println("bbbaabbb".replace("aa", null));
  }
}
