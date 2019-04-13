package top.esmart.rpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import top.esmart.rpc.handler.ProcessorHandler;
import top.esmart.rpc.impl.InfoServiceImpl;
import top.esmart.service.InfoService;

/**
 * 
* @ClassName: RPCServer 
* @Description: TODO rpc服务端 
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午3:43:47
 */
public class RPCServer {

	public static void main(String[] args) {
		
		InfoService service = new InfoServiceImpl();
		RPCServer server = new RPCServer();
		//发布服务
		server.publisher(service, 8888);
		
	}
	
    //创建线程池-由线程池不断的执行线程任务
    private static final ExecutorService executorService=Executors.newCachedThreadPool();

    //发布服务
    public void publisher(Object service,Integer port){
    	
    	ServerSocket serverSocket =null;
    	try {
            serverSocket = new ServerSocket(port);
            System.err.println("RPCServer 已经启动");
            //循环监听-基于bio阻塞方式实现
            while (true){
                Socket socket = serverSocket.accept();
                //把连接交给任务处理
                executorService.submit(new ProcessorHandler(socket,service));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	if(serverSocket!=null) {
        		try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
		}
    }
    

}
