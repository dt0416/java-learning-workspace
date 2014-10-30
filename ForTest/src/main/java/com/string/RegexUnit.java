package com.string;

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
}
