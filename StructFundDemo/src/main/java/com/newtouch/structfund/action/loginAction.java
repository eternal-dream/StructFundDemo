package com.newtouch.structfund.action;

import com.newtouch.structfund.entity.User;
import com.newtouch.structfund.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@SuppressWarnings("all")
public class loginAction {
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("login")
	public String login(User user,HttpSession session) throws Exception {
		User loginUser=userMapper.queryUser(user);
		if(loginUser!=null) {
			session.setAttribute("userInfo", loginUser);
			return "success";
		}else {
			return "用户名或密码错误,登录失败!";
		}
		
	}

}
