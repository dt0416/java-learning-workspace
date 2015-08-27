package ln.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ian Chen
 *
 */
public class GenericType<T> {

  /**
   * <pre>
   * static無參數
   * static method不管有無參數一律要使用{@code<T> xxx<T>}.
   * </pre>
   *
   * @param <T> the generic type
   * @return the static list type by object
   */
  public static <T> List<T> getStaticListTypeDeclare() {
    List<T> list = new ArrayList<T>();
    list.add(null);
    return list;
  }

  /**
   * <pre>
   * static搭配參數
   * static method不管有無參數一律要使用{@code<T> xxx<T>}.
   * </pre>
   *
   * @param <T> the generic type
   * @param t the t
   * @return the static list type by parameter
   */
  public static <T> List<T> getStaticListTypeByParameter(T t) {
    List<T> list = new ArrayList<T>();
    list.add(t);
    return list;
  }

  /**
   * <pre>
   * 使用物件的T.
   * </pre>
   *
   * @return the list type by object
   */
  public List<T> getListTypeByObject() {
    List<T> list = new ArrayList<T>();
    list.add(null);
    return list;
  }

  /**
   * <pre>
   * 物件的T與參數不同型別，應該較少用到，可能T和參數的有同樣父類別.
   * </pre>
   *
   * @param t the t
   * @return the list type by object with different type
   */
  @SuppressWarnings("unchecked")
  public List<T> getListTypeByObjectWithDifferentType(Integer t) {
    List<T> list = new ArrayList<T>();
    list.add((T) t);
    return list;
  }

  /**
   * <pre>
   * 回傳的E與物件的T不同型別，宣告時決定E的型別
   * 需使用{@code<E> xxx<E>}.
   * </pre>
   *
   * @param <E> the element type
   * @return the list type by declare
   */
  public <E> List<E> getListTypeByDeclare() {
    List<E> list = new ArrayList<E>();
    list.add(null);
    return list;
  }

  /**
   * <pre>
   * 回傳的E與物件的T不同型別，且有參數，參數的型別決定E的型別
   * 需使用{@code<E> xxx<E>}.
   * </pre>
   *
   * @param <E> the element type
   * @param e the e
   * @return the list type gy parameter
   */
  public <E> List<E> getListTypeGyParameter(E e) {
    List<E> list = new ArrayList<E>();
    list.add(e);
    return list;
  }
}
