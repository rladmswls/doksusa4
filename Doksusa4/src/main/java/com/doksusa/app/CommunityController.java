package com.doksusa.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.comment.CommentDTO;
import com.doksusa.comment.CommentService;
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
	@Autowired
	CommentService ctservice;

	// noticelist 보기
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

	// notice insert
	@RequestMapping(value = "/noticeinsert.do", method = RequestMethod.GET)
	public String notice_insertGet(Model model) {
		List<ForewordDTO> foreword = fservice.fore_selectAll();
		model.addAttribute("foreword", foreword);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("foreword");
		return "community/noticeinsert";
	}

	// notice insert
	@RequestMapping(value = "/noticeinsert.do", method = RequestMethod.POST)
	public String notice_insertPost(int u_num, String f_foreword, String c_title, String c_content, Model model) {
		Date c_date = date();
		CommunityDTO cdto = new CommunityDTO(0, u_num, f_foreword, 1, c_title, c_content, c_date);
		cmservice.cm_insert(cdto);
		model.addAttribute("cdto", cdto);

		return "redirect:/noticelist.do";

	}

	// 고1고2 커뮤니티 보기
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

	// 고3 커뮤니티보기
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
		model.addAttribute("c_group", 3);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");
		mv.setViewName("c_group");

		return "community/threelist";
	}

	// n수생 커뮤니티보기
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
		model.addAttribute("c_group", 4);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");
		mv.setViewName("c_group");

		return "community/relist";
	}

	@RequestMapping(value = "/deleteCommunity.do", method = RequestMethod.GET)
	public String cm_delete(int c_num, int c_group, Model model) {
		System.out.println(c_num);
		System.out.println(c_group);
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();
		ctlist = ctservice.ct_selectBy(c_num);
		
		if(ctlist.isEmpty()){
			System.out.println();
			System.out.println("=================================");
		}
		
		
		if (!ctlist.isEmpty()) {
			for (CommentDTO ctdto : ctlist) {
				ctservice.ct_delete(ctdto.getCt_num());
			}
		}
		
		cmservice.cm_delete(c_num);

		System.out.println("게시글 삭제완료");

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

	// 커뮤니티 게시글보기
	@RequestMapping(value = "/communityview.do", method = RequestMethod.GET)
	public String cm_detail(int c_num, Model model) {
		CommunityDTO cdto = cmservice.cm_select(c_num);
		String s = cmservice.cm_selectUnick(cdto.getU_num());
		System.out.println(s);
		CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
				cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);

		model.addAttribute("communityuserdto", cudto);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("communitydto");
		return "community/contentview";
	}

	// 게시글 쓰기
	@RequestMapping(value = "/communityinsert.do", method = RequestMethod.GET)
	public String communityinsert(int c_group, Model model) {
		List<ForewordDTO> foreword = fservice.fore_selectForUser();
		model.addAttribute("foreword", foreword);
		model.addAttribute("c_group", c_group);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("foreword");
		mv.setViewName("c_group");

		return "community/communityinsert";
	}

	// 게시글 쓰기
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
