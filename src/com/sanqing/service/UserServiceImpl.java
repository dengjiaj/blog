package com.sanqing.service;

import com.sanqing.dao.UserDAO;
import com.sanqing.po.User;

public class UserServiceImpl implements UserService {
	private UserDAO userdao;
	public boolean registerUser(User user) {
		if(userdao.queryByID(user.getUsername())!=null){//ÅĞ¶ÏÊÇ·ñ´æÔÚ
			return false;
		}else{
			userdao.add(user);
			return true;
		}
	}

	public boolean loginUser(User user) {//ÅĞ¶ÏÕËºÅÃÜÂëÊÇ·ñÒ»Ñù£¬ÅĞ¶ÏµÇÂ¼ÊÇ·ñ³É¹¦
		if(userdao.queryByID(user.getUsername())==null){
			return false;
		}
		else{
			User queryUser=userdao.queryByID(user.getUsername());
			if(user.getPassword().equals(queryUser.getPassword())){
				return true;
			}
			else{
				return false;
			}
		}
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

}
