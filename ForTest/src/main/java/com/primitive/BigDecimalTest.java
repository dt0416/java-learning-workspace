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
  public void testBigDecimal百分比() {
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
  public void testBigDecimal除完取整數() {
    BigDecimal b = new BigDecimal("21.8").divide(new BigDecimal("2"));
    int i = b.intValue();
//    Decimal
//    Math.floor(a)
    assertEquals("10.9", b.toString());
    assertEquals(10, i);
  }
}
