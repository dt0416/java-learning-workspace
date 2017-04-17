package lib.mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.List;

/**
 * 驗證互動.
 *
 * @author Ian Chen
 */
public class A07_VerifyInteraction {

  /**
   * Verify Interaction.
   */
  @Test
  public void testVerifyInteraction() {
    List mockOne = mock(List.class);
    List mockTwo = mock(List.class);
    List mockThree = mock(List.class);

    //using mocks - only mockOne is interacted
    mockOne.add("one");

    //ordinary verification
    verify(mockOne).add("one");

    //verify that method was never called on a mock
    verify(mockOne, never()).add("two");

    //verify that other mocks were not interacted
    verifyZeroInteractions(mockTwo, mockThree);
  }
}
