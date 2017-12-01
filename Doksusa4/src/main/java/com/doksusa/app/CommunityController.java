package com.doksusa.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doksusa.comment.CommentDTO;
import com.doksusa.comment.CommentService;
import com.doksusa.comment.CommentUserDTO;
import com.doksusa.community.CommunityDTO;
import com.doksusa.community.CommunityService;
import com.doksusa.community.CommunityUserDTO;
import com.doksusa.e_wrongnote.E_wrongnoteDTO;
import com.doksusa.exam.ExamDTO;
import com.doksusa.foreword.ForewordDTO;
import com.doksusa.foreword.ForewordService;
import com.doksusa.user.UserDTO;
import com.doksusa.user.UserService;

//게시글 sorting을 위한 comparator class
class communitycomp implements Comparator<CommunityUserDTO> {
	@Override
	public int compare(CommunityUserDTO o1, CommunityUserDTO o2) {
		return o2.getC_num() - o1.getC_num();
	}
}

class commentcomp implements Comparator<CommentUserDTO> {
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
	@Autowired
	UserService userservice;

	// 게시글 목록 보여주는 method
	@RequestMapping(value = "/communitylist.do", method = RequestMethod.GET)
	public String community_list(int c_group, Model model) {
		List<CommunityDTO> list1 = cmservice.cm_selectBy(c_group);
		List<CommunityUserDTO> list2 = user_list(list1);
		List<ForewordDTO> foreword = foreword_list(c_group);
		model.addAttribute("foreword", foreword);
		Collections.sort(list2, new communitycomp());
		model.addAttribute("c_group", c_group);
		model.addAttribute("list", list2);

		return "community/communitylist";
	}

	// 게시글 작성을 위한 method
	@RequestMapping(value = "/communityinsert.do", method = RequestMethod.GET)
	public String communityinsert(int c_group, Model model) {
		List<ForewordDTO> foreword = foreword_list(c_group);
		model.addAttribute("foreword", foreword);
		model.addAttribute("c_group", c_group);
		return "community/communityinsert";
	}

	@RequestMapping(value = "/communityinsert.do", method = RequestMethod.POST)
	public String communityinsertPost(int u_num, String f_foreword, int c_group, String c_title, String c_content,
			Model model) {
		List<ForewordDTO> foreword = foreword_list(c_group);
		model.addAttribute("foreword", foreword);
		Date c_date = date();
		CommunityDTO cdto = new CommunityDTO(0, u_num, f_foreword, c_group, c_title, c_content, c_date);
		cmservice.cm_insert(cdto);
		model.addAttribute("cdto", cdto);
		model.addAttribute("c_group", c_group);

		return "redirect:/communitylist.do";
	}

	// 댓글 작성을 위한 method
	@RequestMapping(value = "/commentinsert.do", method = RequestMethod.POST)
	public String ct_insert(int c_num, int ctu_num, String ct_comment, Model model) {
		Date c_date = date();
		CommentDTO ctdto = new CommentDTO(0, c_num, ctu_num, ct_comment, c_date);
		ctservice.ct_insert(ctdto);

		model.addAttribute("c_num", c_num);
		return "redirect:/communityview.do";
	}

	// 게시글 수정을 위한 method
	@RequestMapping(value = "/updateCommunity.do", method = RequestMethod.GET)
	public String cm_update(int c_num, int c_group, Model model) {
		List<ForewordDTO> foreword = foreword_list(c_group);
		model.addAttribute("foreword", foreword);
		CommunityDTO cdto = cmservice.cm_select(c_num);
		model.addAttribute("cdto", cdto);

		return "community/contentupdate";
	}

	@RequestMapping(value = "/updateCommunity.do", method = RequestMethod.POST)
	public String cm_updatePost(int c_num, int u_num, String f_foreword, int c_group, String c_title, String c_content,
			Date c_date, Model model) {
		CommunityDTO cdto = new CommunityDTO(c_num, u_num, f_foreword, c_group, c_title, c_content, c_date);
		cmservice.cm_update(cdto);
		model.addAttribute("c_num", c_num);
		return "redirect:/communityview.do";
	}

	// 댓글 수정을 위한 method
	@RequestMapping(value = "/updateComment.do", method = RequestMethod.GET)
	public String ct_update(String ct_comment, int ct_num2, Model model) {
		System.out.println(ct_comment);
		System.out.println("ct_num===========================================================" + ct_num2);

		CommentDTO codto = ctservice.ct_selectOne(ct_num2);
		CommentDTO codto2 = new CommentDTO(ct_num2, codto.getC_num(), codto.getCtu_num(), ct_comment,
				codto.getCt_date());
		ctservice.ct_update(codto2);
		model.addAttribute("c_num", codto.getC_num());
		return "redirect:/communityview.do";
	}

	// 게시글 삭제를 위한 method
	@RequestMapping(value = "/deleteCommunity.do", method = RequestMethod.GET)
	public String cm_delete(int c_num, int c_group, Model model) {
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();
		ctlist = ctservice.ct_selectBy(c_num);
		if (ctlist != null) {
			for (CommentDTO ctdto : ctlist) {
				ctservice.ct_delete2(ctdto.getCt_num());
			}
		}
		cmservice.cm_delete(c_num);
		model.addAttribute("c_group", c_group);
		return "redirect:/communitylist.do";
	}

	// 댓글 삭제를 위한 method
	@RequestMapping(value = "/deleteComment.do", method = RequestMethod.GET)
	public String ct_delete(int ct_num3, Model model) {
		CommentDTO codto = ctservice.ct_selectOne(ct_num3);
		ctservice.ct_delete2(ct_num3);

		model.addAttribute("c_num", codto.getC_num());
		return "redirect:/communityview.do";
	}

	// 게시글 상세보기를 위한 method
	@RequestMapping(value = "/communityview.do", method = RequestMethod.GET)
	public String cm_detail(int c_num, Model model) {
		CommunityDTO cdto = cmservice.cm_select(c_num);
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();
		List<CommentUserDTO> ctulist = new ArrayList<CommentUserDTO>();

		if (ctservice.ct_selectBy(c_num) != null) {
			ctlist = ctservice.ct_selectBy(c_num);
			for (CommentDTO codto : ctlist) {
				String ss = cmservice.cm_selectUnick(codto.getCtu_num());
				CommentUserDTO ctudto = new CommentUserDTO(codto.getCt_num(), codto.getC_num(), codto.getCtu_num(),
						codto.getCt_comment(), codto.getCt_date(), ss);
				ctulist.add(ctudto);
			}
			Collections.sort(ctulist, new commentcomp());
		}
		String s = cmservice.cm_selectUnick(cdto.getU_num());
		int num = ctservice.ct_selectBy(cdto.getC_num()).size();
		CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
				cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s, num);
		model.addAttribute("communityuserdto", cudto);
		model.addAttribute("commentuserlist", ctulist);

		return "community/contentview";
	}

	// 게시글 검색을 위한 method
	@RequestMapping(value = "/searchlist.do", method = RequestMethod.GET)
	public String search_list(int c_group, Integer search, String search_content, Model model) {
		List<CommunityDTO> list = new ArrayList<CommunityDTO>();
		List<CommunityDTO> list6 = new ArrayList<CommunityDTO>();
		List<CommunityUserDTO> list2 = new ArrayList<CommunityUserDTO>();
		List<CommunityUserDTO> list3 = new ArrayList<CommunityUserDTO>();
		List<ForewordDTO> list4 = foreword_list(c_group);
		List<UserDTO> list5 = new ArrayList<UserDTO>();
		switch (search) {
		case 1:
			list = cmservice.cm_searchTitleBy(search_content);
			break;
		case 2:
			list5 = userservice.user_search(search_content);
			for (UserDTO udto : list5) {
				list6 = cmservice.unum_selectBy(udto.getU_num());
				for (CommunityDTO cdto : list6) {
					list.add(cdto);
				}
			}
			break;
		case 3:
			list = cmservice.cm_searchContentBy(search_content);
			break;
		default:
			return "redirect:communitylist.do";
		}

		list2 = user_list(list);
		if (search_content == null) {
			return "redirect:communitylist.do";
		} else {
			for (CommunityUserDTO cudto : list2) {
				if (cudto.getC_group() == c_group) {
					list3.add(cudto);
				}
			}
			Collections.sort(list3, new communitycomp());
			model.addAttribute("c_group", c_group);
			model.addAttribute("foreword", list4);
			model.addAttribute("list", list3);
			return "community/communitylist";
		}
	}

	@RequestMapping("/check_c_Before.do")
	@ResponseBody
	public String checkBefore(HttpSession session, HttpServletRequest request) {
		String c_num = request.getParameter("c_num");
		String c_group = request.getParameter("c_group");
		int c_num2 = Integer.parseInt(c_num);
		int c_group2 = Integer.parseInt(c_group);

		List<CommunityUserDTO> clist = user_list(cmservice.cm_selectBy(c_group2));
		CommunityUserDTO cdto = clist.get(0);

		if (cdto.getC_num() == c_num2) {
			return "1"; // 첫 페이지!
		}
		return "0";
	}

	@RequestMapping("/check_c_Next.do")
	@ResponseBody
	public String checkNext(HttpSession session, HttpServletRequest request) {

		String c_num = request.getParameter("c_num");
		String c_group = request.getParameter("c_group");
		int c_num2 = Integer.parseInt(c_num);
		int c_group2 = Integer.parseInt(c_group);
		List<CommunityUserDTO> clist = user_list(cmservice.cm_selectBy(c_group2));
		CommunityUserDTO cdto = clist.get(clist.size() - 1);

		if (cdto.getC_num() == c_num2) {
			return "1"; // 첫 페이지!
		}
		return "0";
	}

	@RequestMapping("/c_before.do")
	public String showBeforeWrong(int c_num2, int c_group, Model model, HttpSession session) {

		List<CommunityUserDTO> clist = user_list(cmservice.cm_selectBy(c_group));
		Collections.sort(clist, new communitycomp());

		for (int i = 1; i < clist.size(); i++) {
			CommunityUserDTO cdto = clist.get(i);
			if (cdto.getC_num() == c_num2) {
				i--;
				c_num2 = clist.get(i).getC_num();
				break;
			}
		}

		CommunityDTO cdto = cmservice.cm_select(c_num2);
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();
		List<CommentUserDTO> ctulist = new ArrayList<CommentUserDTO>();

		if (ctservice.ct_selectBy(c_num2) != null) {
			ctlist = ctservice.ct_selectBy(c_num2);
			for (CommentDTO codto : ctlist) {
				String ss = cmservice.cm_selectUnick(codto.getCtu_num());
				CommentUserDTO ctudto = new CommentUserDTO(codto.getCt_num(), codto.getC_num(), codto.getCtu_num(),
						codto.getCt_comment(), codto.getCt_date(), ss);
				ctulist.add(ctudto);
			}
			Collections.sort(ctulist, new commentcomp());
		}
		String s = cmservice.cm_selectUnick(cdto.getU_num());
		int num = ctservice.ct_selectBy(cdto.getC_num()).size();
		CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
				cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s, num);
		model.addAttribute("communityuserdto", cudto);
		model.addAttribute("commentuserlist", ctulist);

		return "community/contentview";

	}

	@RequestMapping("/c_next.do")
	public String showNextWrong(int c_num2, int c_group, Model model, HttpSession session) {
		List<CommunityUserDTO> clist = user_list(cmservice.cm_selectBy(c_group));
		Collections.sort(clist, new communitycomp());

		for (int i = 1; i < clist.size(); i++) {
			CommunityUserDTO cdto = clist.get(i);
			if (cdto.getC_num() == c_num2) {
				i++;
				c_num2 = clist.get(i).getC_num();
				break;
			}
		}

		CommunityDTO cdto = cmservice.cm_select(c_num2);
		List<CommentDTO> ctlist = new ArrayList<CommentDTO>();
		List<CommentUserDTO> ctulist = new ArrayList<CommentUserDTO>();

		if (ctservice.ct_selectBy(c_num2) != null) {
			ctlist = ctservice.ct_selectBy(c_num2);
			for (CommentDTO codto : ctlist) {
				String ss = cmservice.cm_selectUnick(codto.getCtu_num());
				CommentUserDTO ctudto = new CommentUserDTO(codto.getCt_num(), codto.getC_num(), codto.getCtu_num(),
						codto.getCt_comment(), codto.getCt_date(), ss);
				ctulist.add(ctudto);
			}
			Collections.sort(ctulist, new commentcomp());
		}
		String s = cmservice.cm_selectUnick(cdto.getU_num());
		int num = ctservice.ct_selectBy(cdto.getC_num()).size();
		CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
				cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s, num);
		model.addAttribute("communityuserdto", cudto);
		model.addAttribute("commentuserlist", ctulist);

		return "community/contentview";

	}

	// 말머리 검색을 위한 method
	@RequestMapping(value = "/searchforeword.do", method = RequestMethod.GET)
	public String search_foreword(int c_group, String f_foreword, Model model) {
		List<CommunityDTO> list = new ArrayList<CommunityDTO>();
		List<CommunityUserDTO> list2 = new ArrayList<CommunityUserDTO>();
		List<CommunityUserDTO> list3 = new ArrayList<CommunityUserDTO>();
		list = cmservice.cm_searchForewordBy(f_foreword);
		list2 = user_list(list);
		for (CommunityUserDTO cudto : list2) {
			if (cudto.getC_group() == c_group) {
				list3.add(cudto);
			}
		}
		List<ForewordDTO> flist = foreword_list(c_group);
		model.addAttribute("c_group", c_group);
		model.addAttribute("list", list3);
		model.addAttribute("foreword", flist);
		return "community/communitylist";
	}

	// CommunityDTO list 를 사용자 닉네임을 포함한 CommunityUserDTO 로 변환하기 위한 함수
	public List<CommunityUserDTO> user_list(List<CommunityDTO> exlist) {
		List<CommunityUserDTO> final_list = new ArrayList<CommunityUserDTO>();
		for (CommunityDTO cdto : exlist) {
			String s = cmservice.cm_selectUnick(cdto.getU_num());
			int num = ctservice.ct_selectBy(cdto.getC_num()).size();
			CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
					cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s, num);
			final_list.add(cudto);
		}
		return final_list;
	}

	// c_group에 따라 사용 가능한 말머리를 찾게 해주는 함수
	public List<ForewordDTO> foreword_list(int c_group) {
		List<ForewordDTO> foreword;
		if (c_group != 1) {
			foreword = fservice.fore_selectForUser();
		} else {
			foreword = fservice.fore_selectAll();
		}

		return foreword;
	}

	// System time을 가져와서 sql time으로 바꾸기 위한 함수
	public Date date() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		String str = year + "-" + month + "-" + day;

		Date sysdate = stringToDate(str);
		return sysdate;
	}

	public static java.sql.Date stringToDate(String sdate) {
		java.sql.Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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