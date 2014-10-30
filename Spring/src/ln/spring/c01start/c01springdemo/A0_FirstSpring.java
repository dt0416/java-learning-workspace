package ln.spring.c01start.c01springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



/**
 * 第一支spring
 * 
 * @author Ian Chen
 */
public class A0_FirstSpring {
	public static void main(String[] args) {
		// 原生寫法
		System.out.println("***** 原生寫法 *****");
		UserBean ub = new UserBean();
		ub.setName("Jeremy");
		ub.sayHello();
		MyBean mb = new MyBean();
		mb.setName("Jeremy");
		mb.setUb(ub);
		mb.sayHello();
		
		/**
		 * Spring ApplicationContext寫法
		 * 需匯入
		 * commons-logging-1.1.1.jar
		 * spring.jar
		 */
		System.out.println("***** Spring ApplicationContext寫法 *****");
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c01start/c01springdemo/beans-config.xml");
		UserBean ub4s = (UserBean)ac.getBean("userBean");
		ub4s.sayHello();
		MyBean mb4s = (MyBean)ac.getBean("myBean");
		mb4s.sayHello();
		
		/**
		 * Spring BeanFactory寫法
		 * 此方法在Version 3已被Deprecated
		 */
		System.out.println("***** Spring BeanFactory寫法 *****");
		Resource rs = new ClassPathResource("ln/spring/c01start/c01springdemo/beans-config.xml");  
		BeanFactory factory = new XmlBeanFactory(rs);
		UserBean ub4s2 = (UserBean)factory.getBean("userBean");
		ub4s2.sayHello();
		MyBean mb4s2 = (MyBean)factory.getBean("myBean");
		mb4s2.sayHello();
	}

}
