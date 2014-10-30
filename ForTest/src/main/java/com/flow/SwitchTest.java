package com.flow;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <pre> SwitchTest. </pre>
 *
 * @author Ian Chen
 */
public class SwitchTest {

  /**
   * Test fall through, 這是個很危險的示範，使用時要注意.
   */
  @Test
  public void testFallThrough() {
    assertEquals("0", isOddOrEven(0));
    
    assertEquals("13579", isOddOrEven(1)); // 1、3、5、7、9的敘述皆被執行
    assertEquals("3579", isOddOrEven(3)); // 3、5、7、9的敘述皆被執行
    assertEquals("579", isOddOrEven(5)); // 5、7、9的敘述皆被執行
    assertEquals("79", isOddOrEven(7)); // 7、9的敘述皆被執行
    assertEquals("9", isOddOrEven(9)); // 9的敘述皆被執行

    assertEquals("2468", isOddOrEven(2)); // 2、4、6、8的敘述皆被執行
    assertEquals("468", isOddOrEven(4)); // 4、6、8的敘述皆被執行
    assertEquals("68", isOddOrEven(6)); // 6、8的敘述皆被執行
    assertEquals("8", isOddOrEven(8)); // 8的敘述皆被執行
}

  private String isOddOrEven(int value) {
    String result = "";
    switch (value)
    {
      case 0:
        result += "0";
        break;
      case 1:
        result += "1";
      case 3:
        result += "3";
      case 5:
        result += "5";
      case 7:
        result += "7";
      case 9:
         result += "9";
         break;
      case 2:
        result += "2";
      case 4:
        result += "4";
      case 6:
        result += "6";
      case 8:
        result += "8";
        break;
    }
    return result;
  }
}
