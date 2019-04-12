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
* @Company:方正软件
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午3:50:59
 */
public class TCPTransport {

    public String host;

    public Integer port;
    
    public TCPTransport(String host, Integer port) {
        this.host = host;
        this.port = port;
    }
    private Socket newSocket(){
        try {
            return new Socket(host,port);
        } catch (IOException e) {
            throw new RuntimeException("连接建立失败");
        }
    }
    public Object send(RPCRequest rpcRequest){
        Socket socket = newSocket();
        //发送请求到服务端
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            objectInputStream.close();
            objectOutputStream.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发起远程调用异常",e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
