package top.esmart.rpc.impl;

import org.springframework.stereotype.Service;

import top.esmart.model.User;
import top.esmart.service.DataService;

/**
 * 
* @ClassName: DataServiceImpl 
* @Description: TODO 接口实现
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午4:06:52
 */
@Service
public class DataServiceImpl implements DataService {

	
	@Override
	public void add(User user) {
		
		System.err.println("添加成功："+user.toString());
	}

	@Override
	public User forData(Integer id) {
		System.err.println("查询用户："+id);
		User user = new User();
		user.setAge(18);
		user.setName("conding-"+id);
		return user;
	}

}
