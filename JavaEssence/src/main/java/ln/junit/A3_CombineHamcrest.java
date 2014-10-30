package ln.junit;

import static org.junit.Assert.*;
//import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Hamcrest:目的在於改進斷言測試時的可讀性
 * https://code.google.com/p/hamcrest/wiki/Tutorial
 * 分類:Core、Logical、Object、Beans、Collections、Number、Text
 * junit 4.4版後就包含Hamcrest，之前的版本需另外加入lib且存在別的package(JUnitMatchers的method被deprecated了)
 * 
 * @author Ina Chen
 */
public class A3_CombineHamcrest {
  private static Logger logger = Logger.getLogger(A3_CombineHamcrest.class);

  @Test
  public void testHasItems() {
    logger.info("testHasItems");
    List<String> guests = new ArrayList<String>();
    guests.add("Mary");
    guests.add("John");
    guests.add("Bill");
    assertThat(guests, hasItems("Mary", "John"));
  }
}
