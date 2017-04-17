package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.List;

/**
 * 驗證mock的是否有執行method.
 *
 * @author Ian Chen
 */
public class A01_Verify {

  /**
   * veryfy.
   */
  @Test
  public void testVerify() {
    List mockedList = mock(List.class);

    //using mock object
    mockedList.add("one");
    mockedList.clear();

    //verification
    verify(mockedList).add("one");
    verify(mockedList).clear();
  }
}
