package construct;

public class ConstructTest {

  private ConstructTest(){}
  public ConstructTest(String s) {
    this(90);
  }
  public ConstructTest(int i) {
    this();
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    new ConstructTest();
  }

}
