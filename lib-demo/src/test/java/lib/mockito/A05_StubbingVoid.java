package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 幫mock放入stub假物件，並實作其void方法.
 *
 * @author Ian Chen
 */
public class A05_StubbingVoid {

  /**
   * Stubbing void.
   */
  @Test(expected = RuntimeException.class)
  public void testStubbingVoid() {
    //You can mock concrete classes, not only interfaces
    LinkedList mockedList = mock(LinkedList.class);

    //stubbing void
    doThrow(new RuntimeException()).when(mockedList).clear();

    //following throws RuntimeException:
    mockedList.clear();
  }
}
