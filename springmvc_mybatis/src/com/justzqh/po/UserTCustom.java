package com.justzqh.po;


/**
 * 
* @Title: UserTCustom.java
* @author: zqh
* @date 2016-4-17 下午04:32:58
* @Description:用户信息扩展类，一般不直接用逆向工程生产类
 */
public class UserTCustom extends UserT {
	
	//添加其他用户信息
	
	//用户注册密码确认
	private String passwdConfirm;

	public void setPasswdConfirm(String passwdConfirm) {
		this.passwdConfirm = passwdConfirm;
	}

	public String getPasswdConfirm() {
		return passwdConfirm;
	}
}
