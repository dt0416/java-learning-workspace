package ln.generic;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class A1_GenericTest {

  /**
   * 重點在宣告型別.
   */
  @Test
  public void testGenericTypeClassT() {
    List<String> list = GenericType.getStaticListTypeDeclare();
    assertNotNull(list);
  }

  /**
   * 靜態，重點在參數型別.
   */
  @Test
  public void testGenericTypeClassTWithParameter() {
    List<String> list = GenericType.getStaticListTypeByParameter("123");
    assertNotNull(list);
  }

  /**
   * 重點在物件的型別.
   */
  @Test
  public void testGenericTypeObjectT() {
    GenericType<String> generic = new GenericType<String>();
    List<String> list = generic.getListTypeByObject();
    assertNotNull(list);
  }

  /**
   * 重點在物件、參數型別.
   */
  @Test
  public void testGenericTypeObjectTWithDifferentParameterType() {
    GenericType<String> generic = new GenericType<String>();
    List<String> list = generic.getListTypeByObjectWithDifferentType(123);
    assertNotNull(list);
  }

  /**
   * 重點在宣告型別.
   */
  @Test
  public void testGenericTypeMethodE() {
    GenericType<String> generic = new GenericType<String>();
    List<Integer> list = generic.getListTypeByDeclare();
    assertNotNull(list);
  }

  /**
   * 重點在參數的型別.
   */
  @Test
  public void testGenericTypeMethodEWithParameter() {
    GenericType<String> generic = new GenericType<String>();
    List<Integer> list = generic.getListTypeGyParameter(123);
    assertNotNull(list);
  }
}
