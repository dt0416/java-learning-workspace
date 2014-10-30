package com.exception;

public class ThrowException {
	public void calculate() throws Exception {
		int result;
		try {
			result = 1/0;
			System.out.println(result);
		} catch (Exception e) {
			throw e;
		}
	}
}
