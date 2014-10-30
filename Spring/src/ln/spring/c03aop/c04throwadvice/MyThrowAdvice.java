package ln.spring.c03aop.c04throwadvice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 實作ThrowsAdvice實現Throw Advice
 * ThrowsAdvice介面無定義任何方法, 它只是一個標籤介面
 * 
 * 必須的宣告方法
 * public void afterThrowing([Method], [args], [target], Throwable subclass)
 * 範例:
 * public void afterThrowing(Exception ex)
 * public void afterThrowing(RemoteException)
 * public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
 * public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
 * 
 * @author Ian Chen
 */
public class MyThrowAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass) {
		System.out.println("MyThrowAdvice Catch Throw:" + subclass);
	}
}
