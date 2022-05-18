package lib.apache.commons;

import static org.junit.Assert.*;


import org.junit.Test;


/**
 * @author Ian Chen
 *
 */
public class EncodeString {

	@Test
	public void testApacheSha256() {
		String stringText = "123";
		String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText);
		assertEquals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3", sha256hex);
	}
	
	@Test
	public void printApacheSh256() {
		String stringText = "ZTPupJg0ZT2fFUCw-P000000001690";
		String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText);
		System.out.println(sha256hex);
	}
}
