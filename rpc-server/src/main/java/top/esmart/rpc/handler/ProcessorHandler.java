package top.esmart.rpc.handler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import top.esmart.vo.RPCRequest;

/**
 * 
* @ClassName: ProcessorHandler 
* @Description: TODO 处理客户端请求 
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午3:44:04
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;

    //服务端服务实现-InfoServiceImpl
    private Object service;
    
    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }
	
	@Override
	public void run() {

		ObjectInputStream objectInputStream = null;
		ObjectOutputStream objectOutputStream = null;
        try {
        	//接收socket输入流-用于拿到套接字中的数据
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println(objectInputStream.readUTF());
            //读取输入流，并反序列化成对象
            RPCRequest rpcRequest = (RPCRequest) objectInputStream.readObject();
            //通过反射执行逻辑
            Object result = invoke(rpcRequest);

            //拿到socket输出流-用于把数据写入socket
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //序列化对象
            objectOutputStream.writeObject(result);
            //缓存
            objectOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	//注意最后要关闭流
			if(objectInputStream!=null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(objectOutputStream!=null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//关闭一次
//			try {
//				socket.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

	//通过反射执行方法
	 private Object invoke(RPCRequest rpcRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
	        Object[] args = rpcRequest.getParameters();
	        Class[] types = null;
	        if(args != null){
	            types = new Class[args.length];
	            for(int i=0 ; i<args.length;i++){
	                types[i] = args[i].getClass();
	            }
	        }

	        Method method = service.getClass().getMethod(rpcRequest.getMethodName(),types);
	        return method.invoke(service,args);
	    }
}
