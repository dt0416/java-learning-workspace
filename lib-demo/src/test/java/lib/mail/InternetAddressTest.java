package lib.mail;

import org.junit.Test;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author Ian Chen
 */
public class InternetAddressTest {

  /**
   * Parse時的分隔符號需用逗號(,)來分隔，用分號(;)會出錯
   */
  @Test(expected = AddressException.class)
  public void testParse() throws AddressException {
    String address1 = "aaa@eztravel.com.tw,bbb@eztravel.com.tw";
    String address2 = "aaa@eztravel.com.tw;bbb@eztravel.com.tw";
    InternetAddress[] internetAddresses1 = InternetAddress.parse(address1);
    InternetAddress[] internetAddresses2 = InternetAddress.parse(address2); // 此行會拋出AddressException
  }
}
