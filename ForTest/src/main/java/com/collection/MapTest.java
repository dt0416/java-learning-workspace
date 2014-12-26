package com.collection;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {

  /**
   * 測試丟null和不給值時, 取值時的結果是否皆為null
   */
  @Test
  public void testNullValue() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("AAA", null);
    // 測試有put但為null的值
    String aaa = map.get("AAA");
    // 測試無put的值
    String bbb = map.get("BBB");

    // 結論:aaa、bbb結果一樣皆為null
    assertEquals(null, aaa);
    assertEquals(null, bbb);
  }

  /**
   * 當有重覆的key，會留下最後一個put的value
   */
  @Test
  public void testDuplicateKey() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "a");
    map.put("1", "b");

    // 結論：會留下最後一個put的value
    assertEquals("b", map.get("1"));
  }
}
