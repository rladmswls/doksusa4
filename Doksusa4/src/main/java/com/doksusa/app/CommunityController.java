package com.doksusa.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.comment.CommentDTO;
import com.doksusa.comment.CommentService;
import com.doksusa.comment.CommentUserDTO;
import com.doksusa.community.CommunityDTO;
import com.doksusa.community.CommunityService;
import com.doksusa.community.CommunityUserDTO;
import com.doksusa.foreword.ForewordDTO;
import com.doksusa.foreword.ForewordService;

class communitycomp implements Comparator<CommunityUserDTO>{
	@Override
	public int compare(CommunityUserDTO o1, CommunityUserDTO o2) {
		return o2.getC_num()-o1.getC_num(); 
	}
}

class commentcomp implements Comparator<CommentUserDTO>{

	@Override
	public int compare(CommentUserDTO o1, CommentUserDTO o2) {
		return o1.getCt_num() - o2.getCt_num();
	}
}


@Controller
public class CommunityController {

	@Autowired
	CommunityService cmservice;
	@Autowired
	ForewordService fservice;
	@Autowired
	CommentService ctservice;
	
	@RequestMapping(value = "/updateComment.do", method = RequestMethod.POST)
	public String ct_update(CommentDTO codto,Model model) {
		ctservice.ct_update(codto);
		model.addAttribute("c_num", codto.getC_num());
		return "redirect:/communityview.do";
	}

	@RequestMapping(value = "/deleteComment.do", method = RequestMethod.POST)
	public String ct_delete(int ct_num, int c_num, Model model) {
		ctservice.ct_delete(ct_num);
		System.out.println(ct_num + "===댓글 삭제완료===");
		model.addAttribute("c_num", c_num);
		return "redirect:/communityview.do";
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
		
		Collections.sort(unicklist, new communitycomp());
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
		Collections.sort(unicklist, new communitycomp());
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
		Collections.sort(unicklist, new communitycomp());
		model.addAttribute("u_nick_list", unicklist);
		model.addAttribute("c_group", 4);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("u_nick_list");
		mv.setViewName("c_group");

		return "community/relist";
	}

	
	
	
	//커뮤니티 삭제
	@RequestMapping(value = "/deleteCommunity.do", method = RequestMethod.GET)
	public String cm_delete(int c_num, int c_group, Model model) {
		System.out.println(c_num);
		System.out.println(c_group);
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();

		if (ctservice.ct_selectBy(c_num) != null) {
			ctlist = ctservice.ct_selectBy(c_num);
			for (CommentDTO ctdto : ctlist) {
				ctservice.ct_delete(ctdto.getCt_num());
			}			
		}
		cmservice.cm_delete(c_num);

		System.out.println(c_num + "===게시글 삭제완료===");

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

	@RequestMapping(value = "/updateCommunity.do", method = RequestMethod.GET)
	public String cm_update(int c_num, int c_group, Model model) {
		List<ForewordDTO> foreword = fservice.fore_selectForUser();
		model.addAttribute("foreword", foreword);
		CommunityDTO cdto = cmservice.cm_select(c_num);
		model.addAttribute("cdto", cdto);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("foreword");
		mv.setViewName("cdto");
		return "community/contentupdate";
	}

	@RequestMapping(value = "/updateCommunity.do", method = RequestMethod.POST)
	public String cm_updatePost(int c_num, int u_num, String f_foreword, int c_group, String c_title, String c_content,
			Date c_date, Model model) {
		CommunityDTO cdto = new CommunityDTO(c_num, u_num, f_foreword, c_group, c_title, c_content, c_date);
		cmservice.cm_update(cdto);

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

	//댓글 추가
	@RequestMapping(value = "/commentinsert.do", method = RequestMethod.POST)
	public String ct_insert(int c_num, int ctu_num, String ct_comment, Model model) {
		System.out.println(ctu_num+"==================================================================================");
		Date c_date = date();
		CommentDTO ctdto = new CommentDTO(0, c_num, ctu_num, ct_comment, c_date);
		ctservice.ct_insert(ctdto);

		model.addAttribute("c_num", c_num);
		return "redirect:/communityview.do";
	}

	
	// 커뮤니티 게시글보기
	@RequestMapping(value = "/communityview.do", method = RequestMethod.GET)
	public String cm_detail(int c_num, Model model) {
		CommunityDTO cdto = cmservice.cm_select(c_num);
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();
		List<CommentUserDTO> ctulist = new ArrayList<CommentUserDTO>();
		
		if (ctservice.ct_selectBy(c_num) != null) {
			ctlist= ctservice.ct_selectBy(c_num);
			for (CommentDTO codto : ctlist) {
				String ss = cmservice.cm_selectUnick(codto.getCtu_num());
				CommentUserDTO ctudto = new CommentUserDTO(codto.getCt_num(), codto.getC_num(), codto.getCtu_num(),
						codto.getCt_comment(), codto.getCt_date(), ss);
				ctulist.add(ctudto);
			}
			Collections.sort(ctulist,new commentcomp());
		}

		String s = cmservice.cm_selectUnick(cdto.getU_num());
		System.out.println(s);
		CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
				cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);

		
		model.addAttribute("communityuserdto", cudto);
		model.addAttribute("commentuserlist", ctulist);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("communitydto");
		mv.setViewName("commentuserlist");
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
