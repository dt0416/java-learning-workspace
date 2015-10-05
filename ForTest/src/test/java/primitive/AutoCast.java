package primitive;

import org.junit.Test;

/**
 * <pre> AutoCast </pre>
 *
 * @author Ian Chen
 */
public class AutoCast {

  @Test
  public void test_long() {
    long a = 1;
    long b = 10;
    System.out.println(a / b); // 0
  }

  @Test
  public void test_float() {
    float a = 1;
    float b = 10;
    System.out.println(a / b); // 0.1
  }
}
