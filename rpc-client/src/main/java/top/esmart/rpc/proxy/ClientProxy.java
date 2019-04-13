package top.esmart.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import top.esmart.rpc.transport.TCPTransport;
import top.esmart.vo.RPCRequest;
/**
 * 
* @ClassName: ClientProxy 
* @Description: TODO 客户端代理
* @author Thinkpad 
* @version 1.0 2019年4月13日 下午3:11:33
 */
public class ClientProxy implements InvocationHandler {

    public String host;

    public Integer port;
    
	public ClientProxy(String host, Integer port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	       RPCRequest rpcRequest = new RPCRequest();
	       //放入请求接口地址
	       rpcRequest.setClassName(method.getDeclaringClass().getName());
	       //放入请求方法
	       rpcRequest.setMethodName(method.getName());
	       //放入方法参数
	       rpcRequest.setParameters(args);
	       //交给传输层处理
	       TCPTransport tcpTransport = new TCPTransport(host,port);
	       return tcpTransport.send(rpcRequest);
	}

}
