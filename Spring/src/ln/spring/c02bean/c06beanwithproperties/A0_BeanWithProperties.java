package ln.spring.c02bean.c06beanwithproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 分散配置
 * 使用Properties的值注入Bean
 * 
 * @author Ian Chen
 */
public class A0_BeanWithProperties {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c06beanwithproperties/beans-config.xml");
		DBUtil dbu = (DBUtil)ac.getBean("dbutil");
		System.out.println("Name:" + dbu.getName());
		System.out.println("Driver:" + dbu.getDriver());
		System.out.println("Url:" + dbu.getUrl());
		System.out.println("Pwd:" + dbu.getPwd());
	}
}
