package com.string;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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

}
