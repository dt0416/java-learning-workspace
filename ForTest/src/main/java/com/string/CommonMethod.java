package com.string;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author Ian Chen
 */
public class CommonMethod {

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
  }
  
  @Test
  public void testStringFormat() {
    System.out.println(String.format("aaa%dbbb", 111)); // int
    System.out.println(String.format("aaa%sbbb", "222")); // String
    System.out.println(String.format("aaa%.0fbbb", new BigDecimal("333"))); // BigDecimal
    System.out.println(String.format("aaa%dbbb", new Short("444"))); // Short
  }

}
