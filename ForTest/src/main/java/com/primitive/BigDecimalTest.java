package com.primitive;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * <pre> BigDecimalTest </pre>
 *
 * @author Ian Chen
 */
public class BigDecimalTest {

  @Test
  public void test百分比() {
    BigDecimal percentExcept = new BigDecimal("0.6"); // 60%，BigDecimal建議使用String的建構子
    BigDecimal percentRight = new BigDecimal(60).divide(new BigDecimal(100)); // 60%
    BigDecimal percentWrong = new BigDecimal(60 / 100); // 0%

    assertEquals("0.6", percentExcept.toString());
    assertEquals("0.6", percentRight.toString());
    
    assertEquals("0", percentWrong.toString());
    
    assertTrue(percentExcept.compareTo(percentRight) == 0);
    assertFalse(percentExcept.compareTo(percentWrong) == 0); // 不等於要注意
  }
  
  @Test
  public void test除完取整數() {
    BigDecimal b = new BigDecimal("21.8").divide(new BigDecimal("2")); // 10.9
    int i = b.intValue();
    assertEquals("10.9", b.toString());
    assertEquals(10, i);
  }

  @Test
  public void testCompare() {
    BigDecimal b_neg1 = new BigDecimal(-1);
    BigDecimal b_0 = new BigDecimal(0);
    BigDecimal b_1 = new BigDecimal(1);
    
    assertEquals(-1, b_0.compareTo(b_1)); // 小於，0 < 1
    assertEquals(0, b_0.compareTo(b_0)); // 等於，0 = 0
    assertEquals(1, b_0.compareTo(b_neg1)); // 大於，0 > -1
  }
}
