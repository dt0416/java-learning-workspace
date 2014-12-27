package com.exception;

public class TryException {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String j = "a";
    try {
      System.out.printf("result:%1", 1 / Integer.parseInt(j));
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }

  }

}
