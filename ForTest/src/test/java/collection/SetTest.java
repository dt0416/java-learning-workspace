package collection;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class SetTest {

  @Test
  public void testAdd() {
    System.out.println("testAdd");
    Set<Integer> ints = new HashSet<Integer>();
    ints.add(1);
    ints.add(1); // 會視同一樣的物件
    ints.add(2);

    assertEquals(2, ints.size());
  }

  @Test
  public void testAddObject() {
    System.out.println("testAddObject");
    Set<AirGroup> airGroups = new HashSet<AirGroup>();
    AirGroup ag1 = new AirGroup();
    airGroups.add(ag1);
    ag1.setName("name1.1");
    ag1.setName("name1.2"); // 會取到這個名稱
    AirGroup ag2 = new AirGroup();
    ag2.setName("name2");
    airGroups.add(ag2);

    for (AirGroup airGroup : airGroups) {
      System.out.println(airGroup.getName());
    }
    assertEquals(2, airGroups.size());
  }

  class AirGroup {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
  
  @Test
  public void testRemoveAll() {
    Set<String> set1 = new HashSet<String>();
    Set<String> set2 = new HashSet<String>();
    set1.add("A1");
    set1.add("A2");
    set1.add("A3");
    set1.add("B1");
    set1.add("B2");
    set1.add("B3");
    
    set2.add("A2");
    set2.add("B3");
    set2.add("B4");
    for (String str : set1) {
      System.out.println(str);
    }
    set1.removeAll(set2);
    System.out.println("======removeAll=====");
    for (String str : set1) {
      System.out.println(str);
    }
  }
}
