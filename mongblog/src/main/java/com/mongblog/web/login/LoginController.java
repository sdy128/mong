package com.mongblog.web.login;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongblog.web.user.dao.UserDAO;
import com.mongblog.web.user.model.UserVO;
import com.mongblog.web.user.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception{
		model.addAttribute("userVO", new UserVO());
		return "login/login";
		
	}
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "login/signupForm";
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(UserVO userVO) throws Exception{
		boolean result = userService.loginCheck(userVO);
		if(result == true) {
			return "redirect:/board/getBoardList";
		}
		else
		{
			return "redirect:/login/login";
		}
	}
	
}
