package com.doksusa.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	
	
	@RequestMapping(value="/noticelist.do", method=RequestMethod.GET)
	public String notice_list(Model model){
		List<CommunityDTO> list = cmservice.cm_selectBy(1);
		model.addAttribute("noticelist",list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("noticelist");
		return "community/noticelist";
	}
	
	
	//communityview.do
	@RequestMapping(value="/communityview.do", method=RequestMethod.GET)
	public String cm_detail(int c_num, Model model){
		CommunityDTO cdto = cmservice.cm_select(c_num);
		model.addAttribute("communitydto", cdto);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("communitydto");
		return "community/contentview";
	}
	
	//noticeinsert.do
	@RequestMapping(value="/noticeinsert.do", method=RequestMethod.GET)
	public String notice_insertGet(Model model){
		List<ForewordDTO> foreword = fservice.fore_selectAll();
		model.addAttribute("foreword",foreword);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("foreword");
		return "community/noticeinsert";
	}
	
	@RequestMapping(value="/noticeinsert.do", method=RequestMethod.POST)
	public String notice_insertPost(int u_num, String f_foreword, String c_title, String c_content, Model model){
		Date c_date = date();
		CommunityDTO cdto = new CommunityDTO(0, u_num, f_foreword, 1, c_title, c_content, c_date );
		int count = cmservice.cm_insert(cdto);
		cmservice.cm_insert(cdto);
		model.addAttribute("cdto", cdto);
		return "community/noticelist";
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
