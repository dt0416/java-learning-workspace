package string;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * 正規表示式測試
 * 
 * @author Ian Chen
 */
public class RegexUnit {

  /**
   * 利用Regular Expression取代所有數字.
   */
  @Test
  public void testDigital() {
    String testStr = "1a2b33abc";
    String expect = "ababc";
    assertEquals(expect, testStr.replaceAll("\\d", ""));
  }

  /**
   * 換行的取代.
   */
  @Test
  public void testBreakLine() {
    String testStr = "aaa\r\nbbb\nccc\rddd";
    String expect = "aaa<>bbb<>ccc<>ddd";
    assertEquals(expect, testStr.replaceAll("(\r\n|\n|\r)", "<>")); // \r\n要放第一個，不然會有取代2次的問題
  }

  /**
   * 移除br、a以外的html tag.
   */
  @Test
  public void testRemoveTagWithoutSpecify() {
    String testStr = "";
    String expect = "";
    String regStr = "<(?!(/?((?i:br\\W|a\\W))))[^>]*>";
    String result = "";

    testStr = "<p>aaa</p>";
    expect  = "aaa";
    result = testStr.replaceAll(regStr, "");
    assertEquals(expect, result);

    testStr = "<font color=\"red\">aaa</font>";
    expect  = "aaa";
    result = testStr.replaceAll(regStr, "");
    assertEquals(expect, result);

    testStr = "aaa<brr><brr /><rb><rb />";
    expect  = "aaa";
    result = testStr.replaceAll(regStr, "");
    assertEquals(expect, result);

    testStr = "aaa<br><br /><Br><BR />";
    expect  = "aaa<br><br /><Br><BR />";
    result = testStr.replaceAll(regStr, "");
    assertEquals(expect, result);

    testStr = "<a>aaa</a><A>aaa</A><a href=\"http://eztravel.com.tw\">aaa</a>";
    expect  = "<a>aaa</a><A>aaa</A><a href=\"http://eztravel.com.tw\">aaa</a>";
    result = testStr.replaceAll(regStr, "");
    assertEquals(expect, result);
  }

  /**
   * 只留下數字.
   */
  @Test
  public void testRemoveNonNumber() {
    String testStr = "第 02 天";
    String expect = "02";
    assertEquals(expect, testStr.replaceAll("\\D", ""));
  }

  /**
   * 移除javascript裡的function xxx(...){...}.
   */
  @Test
  public void testRemoveJavascriptFunction() {
    String testStr = "aaafunction test() { if(true) {return \"\";}\n \n }bbb";
    String expect = "aaabbb";
    assertEquals(expect, testStr.replaceAll("(function)(?s).*}", ""));
  }
  
  /**
   * Test match.
   */
  @Test
  public void testMatch() {
    String testStr = "";
    String regex = ".*(自由行|TKT|機票).*";

    // true
    testStr = "自由行";
    assertTrue(testStr.matches(regex));
    testStr = "TKT";
    assertTrue(testStr.matches(regex));
    testStr = "機票";
    assertTrue(testStr.matches(regex));
    testStr = "aaa機票aaa";
    assertTrue(testStr.matches(regex));
    testStr = "aaa機票自由行";
    assertTrue(testStr.matches(regex));
    testStr = "機票自由行";
    assertTrue(testStr.matches(regex));
    testStr = "機票自由行bbb";
    assertTrue(testStr.matches(regex));
    testStr = "機自由行bbb";
    assertTrue(testStr.matches(regex));

    // false
    testStr = "aaabbbaaa";
    assertFalse(testStr.matches(regex));
  }

  /**
   * 測試match全都為英數字含底線 and -
   */
  @Test
  public void testMatch2() {
    assertTrue("abc123_ABC".matches("[\\w-]*"));
    assertTrue("abc123-ABC".matches("[\\w-]*"));

    // 不合法
    assertFalse("abc123 _ABC".matches("[\\w-]*"));
    assertFalse("abc123[_ABC".matches("[\\w-]*"));
    assertFalse("abc123,_ABC".matches("[\\w-]*"));
//    assertFalse("abc123-_ABC".matches("[a-zA-Z_0-9-_]*"));
    assertFalse("abc123._ABC".matches("[\\w-]*"));
  }
  
  /**
   * 測試match http://、https://
   */
  @Test
  public void testMatchHttps() {
    assertTrue("http://3w.eztravel.com.tw".matches("(?:https?)://.+"));
    assertTrue("https://3w.eztravel.com.tw".matches("(?:https?)://.+"));
  }

  /**
   * 測試取代逗號+空白
   */
  @Test
  public void testReplaceSpace() {
    String testStr = "";
    String regex = ", *";

    testStr = ",";
    assertEquals(", ", testStr.replaceAll(regex, ", "));
    testStr = ", ";
    assertEquals(", ", testStr.replaceAll(regex, ", "));
    testStr = ",  ";
    assertEquals(", ", testStr.replaceAll(regex, ", "));
    testStr = ",  \r\n";
    assertEquals(", \r\n", testStr.replaceAll(regex, ", "));
  }

}
