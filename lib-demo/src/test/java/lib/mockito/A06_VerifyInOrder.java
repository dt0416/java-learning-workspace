package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.List;

/**
 * 驗證方法被呼叫順序.
 *
 * @author Ian Chen
 */
public class A06_VerifyInOrder {

  /**
   * 單一物件方法被呼叫順序.
   */
  @Test
  public void testVeryfyInOrderWithSingleMock() {
    // A. Single mock whose methods must be invoked in a particular order
    List singleMock = mock(List.class);

    //using a single mock
    singleMock.add("was added first");
    singleMock.add("was added second");

    //create an inOrder verifier for a single mock
    InOrder inOrder = inOrder(singleMock);

    //following will make sure that add is first called with "was added first, then with "was added second"
    inOrder.verify(singleMock).add("was added first");
    inOrder.verify(singleMock).add("was added second");
  }

  /**
   * 多個物件方法被呼叫順序.
   */
  @Test
  public void testVeryfyInOrderWithMultiMock() {
    // B. Multiple mocks that must be used in a particular order
    List firstMock = mock(List.class);
    List secondMock = mock(List.class);

    //using mocks
    firstMock.add("was called first");
    secondMock.add("was called second");

    //create inOrder object passing any mocks that need to be verified in order
    InOrder inOrder = inOrder(firstMock, secondMock);

    //following will make sure that firstMock was called before secondMock
    inOrder.verify(firstMock).add("was called first");
    inOrder.verify(secondMock).add("was called second");

    // Oh, and A + B can be mixed together at will
  }
}
