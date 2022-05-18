package exception;

import org.junit.Test;

public class ExTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      new ThrowException().calculate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testFinallyAndReturn() {
    System.out.println(testStr());
  }
  
  /**
   * 會先跑完Finally再return
   */
  private String testStr() {
    try {
      return "Test";
    } finally {
      System.out.println("Finally");
    }
  }

}
