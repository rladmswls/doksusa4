package com.doksusa.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doksusa.community.CommunityService;

@Controller
public class CommunityController {
	
	@Autowired
	CommunityService cmservice;
	
	@RequestMapping("/notice.do")
	public String cm_list(){
		return "notice";
	}
	
	

}
