package collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ian Chen
 *
 */
public class ListRemove {

  private static final Logger logger = LoggerFactory.getLogger(ListRemove.class);

  /**
   * 不可在迴圈裡使用此方法移除list或map裡的物件.
   */
  @Test(expected = ConcurrentModificationException.class)
  public void testRemoveInside() {
    logger.info("testRemoveInside");
    List<String> strs = new ArrayList<String>();
    strs.add("str1");
    strs.add("str2");
    strs.add("str3");
    logger.info("strs.size:{}", strs.size());
    for (String string : strs) { // 會在此丟出ConcurrentModificationException
      logger.info("remove:{}", string);
      strs.remove(string);
    }
  }

  /**
   * 在外部移除不會有問題.
   */
  @Test
  public void testRemoveOutside() {
    logger.info("testRemoveOutside");
    List<String> strs = new ArrayList<String>();
    strs.add("str1");
    strs.add("str2");
    logger.info("strs.size:{}", strs.size());

    strs.remove("str1");
//    for (String string : strs) {
//      logger.info(string);
//    }
    logger.info("strs.size:{}", strs.size());
    assertEquals(1, strs.size());
  }

  /**
   * 要移除List裡的物件需搭配Iterator的remove.
   */
  @Test
  public void testRemoveWithIterator() {
    logger.info("testRemoveWithIterator");
    List<String> strs = new ArrayList<String>();
    strs.add("str1");
    strs.add("str2"); // 物件要在iterator()前新新增完畢，否則會有ConcurrentModificationException
    Iterator<String> strsIterator = strs.iterator();
    logger.info("strs.size:{}", strs.size());
    while (strsIterator.hasNext()) {
      String str = strsIterator.next();
      if ("str1".equals(str)) {
        strsIterator.remove();
      }
    }
    logger.info("strs.size:{}", strs.size());
    assertEquals(1, strs.size());
  }
}
