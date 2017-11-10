package com.doksusa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.a_solution.A_solutionDTO;
import com.doksusa.user.UserDTO;
import com.doksusa.user.UserService;

@Controller 
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("/login")
	public String front(){
		return "login";
	}
	
	@RequestMapping("/userlist")
	public String showList(Model model){
		List<UserDTO> list = userservice.user_selectAll();
		model.addAttribute("userlist", list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user2", new A_solutionDTO());
		mv.setViewName("userlist");
		return "userlist";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String u_id, String u_pw, Model model){
		UserDTO user = userservice.login(u_id, u_pw);
		if(user==null){
			model.addAttribute("message","등록된 회원이 아닙니다.");
			return "message";
		}else{
			model.addAttribute("user",user);
			return "login";
		}
	}
	
	
	@RequestMapping("/join")
	public String userinsert(){
		return "user_insert";
	}
	
}
