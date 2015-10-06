package lib.spring.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Ian Chen
 *
 */
public class RestTemplateTest {

  /**
   * 產生選填參數的url.
   */
  @Test
  public void testOptionalParameter() {
    String expcet = "http://www.url/?msisdn=123";

    String msisdn = "123";
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl("http://www.url/");
    if (msisdn != null) {
      builder.queryParam("msisdn", msisdn);
    }

    assertEquals(expcet, builder.build().toUriString());
  }

}
