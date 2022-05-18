package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBufferTest {

  @Test
  public void testSetLength() {
    StringBuffer sb = new StringBuffer("Test");
    System.out.println(sb);
    sb.setLength(10);
    System.out.println(sb);
    sb.setLength(2);
    System.out.println(sb);
    sb.setLength(0);
    System.out.println(sb);
  }

}
