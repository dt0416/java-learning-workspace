package ln.spring.c03aop.c02afteradvice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 實作AfterReturningAdvice實現After Advice
 * 
 * @author Ian Chen
 */
public class MyAfterReturnngAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("method return..." + method.getName());
	}

}
