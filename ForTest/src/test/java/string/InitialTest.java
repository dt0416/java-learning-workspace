package string;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 測試class變數/Object變數 初始化的差異
 * 原生型別/物件的差異
 * 結論：
 *   原生型別自動會有初始值
 *   物件型別(包含String)則為null
 * 
 * @author Ian Chen
 */
public class InitialTest {
  /**
   * Class/Object變數可以不用初始化
   */
  private static int classStaticInt; // 0
  private static Integer classStaticInteger; // null
  private static String classStaticString; // null
  private int classInt; // 0
  private Integer classInteger; // null
  private String classString; // null
  private BigDecimal price;

  @Test
  public void testClassVariable() {
    assertEquals(0, classStaticInt); // int
    assertEquals(null, classStaticInteger);
    assertEquals(null, classStaticString);
  }

  @Test
  public void testObjectVariable() {
    assertEquals(0, new InitialTest().classInt); // int
    assertEquals(null, new InitialTest().classInteger);
    assertEquals(null, new InitialTest().classString);
    assertEquals(null, new InitialTest().price);
  }

  /**
   * 區域變數一定要初始化
   */
  @Test
  public void testLocalVariable() {
    int methodInteger = 0;
    String methodString = "This is test";

    assertEquals(0, methodInteger);
    assertEquals("This is test", methodString);
  }

}
