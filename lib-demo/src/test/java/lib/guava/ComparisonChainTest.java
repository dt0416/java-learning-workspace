package lib.guava;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.ComparisonChain;

public class ComparisonChainTest {

  /**
   * 結論：返回第一個非0的數值
   */
  @Test
  public void test() {
    int result = 0;
    
    result = ComparisonChain.start().compare(1, 2).result();
    assertThat(result, is(equalTo(-1)));
    result = ComparisonChain.start().compare(1, 1).result();
    assertThat(result, is(equalTo(0)));
    result = ComparisonChain.start().compare(2, 1).result();
    assertThat(result, is(equalTo(1)));
    result = ComparisonChain.start().compare(1, 2).compare(1, 1).compare(2, 1).result();
    assertThat(result, is(equalTo(-1)));
    result = ComparisonChain.start().compare(1, 1).compare(2, 1).compare(1, 2).result();
    assertThat(result, is(equalTo(1)));
    result = ComparisonChain.start().compare(2, 1).compare(1, 2).compare(1, 1).result();
    assertThat(result, is(equalTo(1)));
  }

  @Test(expected = NullPointerException.class)
  public void test_hasNull() {
    int result = 0;
    result = ComparisonChain.start().compare(true, null).result();
    System.out.println(result); // -1
  }
}
