package ln.spring.c02bean.c02beanlifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 示範Bean Lifecycle
 *
 * <p>
 * Aware相關介面: BeanNameAware, BeanFactoryAware, ApplicationContextAware
 * 各可以取得: BeaneName, BeanFactory, ApplicationCOntext
 * 但使用了這些介面就會與spring耦合, 沒必要就不要使用
 * </p>
 * 
 * @author Ian Chen
 */
public class A0_BeanLifeCycle {
	public static void main(String[] args) {
		/**
		 * ApplicationContext Bean LifeCycle:
		 * 
		 * 建構(Constructor)
		 * 屬性注入(setXXX)
		 * BeanNameAware 的 setBeanName
		 * BeanFactoryAware 的 setBeanFactory
		 * ApplicationContextAware 的 setApplicationContext
		 * BeanPostProcessor 的 postProcessBeforeInitialization(後製處理器, 實現AOP概念)
		 * InitializingBean 的 afterPropertiesSet(在 postProcessBeforeInitialization與postProcessAfterInitialization中間)
		 * Bean定義檔中定義init-method
		 * BeanPostProcessor 的 postProcessAfterInitialization(後製處理器, 實現AOP概念)
		 * ***
		 * 使用Bean(getBean並拿來使用)
		 * ***
		 * Spring容器關閉
		 * DisposableBean 的 destroy
		 * Bean定義檔中定義destroy-method
		 * **************************************************
		 * 
		 * 常用Life Cycle流程架構:
		 * 
		 * 建構(Constructor)
		 * 屬性注入(setXXX)
		 * BeanPostProcessor 的 postProcessBeforeInitialization(後製處理器, 實現AOP概念)
		 * BeanPostProcessor 的 postProcessAfterInitialization(後製處理器, 實現AOP概念)
		 * 使用Bean(getBean並拿來使用)
		 * Spring容器關閉
		 */
		System.out.println("***** ApplicationContext Bean LifeCycle *****");
		System.out.println("準備取得ApplicationContext");
		ApplicationContext ac = new ClassPathXmlApplicationContext("ln/spring/c02bean/c02beanlifecycle/beans-config.xml");
		System.out.println("已取得ApplicationContext");
		System.out.println("準備取得Student");
		Student student = (Student)ac.getBean("student");
		student.sayHello();
		
		/**
		 * BeanFactory Bean LifeCycle(N為不會被調用), 比ApplicationContext Bean LifeCycle簡單許多:
		 * Y 建構(Constructor)
		 * Y 屬性注入(setXXX)
		 * Y BeanNameAware 的 setBeanName
		 * Y BeanFactoryAware 的 setBeanFactory
		 * N ApplicationContextAware 的 setApplicationContext
		 * N BeanPostProcessor 的 postProcessBeforeInitialization(後製處理器, 實現AOP概念)
		 * Y InitializingBean 的 afterPropertiesSet(在 postProcessBeforeInitialization與postProcessAfterInitialization中間)
		 * Y Bean定義檔中定義init-method
		 * N BeanPostProcessor 的 postProcessAfterInitialization(後製處理器, 實現AOP概念)
		 * ***
		 * 使用Bean(getBean並拿來使用)
		 * ***
		 * Spring容器關閉
		 * DisposableBean 的 destroy
		 * Bean定義檔中定義destroy-method
		 */
		System.out.println("***** BeanFactory Bean LifeCycle *****");
		System.out.println("準備取得Resource");
		Resource rs = new ClassPathResource("ln/spring/c02bean/c02beanlifecycle/beans-config.xml");  
		System.out.println("已取得Resource");
		System.out.println("準備取得BeanFactory");
		BeanFactory factory = new XmlBeanFactory(rs);
		System.out.println("isSingleton:" + factory.isSingleton("student"));
		System.out.println("已取得BeanFactory");
		System.out.println("準備取得Student");
		// UserBean在此處建構
		Student student4bf = (Student)factory.getBean("student");
		student4bf.sayHello();
	}

}
