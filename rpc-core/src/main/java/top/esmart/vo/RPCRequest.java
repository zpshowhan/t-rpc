package top.esmart.vo;

import java.io.Serializable;

/**
 * 
* @ClassName: RPCRequest 
* @Description: TODO rpc请求类
* @Company:方正软件
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午2:50:31
 */
public class RPCRequest implements Serializable{

    /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -8900670287216465385L;
	private String className;//接口类路径com.bb.cg
    private String methodName;//调用的方法
    private Object[] parameters;//调用的参数
 
    public String getClassName() {
        return className;
    }
 
    public void setClassName(String className) {
        this.className = className;
    }
 
    public String getMethodName() {
        return methodName;
    }
 
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
 
    public Object[] getParameters() {
        return parameters;
    }
 
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
