package ln.java8;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Collection預設方法
 * 
 * @author Ian Chen
 */
public class A2_CollectionTest {

  @Test
  public void testForEach() {
    List<String> names = Arrays.asList("Justin", "Monica", "Irene");
    names.forEach(name -> System.out.println(name));
    
    // 可簡化成
    names.forEach(System.out::println);
  }

}
