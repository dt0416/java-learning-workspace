package com.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MapNullTest();
	}
	
	/**
	 * 測試丟null和不給值時, 取值時的結果是否皆為null
	 */
	public static void MapNullTest()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("AAA", null);
		// 測試有put但為null的值
		String aaa = map.get("AAA");
		// 測試無put的值
		String bbb = map.get("BBB");
		
		// 結論:aaa、bbb結果一樣皆為null
		System.out.println(aaa == null);
		System.out.println(bbb == null);
	}

}
