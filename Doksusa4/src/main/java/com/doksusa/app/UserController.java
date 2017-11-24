package com.doksusa.app;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.a_sub.A_subDTO;
import com.doksusa.ipsiinfo.IpsiInfoDTO;
import com.doksusa.ipsiinfo.IpsiInfoService;
import com.doksusa.user.UserDTO;
import com.doksusa.user.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	IpsiInfoService ipsiservice;

	@RequestMapping("/home.do")
	public String home(Model model) {
		List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
		model.addAttribute("ipsiInfo", ipsiInfo);
		return "home";
	}
	
	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String userinsert(String u_id, String u_pw, String u_nick, String u_phone, Model model) {
		UserDTO userdto = new UserDTO(0, u_id, u_pw, u_nick, u_phone);
		userservice.user_insert(userdto);
		model.addAttribute("userdto", userdto);
		List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
		model.addAttribute("ipsiInfo", ipsiInfo);
		return "home";
	}

	@RequestMapping("/checkID.do")
	@ResponseBody
	public String checkID(String u_id) {
		UserDTO userdto = userservice.user_select(u_id);
		if (userdto == null)
			return "0";
		else
			return "1";

	}

	@RequestMapping("/checkNick.do")
	@ResponseBody
	public String checkNick(String u_nick) {
		UserDTO userdto = userservice.user_selectByNick(u_nick);
		if (userdto == null)
			return "0";
		else
			return "1";

	}
	
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public String checkPhone(String u_phone) {
		UserDTO userdto = userservice.user_selectByPhone(u_phone);
		if (userdto == null)
			return "0";
		else
			return "1";
		
	}

	@RequestMapping("/checkIDPW.do")
	@ResponseBody
	public String checkIDPW(String u_id, String u_pw) {
		UserDTO userdto = userservice.login(u_id, u_pw);
		if (userdto == null)
			return "0";
		else
			return "1";

	}

	@RequestMapping(value = "/check.do", method = RequestMethod.GET)
	public String check() {
		return "check";
	}

	@RequestMapping(value = "/check.do", method = RequestMethod.POST)
	public String usercheck(String u_id, String u_pw, Model model, HttpSession session) {
		UserDTO checkpw = userservice.user_select2(u_id, u_pw);
		if (checkpw == null) {
			model.addAttribute("message", "비밀번호가 틀립니다.");
			return "message";
		} else {
			return "update";
		}
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String Delete() {

		return "delete";
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String userDelete(String yesOrno, Model model, HttpSession session) {
		System.out.println(yesOrno);
		if (yesOrno.equals("예")) {
			List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
			model.addAttribute("ipsiInfo", ipsiInfo);
			String u_id = (String) session.getAttribute("u_id");
			userservice.user_delete(u_id);
			session.invalidate();
			return "home";
		} else {
			List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
			model.addAttribute("ipsiInfo", ipsiInfo);
			return "home";
		}
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String userupdate(UserDTO userdto, Model model) {
		userservice.user_update(userdto);
		System.out.println(userdto.getU_num());
		/*UserDTO userdto = new UserDTO();*/
		/*
		userdto.setU_num();
		userdto.setU_id(u_id);
		userdto.setU_pw(u_pw);
		userdto.setU_nick(u_nick);
		userdto.setU_phone(u_phone);
		System.out.println(userdto);
		userservice.user_update(userdto);*/
		return "home";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String front() {
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String u_id, String u_pw, Model model, HttpSession session) {
		System.out.println(u_id);
		UserDTO user = userservice.login(u_id, u_pw);
		if (user == null) {
			model.addAttribute("message", "등록된 회원이 아닙니다.");
			return "redirect:/login.do";
		} else {
			List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
			model.addAttribute("ipsiInfo", ipsiInfo);
			session.setAttribute("user", user);
			session.setAttribute("u_id", u_id);
			
			session.setAttribute("u_num", user.getU_num());
			model.addAttribute("user", user);
			return "home";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session, Model model) {
		List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
		model.addAttribute("ipsiInfo", ipsiInfo);
		session.invalidate();
		return "home";
	}

	@RequestMapping(value = "/searchID.do", method = RequestMethod.GET)
	public String searchID() {
		return "searchID";
	}

	@RequestMapping(value = "/searchID.do", method = RequestMethod.POST)
	public String searchID2(String u_phone, Model model) {
		System.out.println(u_phone);
		System.out.println("====================================================");
		UserDTO user = userservice.user_selectByPhone(u_phone);
		if (user == null) {
			model.addAttribute("message", "등록된 회원이 아닙니다.");
			return "message";
		} else {
			model.addAttribute("message", "아이디는 " + user.getU_id() + "입니다.");
			return "message2";
		}
	}

	@RequestMapping(value = "/searchPW.do", method = RequestMethod.GET)
	public String searchPW() {
		return "searchPW";
	}

	@RequestMapping(value = "/searchPW.do", method = RequestMethod.POST)
	public String searchPW2(String u_id,String u_nick,String u_phone,Model model) {
		UserDTO user = userservice.user_select3(u_id, u_nick, u_phone);
		if (user == null) {
			model.addAttribute("message", "등록된 회원이 아닙니다.");
			return "message";
		} else {
			model.addAttribute("message", "비밀번호는 " + user.getU_pw() + "입니다.");
			return "message2";
		}
	}

	@RequestMapping("/userlist")
	public String showList(Model model) {
		List<UserDTO> list = userservice.user_selectAll();
		model.addAttribute("userlist", list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user2", new A_subDTO());
		mv.setViewName("userlist");
		return "userlist";
	}

}