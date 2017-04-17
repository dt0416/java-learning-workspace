package lib.mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.exceptions.verification.NoInteractionsWanted;

import java.util.List;

/**
 * 是否有呼叫後尚未驗證的方法.
 *
 * @author Ian Chen
 */
public class A08_VerifyMoreInteraction {

  @Test(expected = NoInteractionsWanted.class)
  public void testFindingRedundantInvocation() {
    List mockedList = mock(List.class);

    //using mocks
    mockedList.add("one");
    mockedList.add("two");

    verify(mockedList).add("one");
    verify(mockedList).add("two");

    //following verification will success
    verifyNoMoreInteractions(mockedList);

    mockedList.add("three");
    // following verification will fail
    verifyNoMoreInteractions(mockedList);
  }
}
