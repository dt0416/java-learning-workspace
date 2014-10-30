package ln.spring.c02bean.c04beaninherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 示範Bean繼承
 * 
 * @author Ian Chen
 */
public class A0_BeanInherit {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c04beaninherit/beans-config.xml");
		System.out.println("***** 原始Student *****");
		Student student = (Student)ac.getBean("student");
		System.out.println(student.getName());
		
		System.out.println("***** StudentSmall未使用parent *****");
		SmallStudent smaillStudent1 = (SmallStudent)ac.getBean("smallStudent1");
		System.out.println(smaillStudent1.getName() + ", " + smaillStudent1.getAge());
		
		System.out.println("***** StudentSmall使用parent *****");
		SmallStudent smaillStudent2 = (SmallStudent)ac.getBean("smallStudent2");
		System.out.println(smaillStudent2.getName() + ", " + smaillStudent2.getAge());
		
		System.out.println("***** StudentSmall使用 抽象parent *****");
		SmallStudent smaillStudent3 = (SmallStudent)ac.getBean("smallStudent3");
		System.out.println(smaillStudent3.getName() + ", " + smaillStudent3.getAge());
	}

}
