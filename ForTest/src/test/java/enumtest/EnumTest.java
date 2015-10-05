package enumtest;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * <pre> EnumTest </pre>
 *
 * @author Ian Chen
 */
public class EnumTest {

  /**
   * 確定順序會照著enum宣告的順序foreach
   */
  @Test
  public void testForeach() {
    String result = "";
    for (MyEnum myEnum : MyEnum.values()) {
      result += myEnum;
    }
    assertEquals("ONETWOTHREE", result);
  }
  
  /**
   * 使用 == 可以正式執行，值為false.
   */
  @Test
  public void testNullWithEqual() {
    MyEnum nothing = null;
    assertFalse(nothing == MyEnum.ONE);
  }

  /**
   * 使用equals會產生NullPointerException.
   */
  @Test(expected = NullPointerException.class)
  public void testNullWithEquals() {
    MyEnum nothing = null;
    assertFalse(nothing.equals(MyEnum.ONE));
  }
}


enum MyEnum {
  ONE, TWO, THREE
}