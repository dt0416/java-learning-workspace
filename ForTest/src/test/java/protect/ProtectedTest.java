package protect;

/**
 * class MyObject的protected方法在此可被使用
 * 在別的package下就無法被使用
 * 
 * @author Ian Chen
 */
public class ProtectedTest {

  public static void main(String[] args) {
    new MyObject().getHello("Mary");
  }
}
