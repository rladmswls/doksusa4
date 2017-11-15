package com.doksusa.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.community.CommunityDTO;
import com.doksusa.community.CommunityService;
import com.doksusa.foreword.ForewordDTO;
import com.doksusa.foreword.ForewordService;

@Controller
public class CommunityController {
	
	@Autowired
	CommunityService cmservice;
	@Autowired
	ForewordService fservice;
	
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String cm_list(int c_group, Model model){
		List<CommunityDTO> noticelist = cmservice.cm_selectBy(c_group);
		model.addAttribute("noticelist", noticelist);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("noticelist");
		return "notice";
	}
	
	
	@RequestMapping(value="/cm_insert1.do", method=RequestMethod.GET)
	public String cm_insert(int c_group, Model model){
		
		model.addAttribute("foreword", foreword);
		model.addAttribute("c_group", c_group);
		return "cm_insert";
	}
	
	
	
	
	
	
	
	
/*	@RequestMapping(value="/cm_insert.do", method=RequestMethod.GET)
	public String cm_insert(int c_group, Model model){
		List<ForewordDTO> foreword = fservice.fore_selectAll();
		model.addAttribute("foreword", foreword);
		model.addAttribute("c_group", c_group);
		return "cm_insert";
	}*/
	
	@RequestMapping(value="/cm_insert.do", method = RequestMethod.POST)
	public String cm_insert2(int u_num, String f_foreword,int c_group, String c_title, String c_content, Model model){
		Date c_date = date();
		CommunityDTO cmdto = new CommunityDTO(0, u_num, f_foreword, c_group, c_title, c_content, c_date);
		cmservice.cm_insert(cmdto);
		model.addAttribute("cmdto", cmdto);
		return "notice";
	}
	
	public Date date(){
		Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH)+1;
	    int day = calendar.get(Calendar.DAY_OF_MONTH);
	    int hour = calendar.get(Calendar.HOUR);
	    int minute = calendar.get(Calendar.MINUTE);
	    int second = calendar.get(Calendar.SECOND);
	    
	    String str = year + "-" + month + "-" + day +"/" + hour + ":" + minute + ":" + second;
	     
	     Date sysdate = stringToDate(str);
	     return sysdate;
	}
	
	public static java.sql.Date stringToDate(String sdate) {
		java.sql.Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");

		java.util.Date d2;
		try {
			d2 = sdf.parse(sdate);
			d = convertDate(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static java.sql.Date convertDate(java.util.Date d) {
		Date d2 = new Date(d.getTime());
		return d2;
	}
}
