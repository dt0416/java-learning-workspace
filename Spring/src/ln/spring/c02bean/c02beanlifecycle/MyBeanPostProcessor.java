/**
 * 
 */
package ln.spring.c02bean.c02beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(String.format("postProcessBeforeInitialization:%s", bean));
		return bean; // 不可return null
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(String.format("postProcessAfterInitialization:%s", bean));
		return bean; // 不可return null
	}

}
