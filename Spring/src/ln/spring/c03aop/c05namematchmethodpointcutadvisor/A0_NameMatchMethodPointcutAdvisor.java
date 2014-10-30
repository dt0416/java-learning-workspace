package ln.spring.c03aop.c05namematchmethodpointcutadvisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 前置通知 範例
 * 
 * @author Ian Chen
 */
public class A0_NameMatchMethodPointcutAdvisor {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c03aop/c05namematchmethodpointcutadvisor/beans-config.xml");
		
		System.out.println("***** 沒使用AOP *****");
		Student student = (Student)ac.getBean("student");
		student.sayHello();
		student.sayBye();
		
		System.out.println("***** 使用AOP *****");
		IStudent aopStudent = (IStudent)ac.getBean("proxyFactoryBean");
		aopStudent.sayHello(); // 只有此方法被叫用前置通知
		aopStudent.sayBye();
	}
}
