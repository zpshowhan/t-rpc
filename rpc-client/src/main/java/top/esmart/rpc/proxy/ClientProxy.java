package top.esmart.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import top.esmart.rpc.transport.TCPTransport;
import top.esmart.vo.RPCRequest;

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
	       rpcRequest.setClassName(method.getDeclaringClass().getName());
	       rpcRequest.setMethodName(method.getName());
	       rpcRequest.setParameters(args);
	       TCPTransport tcpTransport = new TCPTransport(host,port);
	       return tcpTransport.send(rpcRequest);
	}

}
