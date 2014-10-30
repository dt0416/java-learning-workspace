package ln.spring.c03aop.c05namematchmethodpointcutadvisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 實作MethodBeforeAdvice實現Before Advice
 * 
 * @author Ian Chen
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("method starts..." + method.getName());

	}
}
