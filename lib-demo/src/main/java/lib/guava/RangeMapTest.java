package lib.guava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeMap.Builder;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;

public class RangeMapTest {
  
  @Test
  public void test() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    RangeMap<Integer, Integer> markDown = builder
        .put(Range.atMost(10), 1)
        .put(Range.closed(11, 50), 21)
        .put(Range.closed(51, 100), 22)
        .put(Range.atLeast(101), 3)
        .build();
    assertTrue(markDown.get(10).equals(1));
    assertTrue(markDown.get(11).equals(21));
    assertTrue(markDown.get(50).equals(21));
    assertTrue(markDown.get(51).equals(22));
    assertTrue(markDown.get(100).equals(22));
    assertTrue(markDown.get(101).equals(3));
  }

  @Test
  public void test_open() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    RangeMap<Integer, Integer> markDown = builder
        .put(Range.open(11, 50), 21)
        .build();
    assertTrue(markDown.get(11) == null);
    assertTrue(markDown.get(12).equals(21));
    assertTrue(markDown.get(49).equals(21));
    assertTrue(markDown.get(50)  == null);
  }
  
  @Test
  public void test_openClosed() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    RangeMap<Integer, Integer> markDown = builder
        .put(Range.openClosed(11, 50), 21)
        .build();
    assertTrue(markDown.get(11) == null);
    assertTrue(markDown.get(12).equals(21));
    assertTrue(markDown.get(50).equals(21));
    assertTrue(markDown.get(51)  == null);
  }
  
  @Test
  public void test_closedOpen() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    RangeMap<Integer, Integer> markDown = builder
        .put(Range.closedOpen(11, 50), 21)
        .build();
    assertTrue(markDown.get(10) == null);
    assertTrue(markDown.get(11).equals(21));
    assertTrue(markDown.get(49).equals(21));
    assertTrue(markDown.get(50)  == null);
  }
  
  @Test
  public void test_greaterThan() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    RangeMap<Integer, Integer> markDown = builder
        .put(Range.greaterThan(100), 3)
        .build();
    assertTrue(markDown.get(100) == null);
    assertTrue(markDown.get(101).equals(3));
  }
  
  @Test
  public void test_lessThan() {
    Builder<Integer, Integer> builder = ImmutableRangeMap.<Integer, Integer>builder();
    RangeMap<Integer, Integer> markDown = builder
        .put(Range.lessThan(10), 1)
        .build();
    assertTrue(markDown.get(9).equals(1));
    assertTrue(markDown.get(10) == null);
  }
}
