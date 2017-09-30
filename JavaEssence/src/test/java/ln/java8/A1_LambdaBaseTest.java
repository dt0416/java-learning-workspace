package ln.java8;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * Lambda 測試
 * 
 * 函式介面：僅具單一抽象方法的介面，該介面會標註 @FunctionalInterface
 *
 *  @author Ian Chen
 */
public class A1_LambdaBaseTest {

  @Test
  public void testLambda() {
    // java8以前的寫法
    String[] names = {"Justin", "caterpillar", "Bush"};
    Arrays.sort(names, new Comparator<String>() {
        public int compare(String name1, String name2) {
            return name1.length() - name2.length();
        }
    });
    for (String string : names) {
      System.out.println(string);
    }
    
    // 第1次簡化
    String[] names1 = {"Justin", "caterpillar", "Bush"};
    Comparator<String> byLength = (String name1, String name2) -> name1.length() - name2.length();
    Arrays.sort(names1, byLength);
    for (String string : names1) {
      System.out.println(string);
    }
    
    // 第2次簡化，編譯器認得是String型態，故可省略
    String[] names2 = {"Justin", "caterpillar", "Bush"};
    Comparator<String> byLength2 = (name1, name2) -> name1.length() - name2.length();
    Arrays.sort(names2, byLength2);
    for (String string : names2) {
      System.out.println(string);
    }

    // 第3次簡化，直接將表示式帶入參數中
    String[] names3 = {"Justin", "caterpillar", "Bush"};
    Arrays.sort(names3, (name1, name2) -> name1.length() - name2.length());
    for (String string : names3) {
      System.out.println(string);
    }
  
    // 利用class的static method
    String[] names4 = {"Justin", "caterpillar", "Bush"};
    Arrays.sort(names4, (name1, name2) -> StringOrder.byLength(name1, name2));
    for (String string : names4) {
      System.out.println(string);
    }

    // 利用class的static method，加上「::」表示式
    String[] names5 = {"Justin", "caterpillar", "Bush"};
    Arrays.sort(names5, StringOrder::byLength);
    for (String string : names5) {
      System.out.println(string);
    }

    // 利用class的public method
    String[] names7 = {"Justin", "caterpillar", "Bush"};
    Arrays.sort(names7, String::compareToIgnoreCase);
    for (String string : names7) {
      System.out.println(string);
    }
    
    // 利用object的method
    String[] names6 = {"Justin", "caterpillar", "Bush"};
    Arrays.sort(names6, this::compareByLength);
    for (String string : names6) {
      System.out.println(string);
    }
  }

  private int compareByLength(String s1, String s2) {
    return s1.length() - s2.length();
  }
  
  @Test
  public void testThis() {
    
    Runnable r1 = new Runnable() {
      public void run() {
        System.out.println(this); // this代表r1
      }
    };

    Runnable r2 = new Runnable() {
      public void run() {
        System.out.println(toString()); // 會呼叫r2物件的toString()，而不是呼叫LambdaTest的toString()
      }
    };
    
    // 利用lambda實作Runnable
    Runnable r3 = () -> System.out.println(this); // this代表「A1_LambdaBaseTest」的實體物件
    Runnable r4 = () -> System.out.println(toString()); // 會呼叫「A1_LambdaBaseTest」的toString()，而不是呼叫r4物件的toString()
    
    r1.run();
    r2.run();
    r3.run();
    r4.run();
  }
  
  public String toString() {
    return "Hello, world!";
  }

  @Test
  public void testNonFinal() {
    String[] names = {"Justin", "Monica", "Irene"}; // JDK8 前必須加上 final
    Runnable runnable = new Runnable() {
      public void run() {
        for (String name : names) {
          System.out.println(name);
        }
      }
    };
    runnable.run();
    
    // 上面可改成以下lambda寫法，JDK8禁止改變被捕獲的區域變數值
    String[] names2 = {"Justin", "Monica", "Irene"};
    Runnable runnable2 = () -> {
      for (String name : names2) {
        System.out.println(name);
      }
    };
    runnable2.run();
  }

}

class StringOrder {
  public static int byLength(String s1, String s2) {
    return s1.length() - s2.length();
  }

  public static int byLexicography(String s1, String s2) {
    return s1.compareTo(s2);
  }

  public static int byLexicographyIgnoreCase(String s1, String s2) {
    return s1.compareToIgnoreCase(s2);
  }
}
