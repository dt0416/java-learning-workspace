package string;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * The Class CommonMethod.
 *
 * @author Ian Chen
 */
public class CommonMethod {

  /**
   * Test split.
   */
  @Test
  public void testSplit() {
    String testString = "";
    String[] except = {};

    testString = "";
    except = new String[]{""};
    assertThat(testString.split("/"), is(equalTo(except)));
    
    testString = "aaa";
    except = new String[]{"aaa"};
    assertThat(testString.split("/"), is(equalTo(except)));

    testString = "aaa/bbb";
    except = new String[]{"aaa", "bbb"};
    assertThat(testString.split("/"), is(equalTo(except)));

    testString = "aaa/bbb/";
    except = new String[]{"aaa", "bbb"};
    assertThat(testString.split("/"), is(equalTo(except)));

    testString = "aaa/bbb/ ";
    except = new String[]{"aaa", "bbb", " "};
    assertThat(testString.split("/"), is(equalTo(except)));

    testString = "/bbb";
    except = new String[] {"", "bbb"};
    assertThat(testString.split("/"), is(equalTo(except)));

    // 空字串也保留
    testString = "aaa/bbb/";
    except = new String[]{"aaa", "bbb", ""};
    assertThat(testString.split("/", -1), is(equalTo(except)));
}

  /**
   * Test split multi char.
   */
  @Test
  public void testSplitMultiChar() {
    String testString = "";
    String[] except = {};

    testString = "aaa&&bbb";
    except = new String[] {"aaa", "bbb"};
    assertThat(testString.split("&&"), is(equalTo(except)));
  }

  /**
   * Test string format.
   */
  @Test
  public void testStringFormat() {
    assertThat(String.format("aaa%dbbb", 111), is(equalTo("aaa111bbb"))); // int
    assertThat(String.format("aaa%sbbb", "222"), is(equalTo("aaa222bbb"))); // String
    assertThat(String.format("aaa%,.0fbbb", new BigDecimal("3333.3336")), is(equalTo("aaa3,333bbb"))); // BigDecimal, 加千分位逗號
    assertThat(String.format("aaa%.2fbbb", new BigDecimal("333.3336")), is(equalTo("aaa333.33bbb"))); // BigDecimal
    assertThat(String.format("aaa%dbbb", new Short("444")), is(equalTo("aaa444bbb"))); // Short
  }

  /**
   * Test index of.
   */
  @Test
  public void testIndexOf() {
    assertThat("abc".indexOf("d"), is(equalTo(-1)));
    assertThat("abc".indexOf("a"), is(equalTo(0)));
    assertThat("abc".indexOf("bc"), is(equalTo(1)));
  }

  /**
   * Test compare To
   */
  @Test
  public void testCompareTo() {
    assertThat("20160101".compareTo("20151231"), is(equalTo(1)));
    assertThat("20160101".compareTo("20160101"), is(equalTo(0)));
    assertThat("20160101".compareTo("20160102"), is(equalTo(-1)));
  }

  /**
   * Test contains
   */
  @Test
  public void testContains() {
    String testStr = "這是半自由行的商品";
    assertThat(testStr.contains("自由行") && !testStr.contains("半自由行"), is(false));

    testStr = "這是自由行的商品";
    assertThat(testStr.contains("自由行") && !testStr.contains("半自由行"), is(true));
  }
}
