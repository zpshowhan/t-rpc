package top.esmart.rpc.client;

import top.esmart.model.User;
import top.esmart.rpc.proxy.RPCClientProxy;
import top.esmart.service.DataService;
import top.esmart.service.InfoService;
/**
 * 
* @ClassName: RPCClient 
* @Description: TODO rpc客户端 
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午3:11:08
 */
public class RPCClient {

	public static void main(String[] args) {
		//开启200个线程
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					RPCClientProxy clientProxy = new RPCClientProxy();
					
//					InfoService service=clientProxy.clientProxy(InfoService.class, "localhost", 8888);
					User user=new User();
					user.setName("王五");
					user.setAge(18);
//					String result = service.info(user);
					DataService service = clientProxy.clientProxy(DataService.class, "localhost", 8888);
//					service.add(user);
					User reData = service.forData(20);
					System.out.println("result: "+reData);
//					System.out.println("result: "+result);
				}
			}).start();
		}

	}
}
