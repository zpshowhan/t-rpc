package top.esmart.rpc.client;

import top.esmart.model.User;
import top.esmart.rpc.proxy.RPCClientProxy;
import top.esmart.service.InfoService;

public class RPCClient {

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					RPCClientProxy clientProxy = new RPCClientProxy();
					InfoService service=clientProxy.clientProxy(InfoService.class, "localhost", 8888);
					User user=new User();
					user.setName("王五");
					user.setAge(18);
					String result = service.info(user);
					System.out.println("result: "+result);
				}
			}).start();
		}

	}
}
