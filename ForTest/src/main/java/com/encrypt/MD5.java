package com.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fet.car.utility.PasswordUtil;

public class MD5 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      System.out.println(strToMd5("SPV123"));

      // HP提供之MD5加密法
      String ciphertext = PasswordUtil.passwordEncryption("SPV123");
      System.out.println("ciphertext = " + ciphertext);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  /**
   * 將字串使用MD5演算法加密
   * @param str
   * @return
   * @throws NoSuchAlgorithmException
   */
  public static synchronized String strToMd5(String str) throws NoSuchAlgorithmException {
    String result = "";
    MessageDigest md = MessageDigest.getInstance("MD5");

    md.update(str.getBytes());
    byte[] digest = md.digest();
    BigInteger bigInt = new BigInteger(1, digest);
    result = bigInt.toString(16);
    // Now we need to zero pad it if you actually want the full 32 chars.
    while (result.length() < 32) {
      result = "0" + result;
    }

    return result;
  }

}
