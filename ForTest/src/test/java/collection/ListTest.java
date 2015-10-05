package collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class ListTest {

  /**
   * 多個同樣的值仍會存在多個不會剩1個.
   */
  @Test
  public void testMultiNull() {
    List<String> strs = new ArrayList<String>();
    strs.add(null);
    strs.add(null);
    strs.add("A");
    assertThat(strs.size(), equalTo(3));
//    for (String string : strs) {
//      System.out.println(string);
//    }
  }
}
