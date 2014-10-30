package ln.spring.c03aop.c04throwadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 異常通知 範例
 * 必須在通知類別宣告特定格式方法(參考MyThrowAdvice)
 * 
 * @author Ian Chen
 */
public class A0_ThrowAdvice {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c03aop/c04throwadvice/beans-config.xml");
		
		System.out.println("***** 沒使用AOP *****");
		Student student = (Student)ac.getBean("student");
		try {
			student.sayHello(); // 會出Exception
		} catch (Exception e) {
			System.out.println(e);
		}
		student.sayBye();
		
		System.out.println("***** 使用AOP *****");
		IStudent aopStudent = (IStudent)ac.getBean("proxyFactoryBean");
		try {
			aopStudent.sayHello(); // 會出Exception
		} catch (Exception e) {
			System.out.println(e);
		}
		aopStudent.sayBye();
	}
}
