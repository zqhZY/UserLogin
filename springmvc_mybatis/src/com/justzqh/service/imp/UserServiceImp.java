package com.justzqh.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.justzqh.mapper.UserTMapper;
import com.justzqh.mapper.UserTMapperCustom;
import com.justzqh.po.UserT;
import com.justzqh.po.UserTCustom;
import com.justzqh.po.UserTQauryVo;

/**
 * 
* @Title: UserServiceImp.java
* @author: zqh
* @date 2016-4-17 下午04:37:59
* @Description:userService实现类
 */
public class UserServiceImp implements UserService{

	//自定义user的mapper接口
	@Autowired
	private UserTMapperCustom userTMapperCustom;
	
	//用户mapper接口注入
	@Autowired
	private UserTMapper userTMapper;
	
	@Override
	public UserTCustom findUserByEmail(UserTQauryVo userTQauryVo) throws Exception {
		// TODO Auto-generated method stub
		UserTCustom userTCustom = userTMapperCustom.findUserByEmail(userTQauryVo);
		return userTCustom;
	}

	@Override
	public UserTCustom findUserByName(UserTQauryVo userTQauryVo) throws Exception {
		// TODO Auto-generated method stub 
		UserTCustom userTCustom = userTMapperCustom.findUserByName(userTQauryVo);
		return userTCustom;
	}

	@Override
	public void insertUserInfo(UserTCustom userTCustom) throws Exception {
		// TODO Auto-generated method stub
		UserT userT = new UserT();
		BeanUtils.copyProperties(userTCustom, userT);		
		userTMapper.insert(userT);
			
	}

}
