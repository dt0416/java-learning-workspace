package com.string;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author Ian Chen
 */
public class EmptyString {

  @Test
  public void testStringUtils_isBlack() {
    // 以下字元在isBlank判斷皆等於true
    String breakline1 = "";
    String breakline2 = null;
    String breakline3 = "\n";
    String breakline4 = "\t";
    String breakline5 = "\r";

    assertTrue(StringUtils.isBlank(breakline1));
    assertTrue(StringUtils.isBlank(breakline2));
    assertTrue(StringUtils.isBlank(breakline3));
    assertTrue(StringUtils.isBlank(breakline4));
    assertTrue(StringUtils.isBlank(breakline5));
  }

}
