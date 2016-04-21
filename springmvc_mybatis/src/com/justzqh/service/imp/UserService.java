package com.justzqh.service.imp;

import com.justzqh.po.UserTCustom;
import com.justzqh.po.UserTQauryVo;

/**
 * 
* @Title: UserService.java
* @author: zqh
* @date 2016-4-17 下午04:29:14
* @Description:用户相关service,用于用户信息的查询更新与插入
 */
public interface UserService {
	
	//根据用户姓名查询用户信息
	public UserTCustom findUserByName(UserTQauryVo userTQauryVo) throws Exception;
	
	//根据用户邮箱查询用户信息
	public UserTCustom findUserByEmail(UserTQauryVo userTQauryVo) throws Exception;
	
	//插入用户信息
	public void insertUserInfo(UserTCustom userTCustom) throws Exception;
	

}
