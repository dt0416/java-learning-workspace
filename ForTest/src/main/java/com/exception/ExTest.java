package com.exception;

public class ExTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      new ThrowException().calculate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
