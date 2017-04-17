package lib.jsoup;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    assertThat(Jsoup.clean(testString, whitelist), is(equalTo(except)));
  }

  /**
   * 測試輸出不再對文字做格式化(加上斷行之類的處理)
   */
  @Test
  public void testCleanHasBreakLine() {
    String testString = "";
    String except = "";

    testString = "團費報價已包含：<br />bbb <a href=\"link\">ccc</a>ddd\neee";

    Whitelist whitelist = Whitelist.none();
    whitelist.addTags("br");
    whitelist.addAttributes("a", "href", "target");

    except = "團費報價已包含：\n<br>bbb \n<a href=\"link\">ccc</a>ddd eee"; // <br />變成<br>，白名單前都加上\n，原\n變成空白
    assertThat(Jsoup.clean(testString, whitelist), is(equalTo(except)));

    except = "團費報價已包含：<br>bbb <a href=\"link\">ccc</a>ddd\neee"; // <br />變成<br>
    assertThat(Jsoup.clean(testString, "", whitelist, new Document.OutputSettings().prettyPrint(false)), is(equalTo(except)));
  }
}
