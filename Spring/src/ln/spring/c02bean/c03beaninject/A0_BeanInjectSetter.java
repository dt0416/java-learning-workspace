package ln.spring.c02bean.c03beaninject;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 示範Type 2的Setter injection, 利用Bean的Setter完成依賴注入
 * Spring鼓勵的是Setter injection
 * 
 * @author Ian Chen
 */
public class A0_BeanInjectSetter {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c03beaninject/beans-config.xml");
		Student student = (Student)ac.getBean("student");
		System.out.println("***** 取得陣列字串friends *****");
		for (String friend : student.getFriends()) {
			System.out.println(friend);
		}
		
		System.out.println("***** 取得陣列物件teachers *****");
		for (Teacher teacher : student.getTeachers()) {
			System.out.println(teacher.getName());
		}
		
		System.out.println("***** 取得List物件listTeachers *****");
		for (Teacher teacher : student.getListTeachers()) {
			System.out.println(teacher.getName());
		}
		
		// Set不能存放重覆的物件
		System.out.println("***** 取得Set物件setTeachers *****");
		for (Teacher teacher : student.getSetTeachers()) {
			System.out.println(teacher.getName());
		}
		
		System.out.println("***** 取得Map物件mapTeacher *****");
		for (Entry<String, Teacher> tObj  : student.getMapTeacher().entrySet()) {
			System.out.println(tObj.getKey() + ":" + tObj.getValue().getName());
		}
		
		System.out.println("***** 取得內部Bean物件myInnerTeacher *****");
		System.out.println(student.getMyInnerTeacher().getName());
		
		System.out.println("***** Properties物件pp *****");
		Properties pp = student.getPp();
		for (Entry<Object, Object> pObj  : pp.entrySet()) {
			System.out.println(pObj.getKey() + ":" + pObj.getValue());
		}
		System.out.println("** Properties物件pp 取法2 **");
		Enumeration<Object> enu = pp.keys();
		while(enu.hasMoreElements()) {
			String key = (String)enu.nextElement();
			System.out.println(key + ":" + pp.getProperty(key));
		}
	}

}
