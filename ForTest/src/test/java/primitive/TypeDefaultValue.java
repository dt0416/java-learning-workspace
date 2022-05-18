package primitive;

import org.junit.Test;

/**
 * 各型別預設初使值
 * @author Ian Chen
 */
public class TypeDefaultValue {

  private String iAmString;
  
  private int iAmInt;
  
  private Integer IAmInteger;
  
  private boolean iAmSmallBoolean;
  
  private Boolean iAmBoolean;

  @Override
  public String toString() {
    return "TypeDefaultValue [iAmString=" + iAmString + ", iAmInt=" + iAmInt + ", IAmInteger="
        + IAmInteger + ", iAmSmallBoolean=" + iAmSmallBoolean + ", iAmBoolean=" + iAmBoolean + "]";
  }
  
  @Test
  public void testTypeDefaultValue() {
    System.out.println(new TypeDefaultValue());
  }
}
