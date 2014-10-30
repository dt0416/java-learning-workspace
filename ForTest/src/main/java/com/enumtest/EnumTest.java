package com.enumtest;

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

}


enum MyEnum {
  ONE, TWO, THREE
}