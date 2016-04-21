package com.justzqh.mapper;

import com.justzqh.po.UserTCustom;
import com.justzqh.po.UserTQauryVo;

/**
 * 
* @Title: UserTMapperCustom.java
* @author: zqh
* @date 2016-4-17 下午04:46:49
* @Description:用户信息映射接口扩展
 */
public interface UserTMapperCustom {
	
	/**
	 * 
	* @Title: findUserByName
	* @author: zqh
	* @date 2016-4-17 下午05:02:29
	* @Description:根据用户名查询用户信息，方法名要与xml中对应sql语句id一致 
	* @param userTQauryVo
	* @return
	* @throws Exception
	*
	 */
	public UserTCustom findUserByName(UserTQauryVo userTQauryVo) throws Exception;
	
	//根据邮箱查询用户信息	
	public UserTCustom findUserByEmail(UserTQauryVo userTQauryVo) throws Exception;
	
	
}
