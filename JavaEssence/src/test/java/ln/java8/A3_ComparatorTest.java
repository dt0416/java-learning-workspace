package ln.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * Comparator在1.8新增了許多常用的靜態方法可以使用，List等介面也增加了sort default方法
 * 
 * @author Ian Chen
 */
public class A3_ComparatorTest {

  @Test
  public void testComparator() {
    // 未使用Comparator，String已有實作Comparable
    List<String> words = Arrays.asList("B", "X", "A", "M", "F", "W", "O");
    Collections.sort(words);
    System.out.println(words);
    
    // 使用Comparator會取代掉原本實作Comparable的compare
    words = Arrays.asList("B", "X", "A", "M", "F", "W", "O");
    Collections.sort(words, new StringComparator());
    System.out.println(words);
    
    // 1.8後List增加了sort()方法
    words = Arrays.asList("B", "X", "A", "M", "F", "W", "O");
    words.sort(new StringComparator());
    System.out.println(words);
  }

  /**
   * 利用Comparator裡的static方法來做排序，省去自己寫Comparator
   */
  @Test
  public void testComparatorStaticMethod() {
    // null排前面，反向排，可以更精簡的使用Comparator裡static方法，讓程式碼寫來具有較高的可讀性
    List<String> words = Arrays.asList("B", "X", null, "A", "M", "F", "W", null, "O");
    words.sort(Comparator.nullsFirst(Comparator.reverseOrder()));
    System.out.println(words);
    
    List<Person> persons = Arrays.asList(new Person("Justin", "Lin", 804),
        new Person("Monica", "Huang", 804), new Person("Irene", "Lin", 804));

    // 先依姓來排，再依名來排，再依居住地的郵遞區號來排
    persons.sort(Comparator.<Person, String>comparing(p -> p.lastName)
        .thenComparing(p -> p.firstName).thenComparing(p -> p.zipCode));

    System.out.println(persons);
  }
  
}

class StringComparator implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
      return -s1.compareTo(s2); // 反向排序
  }
}

class Person {
  public String firstName;
  public String lastName;
  public Integer zipCode;

  public Person(String firstName, String lastName, Integer zipCode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.zipCode = zipCode;
  }

  public String toString() {
    return String.format("Person(%s %s, %d)", firstName, lastName, zipCode);
  }
}
