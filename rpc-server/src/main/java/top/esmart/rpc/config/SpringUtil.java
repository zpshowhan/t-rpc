package top.esmart.rpc.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextAware:spring容器类，实现此方法可以获取到spring容器，进而获取到容器中的bean
 * 
* @ClassName: SpringContext 
* @Description: TODO 方便获取容器bean
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午4:31:34
 */
@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		SpringUtil.applicationContext=applicationContext;

	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
