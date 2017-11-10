package com.doksusa.app;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	@RequestMapping("/login.do")
	public String front() {
		return "login";
	}

	@RequestMapping("/searchID.do")
	public String searchID() {

		return "searchID";
	}

	@RequestMapping("/searchPW.do")
	public String searchPW() {

		return "searchPW";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String user_insert(String u_id, String u_pw, String u_nick) {
		UserDTO userdto = new UserDTO(0, u_id, u_pw, u_nick);
		System.out.println(userdto);
		userservice.user_insert(userdto);
		return "home";
	}

	@RequestMapping("/userlist")
	public String showList(Model model) {
		List<UserDTO> list = userservice.user_selectAll();
		model.addAttribute("userlist", list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user2", new A_solutionDTO());
		mv.setViewName("userlist");
		return "userlist";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String u_id, String u_pw, Model model, HttpSession session) {
		UserDTO user = userservice.login(u_id, u_pw);
		if (user == null) {
			model.addAttribute("message", "등록된 회원이 아닙니다.");
			return "message";
		} else {
			session.setAttribute("u_id", u_id);
			model.addAttribute("user", user);
			return "home";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("u_id");
		
		return "home";

	}

	@RequestMapping("/join.do")
	public String userinsert() {
		return "join";
	}

}
