package lib.guava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.ImmutableRangeMap.Builder;

/**
 * <pre> 使用RangeMap與使用原生自行撰寫的效能比較 </pre>
 *
 * @author Ian Chen
 */
public class RangeMapPerformanceComparison {
  private static final Logger logger = LoggerFactory.getLogger(Class.class);

  private static RangeMap<Integer, Integer> markDown;
  private static List<PfProPriceRule> pfProPriceRules;

  @BeforeClass
  public static void init() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    builder.put(Range.atMost(999), 1);
    builder.put(Range.closed(1000, 1499), 2);
    builder.put(Range.closed(1500, 1999), 3);
    builder.put(Range.closed(2000, 2999), 4);
    builder.put(Range.closed(3000, 3999), 5);
    builder.put(Range.closed(4000, 4999), 6);
    builder.put(Range.atLeast(5000), 7);
    markDown = builder.build();
    // 也可減化如下
//    markDown = builder
//        .put(Range.atMost(999), 1)
//        .put(Range.closed(1000, 1499), 2)
//        .put(Range.closed(1500, 1999), 3)
//        .put(Range.closed(2000, 2999), 4)
//        .put(Range.closed(3000, 3999), 5)
//        .put(Range.closed(4000, 4999), 6)
//        .put(Range.atLeast(5000), 7)
//        .build();
    
    pfProPriceRules = new ArrayList<PfProPriceRule>();
    PfProPriceRule pfProPriceRule1 = new PfProPriceRule();
    pfProPriceRule1.setChkPriceStart(999);
    pfProPriceRule1.setMarkDown(1);
    PfProPriceRule pfProPriceRule2 = new PfProPriceRule();
    pfProPriceRule2.setChkPriceStart(1000);
    pfProPriceRule2.setChkPriceEnd(1499);
    pfProPriceRule2.setMarkDown(2);
    PfProPriceRule pfProPriceRule3 = new PfProPriceRule();
    pfProPriceRule3.setChkPriceStart(1500);
    pfProPriceRule3.setChkPriceEnd(1999);
    pfProPriceRule3.setMarkDown(3);
    PfProPriceRule pfProPriceRule4 = new PfProPriceRule();
    pfProPriceRule4.setChkPriceStart(2000);
    pfProPriceRule4.setChkPriceEnd(2999);
    pfProPriceRule4.setMarkDown(4);
    PfProPriceRule pfProPriceRule5 = new PfProPriceRule();
    pfProPriceRule5.setChkPriceStart(3000);
    pfProPriceRule5.setChkPriceEnd(3999);
    pfProPriceRule5.setMarkDown(5);
    PfProPriceRule pfProPriceRule6 = new PfProPriceRule();
    pfProPriceRule6.setChkPriceStart(4000);
    pfProPriceRule6.setChkPriceEnd(4999);
    pfProPriceRule6.setMarkDown(6);
    PfProPriceRule pfProPriceRule7 = new PfProPriceRule();
    pfProPriceRule7.setChkPriceStart(5000);
    pfProPriceRule7.setMarkDown(7);
    pfProPriceRules.add(pfProPriceRule1);
    pfProPriceRules.add(pfProPriceRule2);
    pfProPriceRules.add(pfProPriceRule3);
    pfProPriceRules.add(pfProPriceRule4);
    pfProPriceRules.add(pfProPriceRule5);
    pfProPriceRules.add(pfProPriceRule6);
    pfProPriceRules.add(pfProPriceRule7);
  }
  
  /**
   * 結論：使用guava的效能比較差
   */
  @Test
  public void test_performance() {
    long startTime = System.currentTimeMillis();
    assertTrue(getWithGuava(999).equals(1));
    assertTrue(getWithGuava(1000).equals(2));
    assertTrue(getWithGuava(1500).equals(3));
    assertTrue(getWithGuava(2000).equals(4));
    assertTrue(getWithGuava(3000).equals(5));
    assertTrue(getWithGuava(4000).equals(6));
    assertTrue(getWithGuava(5000).equals(7));
    logger.info("getWithGuava performance({}ms)", (System.currentTimeMillis() - startTime));
    
    startTime = System.currentTimeMillis();
    assertTrue(getWithList(999).equals(1));
    assertTrue(getWithList(1000).equals(2));
    assertTrue(getWithList(1500).equals(3));
    assertTrue(getWithList(2000).equals(4));
    assertTrue(getWithList(3000).equals(5));
    assertTrue(getWithList(4000).equals(6));
    assertTrue(getWithList(5000).equals(7));
    logger.info("getWithList performance({}ms)", (System.currentTimeMillis() - startTime));
  }

  private Integer getWithGuava(Integer input) {
    return markDown.get(input);
  }

  private Integer getWithList(Integer input) {
    int markDown = 0;
    for (PfProPriceRule pfProPriceRule : pfProPriceRules) {
      Integer chkPriceStart = pfProPriceRule.getChkPriceStart();
      Integer chkPriceEnd = pfProPriceRule.getChkPriceEnd();
      if (chkPriceStart == null && input.compareTo(chkPriceEnd) <= 0) {
        markDown = pfProPriceRule.getMarkDown();
      } else if (chkPriceEnd == null && input.compareTo(chkPriceStart) >= 0) {
        markDown = pfProPriceRule.getMarkDown();
      } else if (input.compareTo(chkPriceStart) >= 0 && input.compareTo(chkPriceEnd) <= 0) {
        markDown = pfProPriceRule.getMarkDown();
      }
    }
    return markDown;
  }
}
