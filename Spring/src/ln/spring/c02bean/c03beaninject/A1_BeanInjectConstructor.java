package ln.spring.c02bean.c03beaninject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 示範Type 3的Constructor injection
 * 
 * @author Ian Chen
 */
public class A1_BeanInjectConstructor {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c03beaninject/beans-config.xml");
		Employee emp = (Employee)ac.getBean("employee");
		System.out.println("***** Emp *****");
		System.out.println(emp.getName() + ", " + emp.getAge());
	}

}
