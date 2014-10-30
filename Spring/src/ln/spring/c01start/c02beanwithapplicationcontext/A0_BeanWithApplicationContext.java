package ln.spring.c01start.c02beanwithapplicationcontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



/**
 * 示範ApplicationContext與BeanFactory的差異
 * 
 * @author Ian Chen
 */
public class A0_BeanWithApplicationContext {
	public static void main(String[] args) {
		/**
		 * Spring ApplicationContext寫法
		 * 注意UserBean的建構時機
		 * 特色:預先建構所有Bean, 優點:速度較快, 缺點:浪費記憶體
		 * 一般沒有特殊要求90%皆會使用ApplicationContext
		 * 且spring建議使用此方法
		 */
		System.out.println("***** Spring ApplicationContext寫法 *****");
		// UserBean, MyBean在此處建構(scope=singleton時才是)
		System.out.println("準備取得ApplicationContext");
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c01start/c02beanwithapplicationcontext/beans-config.xml");
		System.out.println("已取得ApplicationContext");
		System.out.println("準備取得Student");
		// scope非singletone時也是在此時才被建構
		Student student4s = (Student)ac.getBean("student");
		student4s.sayHello();
		
		/**
		 * Spring BeanFactory寫法
		 * 此方法在Version 3已被Deprecated
		 * 注意UserBean的建構時機
		 * 特色:取得物件時才建構Bean, 優點:節約記憶體, 缺點:速度較慢
		 */
		System.out.println("***** Spring BeanFactory寫法 *****");
		System.out.println("準備取得Resource");
		Resource rs = new ClassPathResource("ln/spring/c01start/c02beanwithapplicationcontext/beans-config.xml");  
		System.out.println("已取得Resource");
		System.out.println("準備取得BeanFactory");
		BeanFactory factory = new XmlBeanFactory(rs);
		System.out.println("isSingleton:" + factory.isSingleton("student"));
		System.out.println("已取得BeanFactory");
		System.out.println("準備取得Student");
		// UserBean在此處建構
		Student student4s2 = (Student)factory.getBean("student");
		student4s2.sayHello();
	}

}
