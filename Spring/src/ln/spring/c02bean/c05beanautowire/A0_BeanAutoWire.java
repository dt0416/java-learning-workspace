package ln.spring.c02bean.c05beanautowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 示範自動綁定
 * Autowiring modes:
 * no
 * byName
 * byType
 * constructor
 * autodetect : 會嘗試使用constructor，然後使用byType，哪一個先符合就先用
 * default : 讀取beans屬性default-autowire(預設no)
 * 
 * 自動綁定因為存在不確定性, 較不建議被使用
 * 
 * @author Ian Chen
 */
public class A0_BeanAutoWire {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c05beanautowire/beans-config.xml");
		System.out.println("***** byName *****");
		Student student = (Student)ac.getBean("student");
		System.out.println(student.getName() + ", " + student.getTeacher().getName());

		System.out.println("\n***** byType *****");
		// 找不到或多個皆會有Exception
		Student student2 = (Student)ac.getBean("student2");
		System.out.println(student2.getName() + ", " + student2.getTeacher().getName());

		System.out.println("\n***** constructor *****");
		// Student需要有對應的constructor
		Student student3 = (Student)ac.getBean("student3");
		System.out.println(student3.getName() + ", " + student3.getTeacher().getName());

		System.out.println("\n***** default *****");
		Student student4 = (Student)ac.getBean("student4");
		System.out.println(student4.getName() + ", " + student4.getTeacher().getName());
	}
}
