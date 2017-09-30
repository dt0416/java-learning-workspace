package ln.java8;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Consumer
 * 需要的行為是接受一個引數，然後處理後不傳回值，就可以使用Consumer介面
 * 
 * Function
 * 需要的是接受一個引數，然後以該引數進行計算後傳回結果，就可以使用Function介面
 * 
 * Predicate
 * 接受一個引數，然後只傳回boolean值，也就是根據傳入的引數直接論斷真假的行為，就可以使用Predicate函式介面
 * 
 * Supplier
 * 需要的行為是不接受任何引數，然後傳回值，那可以使用Supplier函式介面
 * 
 * @author Ian Chen
 */
public class A5_ConsumerFunctionPredicateSupplierTest {

  /**
   * forEach即是Consumer的實際例子
   */
  @Test
  public void testConsumer() {
    Arrays.asList("Justin", "Monica", "Irene").forEach(System.out::println);
  }
  
  /**
   * map即是Function的實際例子
   */
  @Test
  public void testFunction() {
    Optional<String> nickOptional = this.getOptionNickName("Justin");
    System.out.println(nickOptional.map(String::toUpperCase));  // 顯示 CATERPILLAR
  }
  
  Optional<String> getOptionNickName(String name) {
    Map<String, String> nickNames = new HashMap<>();
    nickNames.put("Justin", "caterpillar");
    nickNames.put("Monica", "momor");
    nickNames.put("Irene", "hamimi");
    String nickName = nickNames.get(name);
    return Optional.ofNullable(nickName);
  }

  /**
   * filter()方法接受Predicate實例
   */
  @Test
  public void testPredicate() {
    long count = Stream.of("aaa.txt").filter(name -> name.endsWith("txt")).count();
    assertEquals(1, count);
  }
  
  /**
   * randomZero()方法接受Supplier實例
   * 亂數把某一個位置變成0
   */
  @Test
  public void testSupplier() {
    Integer[] coins = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};      
    randomZero(coins, () -> (int) (Math.random() * 10));
    Arrays.asList(coins).forEach(System.out::println);
  }
  
  static void randomZero(Integer[] coins, Supplier<Integer> randomSupplier) {
    coins[randomSupplier.get()] = 0;
  }
}
