package com.string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <pre> NullString. </pre>
 *
 * @author Ian Chen
 */
public class NullString {

  @Test
  public void testNullConnectString() {
    String nullString = null;
    String test = nullString + "test";
    assertEquals("nulltest", test);
  }

}
