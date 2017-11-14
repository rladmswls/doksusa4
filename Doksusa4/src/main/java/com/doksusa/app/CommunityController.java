package com.doksusa.app;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doksusa.community.CommunityDTO;
import com.doksusa.community.CommunityService;
import com.doksusa.content.ContentDTO;
import com.doksusa.content.ContentService;
import com.doksusa.foreword.ForewordDTO;
import com.doksusa.foreword.ForewordService;

@Controller
public class CommunityController {
	
	@Autowired
	CommunityService cmservice;
	@Autowired
	ForewordService fservice;
	@Autowired
	ContentService coservice;
	
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
	
	@RequestMapping(value="/cm_insert.do", method = RequestMethod.POST)
	public String cm_insert2(String foreword, String title, String c_content, Model model){
		CommunityDTO cmdto = new CommunityDTO(0, null, null, title, foreword, 0);
		cmservice.cm_insert(cmdto);
		ContentDTO codto = new ContentDTO(c_content, 0,  null);
		coservice.co_insert(codto);
		return "cm_insert";
	}
}
