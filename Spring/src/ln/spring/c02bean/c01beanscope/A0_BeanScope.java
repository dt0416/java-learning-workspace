package ln.spring.c02bean.c01beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 示範Bean scope
 * singleton(預設): 單例
 * prototype      : 一個bean就會產生一個(如無必要盡量不要用, 會讓效能變慢)
 * request(web)   :
 * session(web)   :
 * global session :
 * 
 * @author Ian Chen
 */
public class A0_BeanScope {
	public static void main(String[] args) {
		System.out.println("***** singleton *****");
		// UserBean, MyBean在此處建構(scope=singleton時才是)
		System.out.println("準備取得ApplicationContext");
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c01beanscope/beans-config.xml");
		System.out.println("已取得ApplicationContext");
		System.out.println("準備取得Student");
		// scope非singletone時也是在此時才被建構
		Student student = (Student)ac.getBean("student");
		student.sayHello();
		
		System.out.println("***** prototype *****");
		System.out.println("準備取得Teacher");
		// scope非singletone時在此時才被建構
		Teacher teacher = (Teacher)ac.getBean("teacher");
		teacher.sayHello();
	}

}
