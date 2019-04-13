package top.esmart.rpc.impl;

import top.esmart.model.User;
import top.esmart.service.InfoService;

/**
 * 
* @ClassName: InfoServiceImpl 
* @Description: TODO 服务端-服务实现
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午4:06:15
 */
public class InfoServiceImpl implements InfoService {

	@Override
	public String info(User user) {
		System.err.println("接收数据："+user.toString());
		return "我已经接收到数据："+user.toString();
	}

}
