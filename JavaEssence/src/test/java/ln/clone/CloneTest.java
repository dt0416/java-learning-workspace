package ln.clone;

import ln.clone.obj.MyObject;
import ln.clone.obj.MyObject2;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 * 實現Cloneable
 * 1. implements Cloneable
 * 2. Override clone()
 * 
 * 注意：只有primitive屬性會clone成另一個reference，物件屬性的reference仍是同一個
 * </pre>
 *
 * @author Ian Chen
 */
public class CloneTest {

  @Test
  public void test() throws CloneNotSupportedException {
    MyObject mo = new MyObject();
    mo.myObject2 = new MyObject2();
    MyObject moClone = mo.clone();
    
    mo.name = "Mary";
    mo.age = 20;
    mo.myObject2.name = "Mary2";
    System.out.println(mo.name); // Mary
    System.out.println(mo.age); // 20
    System.out.println(mo.myObject2.name); // Mary2
    System.out.println(moClone.name); // null
    System.out.println(moClone.age); // 0
    System.out.println(moClone.myObject2.name); // Mary2
    
    Assert.assertTrue(mo.name != moClone.name); // primitive屬性
    Assert.assertTrue(mo.age != moClone.age); // primitive屬性
    Assert.assertTrue(mo.myObject2 == moClone.myObject2); // 物件屬性
  }
}