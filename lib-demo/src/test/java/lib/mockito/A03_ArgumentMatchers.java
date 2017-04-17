package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.LinkedList;

/**
 * stub的參數可以使用Matcher.
 *
 * @author Ian Chen
 */
public class A03_ArgumentMatchers {

  /**
   * Augument Matchers.
   *
   * @throws Exception
   */
  @Test
  public void testAugumentMatchers() throws Exception {
    //You can mock concrete classes, not only interfaces
    LinkedList mockedList = mock(LinkedList.class);

    //stubbing using built-in anyInt() argument matcher
    when(mockedList.get(anyInt())).thenReturn("element");

    //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
//    when(mockedList.contains(argThat(isValid()))).thenReturn("element"); // 需實作isValid方法

    //following prints "element"
    System.out.println(mockedList.get(999));

    //you can also verify using an argument matcher
    verify(mockedList).get(anyInt());
  }
}
