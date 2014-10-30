package ln.spring.c03aop.c03aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 實作MethodInterceptor實現Around Advice
 * 
 * @author Ian Chen
 */
public class MyAroundAdvice implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("Advice Begin");
    Object obj = invocation.proceed();
    System.out.println("Advice End");
    return obj;
  }
}
