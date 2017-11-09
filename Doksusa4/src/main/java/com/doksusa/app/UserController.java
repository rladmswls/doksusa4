package com.doksusa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doksusa.a_solution.A_solutionDTO;
import com.doksusa.user.UserDTO;
import com.doksusa.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	
	@RequestMapping("/userlist")
	public String showList(Model model){
		List<UserDTO> list = userservice.user_selectAll();
		model.addAttribute("userlist", list);
		/*ModelAndView mv = new ModelAndView();
		mv.addObject("user2", new A_solutionDTO());
		mv.setViewName("userlist");*/
		return "userlist";
	}
	
}
