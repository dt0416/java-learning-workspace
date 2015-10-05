package ln.clone.obj;

public class MyObject implements Cloneable {
  public String name;
  public int age;
  public MyObject2 myObject2;
  
  @Override
  public MyObject clone() throws CloneNotSupportedException {
    return (MyObject) super.clone();
  }
}