package com.justzqh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justzqh.po.UserTCustom;
import com.justzqh.po.UserTQauryVo;
import com.justzqh.service.imp.UserService;


/**
 * 
* @Title: UserController.java
* @author: zqh
* @date 2016-4-17 下午06:28:50
* @Description:用户相关控制器，登陆，注册，更新操作处理器
 */
@Controller
@RequestMapping("/users")
public class UserController {
	
	//注入用户service接口
	@Autowired
	private UserService userService;
	
	/**
	 * 
	* @Title: loginUserSubmit
	* @author: zqh
	* @date 2016-4-17 下午06:39:04
	* @Description:用户登陆处理 
	* @param userTCustom
	* @return
	* @throws Exception
	*
	 */
	@RequestMapping("/login")
	public String loginUserSubmit(UserTCustom userTCustom)throws Exception{
		
		
		return "success";
	}
	
	
	
	
	@RequestMapping("/registerEdit")
	public String registerUserEdit() throws Exception{
			
		//重定向到主页
		return "redirect:http://localhost:8080/springmvc_mybatis/";
	}
	
	/**
	 * 
	* @Title: registerUserSubmit
	* @author: zqh
	* @date 2016-4-17 下午06:41:01
	* @Description:用户注册处理 
	* @param userTCustom
	* @return
	* @throws Exception
	*
	 */
	//通过校验器对userCustom进行校验
	@RequestMapping("/register")
	public String registerUserSubmit(Model model, @Validated UserTCustom userTCustom ,BindingResult bindingResult) throws Exception{
			
		if(bindingResult.hasErrors()){
			
			String nameError = null;
			String namePatternError = null;
			String emailError = null;
			String emailPattenError = null;
			String passWordError = null;
			
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error:allErrors){
				
				String errorType = error.getCodes()[1];
				System.out.println(errorType);
				
				if(errorType.equals("Size.name")){
					
					nameError = "Name size should be in 1-20!";
				}
				else if (errorType.equals("Pattern.name")) {
					
					namePatternError = "Username must be begin with char or _ !";
					model.addAttribute("namePatternError", namePatternError);
					
				}
				else if(errorType.equals("Size.email")){
					
					emailError = "Email should not empty,and have limited size!";
				}
				else if (errorType.equals("Email.email")) {
					
					emailPattenError = "This email is not a correct email!";
				}
				else if (errorType.equals("Size.password")) {
					
					passWordError = "Password should not empty,and have limited size!";	
				}
				
			}
			
			model.addAttribute("nameError", nameError);
			model.addAttribute("emailError", emailError);
			model.addAttribute("passwdError", passWordError);
			model.addAttribute("emailPattenError", emailPattenError);
			
			
			//model.addAttribute("allErrors", userInfoErrorVo);//利用springmvc默认的model参数向jsp页面传递参数
			
			return "/template/register";//跳转到注册页面
			
			
		}
		else if (userTCustom.getPassword().equals(userTCustom.getPasswdConfirm()) == false){
			
			//两次输入的密码不一致
			String passwdConfirmError = "The passwords you entered must be the same!";
			
			model.addAttribute("passwdConfirmError", passwdConfirmError);
			return "/template/register";//跳转到注册页面
		}
		else {
			
			String sameEmail = null;
			String sameName = null;
			
			//查询上否信息重复条件类
			UserTQauryVo userTQauryVo = new UserTQauryVo();
			userTQauryVo.setUserTCustom(userTCustom);
			
			
			if (userService.findUserByName(userTQauryVo) != null) {
				//用户名重复
				//回显错误信息到注册页面	
				sameName = "This name has been used, please chose another!";
				model.addAttribute("sameName", sameName);
				return "/template/register";//跳转到注册页面
				
				
			}
			else if(userService.findUserByEmail(userTQauryVo) != null){
				//邮箱重复注册
				//回显错误信息到注册页面
				sameEmail = "This email has been used, please chose another!";
				model.addAttribute("sameEmail", sameEmail);
				return "/template/register";//跳转到注册页面
			}
			
			//满足插入条件，id自增，直接插入即可
			userService.insertUserInfo(userTCustom);
			//重定向到主页或成功页面
			return "/index";
		}
		
		
	}
	

}
