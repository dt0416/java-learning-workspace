package ln.spring.c03aop.c02afteradvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 後置通知 範例
 * 
 * @author Ian Chen
 */
public class A0_AfterAdvice {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c03aop/c02afteradvice/beans-config.xml");
		
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
