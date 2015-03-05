package com.collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author Ian Chen
 */
public class MapSortTest {

  /**
   * HashMap
   * 「不會」自動排序
   * 順序和put時的「不會」一致.
   */
  @Test
  public void testHashMap_sort() {
    System.out.println("testHashMap_sort");
    Map<String, String> myMaps = new HashMap<String, String>();
    myMaps.put("2", "str2");
    myMaps.put("5", "str5");
    myMaps.put("1", "str1");
    myMaps.put("3", "str3");
    myMaps.put("4", "str4");
    String expect = "3,2,1,5,4,"; // 很奇怪的順序
    String actual = "";
    for (Entry<String, String> myMap : myMaps.entrySet()) {
      actual += myMap.getKey() + ",";
    }
    System.out.println(actual);
    assertThat(actual, is(equalTo(expect)));
  }

  /**
   * TreeMap 
   * 「會」自動排序
   * 順序和put時的「不會」一致.
   */
  @Test
  public void testTreeMap_sort() {
    System.out.println("testTreeMap_sort");
    Map<String, String> myMaps = new TreeMap<String, String>();
    myMaps.put("2", "str2");
    myMaps.put("5", "str5");
    myMaps.put("1", "str1");
    myMaps.put("3", "str3");
    myMaps.put("4", "str4");
    myMaps.put("11", "str11");
    String expect = "1,11,2,3,4,5,"; // 自動排序
    String actual = "";
    for (Entry<String, String> myMap : myMaps.entrySet()) {
      actual += myMap.getKey() + ",";
    }
    System.out.println(actual);
    assertThat(actual, is(equalTo(expect)));
  }

  /**
   * LinkedHashMap
   * 「不會」自動排序
   * 順序和put時的「會」一致.
   */
  @Test
  public void testLinkedHashMap_sort() {
    System.out.println("testLinkedHashMap_sort");
    Map<String, String> myMaps = new LinkedHashMap<String, String>();
    myMaps.put("2", "str2");
    myMaps.put("5", "str5");
    myMaps.put("1", "str1");
    myMaps.put("3", "str3");
    myMaps.put("4", "str4");
    String expect = "2,5,1,3,4,"; // 與丟進來的順序一致
    String actual = "";
    for (Entry<String, String> myMap : myMaps.entrySet()) {
      actual += myMap.getKey() + ",";
    }
    System.out.println(actual);
    assertThat(actual, is(equalTo(expect)));
  }

}
