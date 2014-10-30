package ln.spring.c01start.c03applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 示範 取得ApplicationContext三種方法
 * ClassPathXmlApplicationContext(從Classpath中來讀取XML定義檔)
 * FileSystemXmlApplicationContext(可指定XML定義檔的相對路徑或絕對路徑來讀取定義檔)
 * XmlWebApplicationContext(在Web應用程式中的檔案架構中讀取定義檔, Web才能用)
 * 
 * @author Ian Chen
 */
public class A0_MyApplicationContext {
	public static void main(String[] args) {
		System.out.println("***** ClassPathXmlApplicationContext寫法 *****");
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("ln/spring/c01start/c03applicationcontext/beans-config.xml");
		Student student1 = (Student)ac1.getBean("student");
		student1.sayHello();

		System.out.println("***** FileSystemXmlApplicationContext寫法 *****");
		ApplicationContext ac2 = new FileSystemXmlApplicationContext("D:\\Eclipse_Workspace\\Eclipse_Workspace_Learning_Sample\\Spring\\src\\ln\\spring\\c01start\\c03applicationcontext\\beans-config.xml");
		Student student2 = (Student)ac2.getBean("student");
		student2.sayHello();
	}

}
