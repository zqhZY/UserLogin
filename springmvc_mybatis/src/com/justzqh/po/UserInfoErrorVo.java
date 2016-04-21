package com.justzqh.po;

import java.util.HashMap;

/**
 * 
* @Title: UserInfoErrorVo.java
* @author: zqh
* @date 2016-4-18 下午03:44:01
* @Description:用户信息注册登录校验的错误信息回显pojo
 */
public class UserInfoErrorVo {
	
	//字段名
	//private List<String> name;
	
	//字段错误信息
	//private List<String> errorMessage;
	
	private HashMap<String, String> errorMap;
	
	private boolean isNameError; 
	private boolean isEmailError;
	private boolean isPassWordError;

	public boolean isEmailError() {
		
		if(errorMap.containsKey("Size.email")){
			
			isEmailError = true;
		}
		else{
			
			isEmailError = false;
		}
		return isEmailError;
	}

	public void setEmailError(boolean isEmailError) {
		this.isEmailError = isEmailError;
	}

	public boolean isPassWordError() {
		
		if(errorMap.containsKey("Size.password")){
			
			isPassWordError = true;
		}
		else {
			
			isPassWordError = false;
		}
		return isPassWordError;
	}

	public void setPassWordError(boolean isPassWordError) {
		this.isPassWordError = isPassWordError;
	}

	public HashMap<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(HashMap<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public boolean isNameError() {
		
		if(errorMap.containsKey("Size.name")){
			
			isNameError = true;
		}
		else {
			
			isNameError = false;
		}
		return isNameError;
	}

	public void setNameError(boolean isNameError) {
		this.isNameError = isNameError;
	}



}
