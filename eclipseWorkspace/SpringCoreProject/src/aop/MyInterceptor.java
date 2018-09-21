package aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyInterceptor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object beanName, String arg) throws BeansException {
		System.out.println("-----------------ok----afterExecution-------------------");
		return beanName;
	}

	@Override
	public Object postProcessBeforeInitialization(Object beanName, String arg) throws BeansException {
		System.out.println("-----------------ok----beforeExecution-------------------");
		return beanName;
	}
	
}
