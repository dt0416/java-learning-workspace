package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 驗證方法被呼叫次數.
 *
 * @author Ian Chen
 */
public class A04_VerifyCount {

  /**
   * Verifying exact number of invocations / at least x / never.
   */
  @Test
  public void testVeryfyCount() {
    //You can mock concrete classes, not only interfaces
    LinkedList mockedList = mock(LinkedList.class);

    //using mock
    mockedList.add("once");

    mockedList.add("twice");
    mockedList.add("twice");

    mockedList.add("three times");
    mockedList.add("three times");
    mockedList.add("three times");

    //following two verifications work exactly the same - times(1) is used by default
    verify(mockedList).add("once");
    verify(mockedList, times(1)).add("once");

    //exact number of invocations verification
    verify(mockedList, times(2)).add("twice");
    verify(mockedList, times(3)).add("three times");

    //verification using never(). never() is an alias to times(0)
    verify(mockedList, never()).add("never happened");

    //verification using atLeast()/atMost()
    verify(mockedList, atLeastOnce()).add("three times");
//    verify(mockedList, atLeast(2)).add("five times"); // 沒有2次，會出錯
    verify(mockedList, atMost(5)).add("three times");
  }
}
