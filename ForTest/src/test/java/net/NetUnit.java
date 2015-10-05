package net;

import static org.junit.Assert.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class NetUnit {

  @Test
  public void testInetAddress() throws UnknownHostException {
    InetAddress addr = InetAddress.getLocalHost();
    String hostName = addr.getHostName();
    String hostAddress = addr.getHostAddress();
    System.out.println(hostName);
    System.out.println(hostAddress);
    assertNotNull(hostName);
    assertNotNull(hostAddress);
  }

}
