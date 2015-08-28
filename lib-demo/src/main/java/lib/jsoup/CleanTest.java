package lib.jsoup;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.junit.Test;

/**
 * The Class CleanTest.
 *
 * @author Ian Chen
 */
public class CleanTest {

  /**
   * 清除br、a以外的html tag.
   */
  @Test
  public void testClean() {
    String testString = "";
    String except = "";

    testString = "<p><span style=\"color: #ff0000\"><span style=\"font-family: 新細明體\"><span style=\"font-size: 14px\">※團費報價已包含：</span></span></span></p>test<br />";
    except = "※團費報價已包含：test\n<br>";

    Whitelist whitelist = Whitelist.none();
    whitelist.addTags("br");
    whitelist.addAttributes("a", "href", "target");
    System.out.println(Jsoup.clean(testString, whitelist));
    assertThat(Jsoup.clean(testString, whitelist), is(equalTo(except)));
  }

}
