package flow;

import java.util.List;

import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class ForeachTest {

  /**
   * 當物件是null，foreach時會丟出NullPointerException.
   */
  @SuppressWarnings("null")
  @Test(expected = NullPointerException.class)
  public void testNull() {
    List<String> strs = null;
    for (String eachStr : strs) {
      System.out.println(eachStr);
    }
  }

}
