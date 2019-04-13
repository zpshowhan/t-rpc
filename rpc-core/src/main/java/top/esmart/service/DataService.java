package top.esmart.service;

import top.esmart.model.User;

/**
 * 
* @ClassName: DataService 
* @Description: TODO 公共接口类2
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午3:38:25
 */
public interface DataService {

	void add(User user);
	
	User forData(Integer id);
}
