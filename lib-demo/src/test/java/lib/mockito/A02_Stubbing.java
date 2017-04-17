package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 幫mock放入stub假物件.
 *
 * @author Ian Chen
 */
public class A02_Stubbing {

  /**
   * Stubbing.
   */
  @Test
  public void testStubbing() {
    //You can mock concrete classes, not only interfaces
    LinkedList mockedList = mock(LinkedList.class);

    //stubbing
    when(mockedList.get(0)).thenReturn("first");
    // 相同於上一行，doReturn/when可以使用在void方法，when/thenReturn只可使用在「非void」方法
    doReturn("first").when(mockedList).get(0);
    when(mockedList.get(1)).thenThrow(new RuntimeException());

    //following prints "first"
    System.out.println(mockedList.get(0));

    //following throws runtime exception
//    System.out.println(mockedList.get(1)); // 會丟出RuntimeExceptiono

    //following prints "null" because get(999) was not stubbed
    System.out.println(mockedList.get(999));

    //Although it is possible to verify a stubbed invocation, usually it's just redundant
    //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
    //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
    verify(mockedList).get(0);
  }
}
