package string;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
  
  @Test
  public void testSubstring2() {
    String testString =
        "\"頂級旅遊\":{\"URL\":\"http://tb.hhtravel.com/index_tw.html?departArea=TPE\", \"TITLE\":\"頂級旅遊\", \"NAME\":\"頂級旅遊\",";
    String oriUrl = testString.substring(testString.indexOf("http"),
        testString.indexOf("\"", testString.indexOf("http")));
    assertThat(oriUrl, is(equalTo("http://tb.hhtravel.com/index_tw.html?departArea=TPE")));
  }
}
