package top.esmart.rpc.transport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import top.esmart.vo.RPCRequest;

/**
 * 
* @ClassName: TCPTransport 
* @Description: TODO 客户端网络通信封装 
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午3:50:59
 */
public class TCPTransport {

    public String host;//主机

    public Integer port;//端口
    
    public TCPTransport(String host, Integer port) {
        this.host = host;
        this.port = port;
    }
    //创建一个socket连接
    private Socket newSocket(){
        try {
            return new Socket(host,port);
        } catch (IOException e) {
            throw new RuntimeException("连接建立失败");
        }
    }
    //发送请求
    public Object send(RPCRequest rpcRequest){
        Socket socket = newSocket();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        //发送请求到服务端
        try {
        	 //拿到socket输出流-用于把数据写入socket
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            
            objectOutputStream.writeUTF("1234567890");
            //写入序列化的对象
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            //拿到输入流-用于读取socket中的返回值
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发起远程调用异常",e);
        } finally {
        	//关闭流
        	if(objectOutputStream!=null) {
        		try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(objectInputStream!=null) {
        		try {
        			objectInputStream.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        	
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
