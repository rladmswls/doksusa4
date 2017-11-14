package com.doksusa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doksusa.community.CommunityService;
import com.doksusa.foreword.ForewordDTO;
import com.doksusa.foreword.ForewordService;

@Controller
public class CommunityController {
	
	@Autowired
	CommunityService cmservice;
	@Autowired
	ForewordService fservice;
	
	@RequestMapping("/notice.do")
	public String cm_list(){
		return "notice";
	}
	
	@RequestMapping("/cm_insert.do")
	public String cm_insert(Model model){
		List<ForewordDTO> foreword = fservice.fore_selectAll();
		model.addAttribute("foreword", foreword);
		return "cm_insert";
	}
	

}
