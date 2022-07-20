package string;

import static org.junit.Assert.*;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
  
  @Test
  public void testMatch3() {
    assertTrue("01".matches("01|02"));
    assertTrue("02".matches("01|02"));

    // 不合法
    assertFalse("".matches("01|02"));
    assertFalse("011".matches("01|02"));
    assertFalse("03".matches("01|02"));
  }

  @Test
  public void testMatch4() {
    assertTrue("ORD0000000001".matches("ORD\\d{10}"));

    // 不合法
    assertFalse("".matches("ORD\\d{10}"));
    assertFalse("ORD".matches("ORD\\d{10}"));
    assertFalse("ORD000000001".matches("ORD\\d{10}"));
    assertFalse("ORD0a1".matches("ORD\\d{10}"));
    assertFalse("ORA0001".matches("ORD\\d{10}"));
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
  
  /**
   * 測試replace和replaceAll差別
   */
  @Test
  public void testReplaceAndReplaceAll() {
    String testStr = "1.2.3";

    assertEquals(testStr.replace(".", ""), testStr.replaceAll("\\.", "")); // 123
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testReplaceAndReplaceAllWithSeparator() {
    String testStr = "1.2.3";
    // 在windows會產生IllegalArgumentException
    System.out.println(testStr.replaceAll("\\.", File.separator));
  }

  @Test
  public void mobileCheck() {
    Pattern patternEmail = Pattern.compile("^09\\d*$");
    Matcher matcher = patternEmail.matcher("09");
    System.out.println(matcher.matches()); 
    matcher = patternEmail.matcher("0912");
    System.out.println(matcher.matches()); 
    matcher = patternEmail.matcher("0912a");
    System.out.println(matcher.matches()); 
  }
  
  /**
   * 把不易區別的文字取代成s
   */
  @Test
  public void simpleReplace() {
    String str = "AAA";
    System.out.println(str.replaceAll("[1iIloO0]", "s"));
    str = "AiAjkl";
    System.out.println(str.replaceAll("[1iIloO0]", "s"));
    str = "AiAjkl1234560oaaaa";
    System.out.println(str.replaceAll("[1iIloO0]", "s"));
  }
  
  @Test
  public void orderNo() {
    String regex = "ORD\\d{10}";
    assertTrue("ORD0012345678".matches(regex));

    assertFalse("ORD001234567".matches(regex));
    assertFalse("ORD00123456789".matches(regex));
    assertFalse("ORDA012345678".matches(regex));
  }
}
