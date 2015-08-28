package primitive;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <pre> int與Integer的差異 </pre>
 *
 * @author Ian Chen
 */
public class IntVsInteger {

  /**
   * Test equals.
   */
  @Test
  public void testEquals() {
    // Integer只會cache的範圍-128~127，超過這範圍Integer用==就會出問題
    int intZero = 128;
    Integer integerZero = intZero;
    Integer integerZero2 = intZero;
    
    // true
    assertTrue(intZero == integerZero);
    assertTrue(integerZero.equals(intZero));

    // false
    assertFalse(integerZero == integerZero2); // 就算是基本型別的Wrapper物件也不可以使用==
  }

  /**
   * Test equals2.
   */
  @Test
  public void testEquals2() {
    Integer i = 123;
    assertTrue(i.toString().equals("123"));
    assertTrue(i.equals(123));

    assertFalse(i.equals(null));
    assertFalse(i.equals("123"));

    assertEquals(0, -1 / 40);
  }
}
