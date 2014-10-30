package ln.spring.c03aop.c03aroundadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 包圍通知 範例
 * 
 * 包圍的開始比Before Advice晚
 * 包圍的結束比After Advice早
 * 流程如下:
 * Before Advice
 * Around Advice Begin
 * ...
 * Around Advice End
 * After Advice
 * 
 * @author Ian Chen
 */
public class A0_AroundAdvice {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c03aop/c03aroundadvice/beans-config.xml");
		
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
