package ln.spring.c03aop.c01beforeadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 前置通知 範例
 * 
 * 步驟:
 * 1. 定義Interface(IStudent)
 * 2. 編寫被代理對象(Student)
 * 3. 編寫通知(MyLogBeforeAdvice)
 * 4. 配置beans.config.xml
 *  4.1 配置被代理對象
 *  4.2 配置通知
 *  4.3 配置代理對象(ProxyFactoryBean的對象實例)
 *   4.3.1 代理介面集(proxyInterfaces)
 *   4.3.2 織入通知(interceptorNames)
 *   4.3.3 配置被代理對象(target)
 * 
 * @author Ian Chen
 */
public class A0_BeforeAdvice {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c03aop/c01beforeadvice/beans-config.xml");
		
		System.out.println("***** 沒使用AOP *****");
		Student student = (Student)ac.getBean("student");
		student.sayHello();
		student.sayBye();
		
		System.out.println("***** 使用AOP *****");
		IStudent aopStudent = (IStudent)ac.getBean("proxyFactoryBean");
		aopStudent.sayHello();
		aopStudent.sayBye();
	}
}
