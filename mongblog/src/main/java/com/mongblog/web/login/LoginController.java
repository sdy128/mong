package com.mongblog.web.login;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String loginCheck(HttpSession session, UserVO userVO) throws Exception{
		String returnURL = "";
		if(session.getAttribute("login") != null) {
			
			session.removeAttribute("login");
		}
		UserVO vo = userService.loginCheck(userVO);
		
		if(vo != null) {
			session.setAttribute("login", vo);
			returnURL = "redirect:/board/getBoardList";
		}else {
			returnURL = "redirect:/login/login";
		}
		
		return returnURL;

	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
	
	
}
