package com.sanqing.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.util.GetConstructor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;

public class Login extends ActionSupport{
	private String username;
	private String password;
	private UserService userService;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String execute() throws Exception{
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		HttpServletRequest request=ServletActionContext.getRequest();
		if(userService.loginUser(user)){
			request.setAttribute("url", "user/getBlogInfo.action");
			request.setAttribute("info", "登录成功！");
			request.setAttribute("username", username);
			//将username保存到session范围中
//			HttpSession session =request.getSession();
			Map session = ActionContext.getContext().getSession();
//			session.setAttribute("username", username);	
			session.put("username", username);
			return SUCCESS;
		}else{
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "登陆失败");
			return ERROR;
			
		}
		
	}
}
