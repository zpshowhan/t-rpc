package top.esmart.model;

import java.io.Serializable;

/**
 * 
* @ClassName: User 
* @Description: TODO 公共实体 
* @author Thinkpad 
* @version 1.0 2019年4月12日 下午2:46:39
 */
public class User implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 8119031394764324951L;

	private String name;
	private int age;
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public User() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
