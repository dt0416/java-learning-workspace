package lib.guava;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 * 使用Guava產生map
 *
 * @author Ian Chen
 */
public class MapCreate {

  @Test
  public void testImmutableMap() {
    // ImmutableMap.builder().put().build()
    Map<String, Object> mp1 =
        ImmutableMap.<String, Object>builder().put("departArea1", 1).put("departArea2", 1)
            .put("departArea3", 1).put("departArea4", 1).put("departArea5", 1)
            .put("departArea6", 1).put("departArea7", 1).build();

    // ImmutableMap.of, 最多只能4個
    Map<String, Object> map2 = ImmutableMap.<String, Object>of("departArea1", 1, "departArea2", 2);

    // Map原始put
    Map<String, Object> mp3 = new HashMap<String, Object>();
    mp3.put("departArea1", 1);
    mp3.put("departArea2", 1);
    mp3.put("departArea3", 1);
    mp3.put("departArea4", 1);

    assertThat(mp1.size(), is(equalTo(7)));
    assertThat(map2.size(), is(equalTo(2)));
    assertThat(mp3.size(), is(equalTo(4)));
  }
  
  /**
   * ImmutableMap.builder產生的map是readonly，無法再進行put
   */
  @Test(expected = UnsupportedOperationException.class)
  public void testImmutableMap_isReadOnly() {
    // builder
    Map<String, Object> map = ImmutableMap.<String, Object>builder().put("departArea1", 1).build();
    map.put("departArea7", 1); // UnsupportedOperationException
  }
}
