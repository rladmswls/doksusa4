package com.doksusa.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.community.CommunityDTO;
import com.doksusa.community.CommunityService;
import com.doksusa.community.CommunityUserDTO;
import com.doksusa.foreword.ForewordDTO;
import com.doksusa.foreword.ForewordService;

@Controller
public class CommunityController {

	@Autowired
	CommunityService cmservice;
	@Autowired
	ForewordService fservice;

	@RequestMapping(value = "/noticelist.do", method = RequestMethod.GET)
	public String notice_list(Model model) {
		List<CommunityDTO> list = cmservice.cm_selectBy(1);
		List<CommunityUserDTO> unicklist = new ArrayList<CommunityUserDTO>();
		for (CommunityDTO cdto : list) {
			String s = cmservice.cm_selectUnick(cdto.getU_num());
			System.out.println(s);
			CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
					cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);
			unicklist.add(cudto);
		}
		model.addAttribute("u_nick_list", unicklist);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");

		return "community/noticelist";
	}

	@RequestMapping(value = "/communityview.do", method = RequestMethod.GET)
	public String cm_detail(int c_num, Model model) {
		CommunityDTO cdto = cmservice.cm_select(c_num);
		model.addAttribute("communitydto", cdto);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("communitydto");
		return "community/contentview";
	}

	@RequestMapping(value = "/noticeinsert.do", method = RequestMethod.GET)
	public String notice_insertGet(Model model) {
		List<ForewordDTO> foreword = fservice.fore_selectAll();
		model.addAttribute("foreword", foreword);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("foreword");
		return "community/noticeinsert";
	}

	@RequestMapping(value = "/noticeinsert.do", method = RequestMethod.POST)
	public String notice_insertPost(int u_num, String f_foreword, String c_title, String c_content, Model model) {
		Date c_date = date();
		CommunityDTO cdto = new CommunityDTO(0, u_num, f_foreword, 1, c_title, c_content, c_date);
		cmservice.cm_insert(cdto);
		model.addAttribute("cdto", cdto);
	
		
		return "redirect:/noticelist.do";
		
		
	}

	
	
	
	
	
	
	
	@RequestMapping(value = "/onetwolist.do", method = RequestMethod.GET)
	public String onetwo_list(Model model) {
		List<CommunityDTO> list = cmservice.cm_selectBy(2);
		List<CommunityUserDTO> unicklist = new ArrayList<CommunityUserDTO>();
		for (CommunityDTO cdto : list) {
			String s = cmservice.cm_selectUnick(cdto.getU_num());
			System.out.println(s);
			CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
					cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);
			unicklist.add(cudto);
		}
		model.addAttribute("u_nick_list", unicklist);
		model.addAttribute("c_group", 2);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");
		mv.setViewName("c_group");
		
		return "community/onetwolist";
	}

	@RequestMapping(value = "/threelist.do", method = RequestMethod.GET)
	public String three_list(Model model) {
		List<CommunityDTO> list = cmservice.cm_selectBy(3);
		List<CommunityUserDTO> unicklist = new ArrayList<CommunityUserDTO>();
		for (CommunityDTO cdto : list) {
			String s = cmservice.cm_selectUnick(cdto.getU_num());
			System.out.println(s);
			CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
					cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);
			unicklist.add(cudto);
		}
		model.addAttribute("u_nick_list", unicklist);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");
		return "community/threelist";
	}

	@RequestMapping(value = "/relist.do", method = RequestMethod.GET)
	public String re_list(Model model) {
		List<CommunityDTO> list = cmservice.cm_selectBy(4);
		List<CommunityUserDTO> unicklist = new ArrayList<CommunityUserDTO>();
		for (CommunityDTO cdto : list) {
			String s = cmservice.cm_selectUnick(cdto.getU_num());
			System.out.println(s);
			CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
					cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);
			unicklist.add(cudto);
		}
		model.addAttribute("u_nick_list", unicklist);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");
		return "community/relist";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/communityinsert.do", method = RequestMethod.GET)
	public String communityinsert(int c_group, Model model) {
		List<ForewordDTO> foreword = fservice.fore_selectForUser();
		model.addAttribute("foreword", foreword);
		model.addAttribute("c_group", foreword);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("foreword");
		mv.setViewName("c_group");

		return "community/communityinsert";
	}

	
	
	
	
	
	
	
	@RequestMapping(value = "/communityinsert.do", method = RequestMethod.POST)
	public String communityinsertPost(int u_num, String f_foreword, int c_group, String c_title, String c_content,
			Model model) {
		Date c_date = date();
		CommunityDTO cdto = new CommunityDTO(0, u_num, f_foreword, c_group, c_title, c_content, c_date);
		cmservice.cm_insert(cdto);
		model.addAttribute("cdto", cdto);
		switch (c_group) {
		case 2:
			return "redirect:/onetwolist.do";
		case 3:
			return "redirect:/threelist.do";
		case 4:
			return "redirect:/relist.do";
		default:
			return "redirect:/onetwolist.do";
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Date date() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		String str = year + "-" + month + "-" + day + "/" + hour + ":" + minute + ":" + second;

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
