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

  @Test
  public void testToArray() {
    List<String> strs = new ArrayList<String>();
    strs.add("A");
    strs.add("B");
    strs.add("C");
    assertThat(strs.toArray(new String[strs.size()]), equalTo(strs.toArray(new String[0]))); // 陣列長度小於list size
    assertThat(strs.toArray(new String[strs.size()]), equalTo(strs.toArray(new String[3]))); // 陣列長度等於list size
    assertThat(strs.toArray(new String[strs.size()]), not(equalTo(strs.toArray(new String[4])))); // 陣列長度超過list size
//    System.out.println(strs.toArray(new String[strs.size()]).length);
  }
  
  @Test
  public void testSubList() {
    List<String> strs = new ArrayList<String>();
    strs.add("A");
    strs.add("B");
    strs.add("C");

    //  IndexOutOfBoundsException
    System.out.println(strs.subList(0, 4));
  }
}
