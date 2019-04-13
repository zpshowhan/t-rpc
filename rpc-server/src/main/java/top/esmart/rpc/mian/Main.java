package top.esmart.rpc.mian;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import top.esmart.rpc.config.RPCConfig;
import top.esmart.rpc.server.RPCServer;
import top.esmart.service.InfoService;

/**
 * 
* @ClassName: Main 
* @Description: TODO spring方式启动类
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午3:35:13
 */
public class Main {

	public static void main(String[] args) throws BeansException, ClassNotFoundException {
		ApplicationContext app = new AnnotationConfigApplicationContext(RPCConfig.class);
		String[] beanDefinitionNames = app.getBeanDefinitionNames();
		//测试
		for(String bean:beanDefinitionNames) {
			System.out.println(bean);
		}
		//测试
		Object bean = app.getBean(Class.forName("top.esmart.service.DataService"));
		System.out.println(bean instanceof InfoService);
		
		//服务端启动
		RPCServer server = new RPCServer();
		server.publisher2(8888);
	}
}
