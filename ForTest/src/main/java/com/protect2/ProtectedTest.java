package com.protect2;

import com.protect.MyObject;

/**
 * class MyObject裡的protected方法在此無法被使用
 * 
 * @author Ian Chen
 */
public class ProtectedTest {

  public static void main(String[] args) {
    //以下這行會有compile error
    //new MyObject().getHello("Mary");
  }
}
