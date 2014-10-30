package ln.spring.c02bean.c02beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Student implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	private String name;
	
	// Constructor
	public Student() {
		System.out.println("Student Constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Student setName");
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(String.format("Student Hello!! My Name is %s", name));
	}

	/**
	 * BeanNameAware
	 */
	@Override
	public void setBeanName(String name) {
		System.out.println(String.format("setBeanName:%s", name));
	}

	/**
	 * BeanFactoryAware
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(String.format("setBeanFactory:%s", beanFactory));
	}

	/**
	 * ApplicationContextAware
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println(String.format("setApplicationContext:%s", applicationContext));
		
	}

	/**
	 * InitializingBean
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(String.format("afterPropertiesSet"));		
	}
	
	public void initBean() {
		System.out.println(String.format("initBean"));
	}

	/**
	 * DisposableBean
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println(String.format("destroy"));		
	}
	
	/**
	 * 自行定義的destroy
	 */
	public void destroyBean() {
		System.out.println(String.format("destroyBean"));
	}
}
