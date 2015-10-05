package string;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
 * <pre> SubstringTest. </pre>
 *
 * @author Ian Chen
 */
public class SubstringTest {

  @Test
  public void testSubstring() {
    String testString  = "12:34";
    assertThat(testString.substring(0, 2), is(equalTo("12")));
    assertThat(testString.substring(3, 5), is(equalTo("34")));
  }
}
