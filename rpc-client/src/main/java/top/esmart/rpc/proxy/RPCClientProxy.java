package top.esmart.rpc.proxy;

import java.lang.reflect.Proxy;
/**
 * 
* @ClassName: RPCClientProxy 
* @Description: TODO 客户端获取代理
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午3:11:52
 */
public class RPCClientProxy {

	/**
	 * 
	*
	* @Title: clientProxy 
	* @Description: TODO 
	* @param @param target 服务接口
	* @param @param host 主机
	* @param @param port 端口
	* @param @return    设定文件 
	* @return T    返回类型 
	* @throws
	 */
    @SuppressWarnings("unchecked")
	public <T> T clientProxy(Class<T> target,String host,Integer port){
        return (T)Proxy.newProxyInstance(target.getClassLoader(),
        		new Class[]{target},
        		new ClientProxy(host,port));
    }
}
