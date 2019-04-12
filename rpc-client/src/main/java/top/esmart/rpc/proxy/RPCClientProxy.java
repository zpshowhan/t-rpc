package top.esmart.rpc.proxy;

import java.lang.reflect.Proxy;

public class RPCClientProxy {

    @SuppressWarnings("unchecked")
	public <T> T clientProxy(Class<T> target,String host,Integer port){
        return (T)Proxy.newProxyInstance(target.getClassLoader(),new Class[]{target},new ClientProxy(host,port));
    }
}
