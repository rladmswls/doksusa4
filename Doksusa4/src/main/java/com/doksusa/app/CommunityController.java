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
	
	
	//list 蹂닿린
	@RequestMapping(value="/communitylist.do", method=RequestMethod.GET )
	public String community_list(int c_group, Model model){
		List<CommunityDTO> list1 = cmservice.cm_selectBy(c_group);
		List<CommunityUserDTO> list2 = user_list(list1);
		
		List<ForewordDTO> foreword = foreword_list(c_group);
		model.addAttribute("foreword", foreword);
		
		Collections.sort(list2, new communitycomp());
		model.addAttribute("c_group", c_group);
		model.addAttribute("list", list2);
		
		return "community/communitylist";
	}
	
	
	
	
	
	
	
		// 寃뚯떆湲� �벐湲�
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
	
	
		//�뙎湲� 異붽�
		@RequestMapping(value = "/commentinsert.do", method = RequestMethod.POST)
		public String ct_insert(int c_num, int ctu_num, String ct_comment, Model model) {
			Date c_date = date();
			CommentDTO ctdto = new CommentDTO(0, c_num, ctu_num, ct_comment, c_date);
			ctservice.ct_insert(ctdto);

			model.addAttribute("c_num", c_num);
			return "redirect:/communityview.do";
		}

	//寃뚯떆湲� �뾽�뜲�씠�듃
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
	
	
	//�뙎湲� �뾽�뜲�씠�듃
	@RequestMapping(value = "/updateComment.do", method = RequestMethod.POST)
	public String ct_update(CommentDTO codto,Model model) {
		ctservice.ct_update(codto);
		model.addAttribute("c_num", codto.getC_num());
		return "redirect:/communityview.do";
	}

	
	//而ㅻ�ㅻ땲�떚 �궘�젣
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
			System.out.println(c_num + "===寃뚯떆湲� �궘�젣�셿猷�===");
			model.addAttribute("c_group",c_group);
			
			return "redirect:/communitylist.do";
		}
	
	//�뙎湲� �궘�젣
	@RequestMapping(value = "/deleteComment.do", method = RequestMethod.POST)
	public String ct_delete(int ct_num, int c_num, Model model) {
		ctservice.ct_delete(ct_num);
		System.out.println(ct_num + "===�뙎湲� �궘�젣�셿猷�===");
		model.addAttribute("c_num", c_num);
		return "redirect:/communityview.do";
	}
	
	
	
	
	
	// 而ㅻ�ㅻ땲�떚 寃뚯떆湲�蹂닿린
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
	
	
//====================================================================================================================================================================
		
		

		@RequestMapping(value = "/searchlist.do", method = RequestMethod.GET)
		public String search_list(int c_group,int search, String search_content, Model model) {
		
			List<CommunityDTO> list= new ArrayList<CommunityDTO>();
			List<CommunityUserDTO> list2 = new ArrayList<CommunityUserDTO>();
			List<CommunityUserDTO> list3 = new ArrayList<CommunityUserDTO>();
			List<ForewordDTO> list4  = foreword_list(c_group);
			
			model.addAttribute("c_group",c_group);
			model.addAttribute("foreword",list4);
			
			switch(search){
			case 1: 
				list = cmservice.cm_searchTitleBy(search_content);
				break;
			case 2:
				list = cmservice.cm_selectUserBy(search_content);
				break;
			case 3:
				list = cmservice.cm_searchContentBy(search_content);
				break;
			default:
				break;
			}
			
			
			list2 = user_list(list);
			if(search_content == null){
				return "redirect:communitylist.do";
			}else{
				for(CommunityUserDTO cudto : list2){
					if(cudto.getC_group()== c_group){
						list3.add(cudto);
					}
				}
				Collections.sort(list3, new communitycomp());
				model.addAttribute("list", list3);
				return "community/communitylist";
			}
		}

	
	
	
		@RequestMapping(value = "/searchforeword.do", method = RequestMethod.GET)
		public String search_foreword(int c_group, String f_foreword, Model model) {
			List<CommunityDTO> list = new ArrayList<CommunityDTO>();
			List<CommunityUserDTO> list2 = new ArrayList<CommunityUserDTO>();
			List<CommunityUserDTO> list3 = new ArrayList<CommunityUserDTO>();
			model.addAttribute("c_group",c_group);
			
			list = cmservice.cm_searchForewordBy(f_foreword);
			list2 = user_list(list);
			for(CommunityUserDTO cudto : list2){
				if(cudto.getC_group()== c_group){
					list3.add(cudto);
				}
			}
			
			List<ForewordDTO> flist = foreword_list(c_group);
			
			model.addAttribute("list", list3);
			model.addAttribute("foreword", flist);
			return "community/communitylist";
		}
	
	
	

		
		
//====================================================================================================================================================================
	
	public List<CommunityUserDTO> user_list(List<CommunityDTO> exlist){
		List<CommunityUserDTO> final_list = new ArrayList<CommunityUserDTO>();
		for(CommunityDTO cdto : exlist){
				String s = cmservice.cm_selectUnick(cdto.getU_num());
				CommunityUserDTO cudto = new CommunityUserDTO(cdto.getC_num(), cdto.getU_num(), cdto.getF_foreword(),
						cdto.getC_group(), cdto.getC_title(), cdto.getC_content(), cdto.getC_date(), s);
				final_list.add(cudto);
			}
		return final_list;
	}
		
	
	public List<ForewordDTO> foreword_list(int c_group){
		List<ForewordDTO> foreword;
		if(c_group!=1){
		foreword = fservice.fore_selectForUser();
		}else{
		foreword = fservice.fore_selectAll();
		}
		
		return foreword;
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
