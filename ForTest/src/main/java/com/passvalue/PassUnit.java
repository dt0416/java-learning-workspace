package com.passvalue;

/**
 * 測試傳值後String及物件是否被改變
 * 
 * @author Ian Chen
 *
 */
public class PassUnit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String classString = "ClassString"; // String
        MyObj mo = new MyObj(); // 物件
        mo.objStr = "ObjString";

        passMethod(classString);
        passMethod(mo);
        
        // 結論:
        // 1. 傳字串, 結果『不會』被異動
        // 2. 傳物件, 物件裡的字串屬性『會』被異動
        System.out.println(String.format("classString:%s", classString));
        System.out.println(String.format("mo.objStr:%s", mo.objStr));
    }
    
    /**
     * 改變字串內容
     * @param str
     */
    public static void passMethod(String str) {
        str = "PassString";
    }

    /**
     * 改變物件內容
     * @param mo
     */
    public static void passMethod(MyObj mo) {
        mo.objStr = "PassString"; 
    }
}

/**
 * @author Ian Chen
 * 物件裡有一個字串屬性
 */
class MyObj {
    public String objStr;
}
