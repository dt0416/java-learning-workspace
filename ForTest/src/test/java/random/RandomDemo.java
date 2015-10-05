package random;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.*;

import java.util.Random;

import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class RandomDemo {

  /**
   * 動態比例，範例為1成.
   */
  @Test
  public void test() {
    int lucky = 0;

    int allCount = 1000000;
    int percent = 1;
    Random random = new Random();
    for (int i = 0; i < allCount; i++) {
      if (random.nextInt(10) < percent) { // 重點在這行
        lucky++;
      }
    }

    System.out.println(lucky);
    assertThat(
        lucky,
        allOf(greaterThanOrEqualTo(allCount / 10 * percent - 1000), lessThanOrEqualTo(allCount / 10
            * percent + 1000))); // 介於?/10 加減 1000
  }

}
