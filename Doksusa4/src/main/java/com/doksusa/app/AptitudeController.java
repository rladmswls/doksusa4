package com.doksusa.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.a_sub.A_subService;
import com.doksusa.a_wrongnote.A_wrongMyNoteDTO;
import com.doksusa.a_wrongnote.A_wrongnoteDTO;
import com.doksusa.a_wrongnote.A_wrongnoteService;
import com.doksusa.aptitude.AptitudeDTO;
import com.doksusa.aptitude.AptitudeService;
import com.doksusa.e_wrongnote.E_wrongnoteDTO;
import com.doksusa.exam.ExamDTO;

class aptitudecomp implements Comparator<AptitudeDTO>{
	@Override
	public int compare(AptitudeDTO o1, AptitudeDTO o2) {
		return o2.getA_year()-o1.getA_year();
	}
}



@Controller
public class AptitudeController {

	@Autowired
	AptitudeService aptitudeservice;
	@Autowired
	A_wrongnoteService awservice;
	@Autowired
	A_subService asubservice;

	@RequestMapping(value = "/aschool.do", method = RequestMethod.GET)
	public String showSchoolList(String a_school, Model model) {
		List<AptitudeDTO> list = aptitudeservice.ap_selectByA_school(a_school);
		
		Collections.sort(list, new aptitudecomp());
		
		model.addAttribute("a_school", a_school);
		model.addAttribute("aschoollist", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aschoollist");
		return "aptitude/aschoollist";
	}

	@RequestMapping("/a_insert.do")
	public String insert() {
		return "aptitude/a_insert";
	}

	@RequestMapping(value = "/a_insert.do", method = RequestMethod.POST)
	public String a_insert(Model model, int a_year, String a_school, String a_title, String a_link, String a_answer) {
		AptitudeDTO aptitudedto = new AptitudeDTO(0, a_year, a_school, a_title, a_link, a_answer);
		aptitudeservice.ap_insert(aptitudedto);
		List<AptitudeDTO> list = aptitudeservice.ap_selectByA_school(a_school);
		model.addAttribute("aschoollist", list);
		return "aptitude/aschoollist";
	}

	@RequestMapping("/a_delete.do")
	public String ap_delete(int a_num, String a_school, Model model) {
		aptitudeservice.ap_delete(a_num);
		model.addAttribute("a_school", a_school);
		return "redirect:aschool.do";
	}

	@RequestMapping("/a_checkWrong.do")
	@ResponseBody
	public String checkWrong(int[] a_subnum, int a_num, HttpSession session) {
		for (int i : a_subnum) {
			System.out.println(i);
		}
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<A_wrongnoteDTO> a_u_list = awservice.aw_selectByU_num(u_num);
		for (A_wrongnoteDTO a_u_dto : a_u_list) {

			for (int i : a_subnum) {
				if (a_u_dto.getA_num() == a_num && a_u_dto.getA_subnum() == i)
					return "1";// 중복 존재
			}
		}
		return "0";

	}

	
	
	@RequestMapping("/au_wrongnote2.do")
	public String au_wrongnote2(String a_school, HttpSession session, Model model) {
		System.out.println(a_school+"0000000000000000000000000000000");
		int u_num = (Integer) session.getAttribute("u_num");
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);
		List<A_wrongMyNoteDTO> a_list = new ArrayList<A_wrongMyNoteDTO>();
		List<String> flist = new ArrayList<String>();
		for (A_wrongnoteDTO awdto : aw_list) {
			AptitudeDTO adto = aptitudeservice.ap_selectByAnum(awdto.getA_num());
			A_wrongMyNoteDTO aa = new A_wrongMyNoteDTO(awdto.getA_num(), awdto.getA_subnum(), u_num, adto.getA_link().substring(9, adto.getA_link().length() - 4));
			if(a_school.equals(adto.getA_link().substring(9, adto.getA_link().length() - 4)))a_list.add(aa);
			flist.add(aa.getA_link());
			System.out.println(aa.getA_link());
		}
		List<String> a_school_list = new ArrayList<String>(new HashSet<String>(flist));
		model.addAttribute("a_list", a_list);
		model.addAttribute("a_school_list",a_school_list);
		return "aptitude/au_wrongnote2";
	}
	
	
	@RequestMapping("/au_wrongnote.do")
	public String au_wrongnote(HttpSession session, Model model) {
		int u_num = (Integer) session.getAttribute("u_num");
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);
		List<A_wrongMyNoteDTO> a_list = new ArrayList<A_wrongMyNoteDTO>();
		List<String> flist = new ArrayList<String>();
		for (A_wrongnoteDTO awdto : aw_list) {
			AptitudeDTO adto = aptitudeservice.ap_selectByAnum(awdto.getA_num());
			String a_link = adto.getA_link().substring(9, adto.getA_link().length() - 4);
			System.out.println(a_link);
			A_wrongMyNoteDTO aa = new A_wrongMyNoteDTO(awdto.getA_num(), awdto.getA_subnum(), u_num, a_link);
			a_list.add(aa);
			flist.add(aa.getA_link());
		}
		List<String> a_school_list = new ArrayList<String>(new HashSet<String>(flist));
		model.addAttribute("a_list", a_list);
		model.addAttribute("a_school_list",a_school_list);
		return "aptitude/au_wrongnote";
	}

	@RequestMapping("/a_wrongnote.do")
	public String aomr(String a_school, Model model) {
		int end = 0;
		System.out.println("******************" + a_school);
		if (a_school.equals("고대세종")) {
			end = 40;
		} else if (a_school.equals("홍익대") || a_school.equals("수원대") || a_school.equals("을지대")) {
			end = 60;
		} else if (a_school.equals("한신대")) {
			end = 80;
		} else {
			end = 50;
		}
		model.addAttribute("end", end);
		return "aptitude/wrongnote";
	}

	@RequestMapping(value = "/a_wrongnote.do", method = RequestMethod.POST)
	public String wrongnote(int[] a_subnum, int a_num, Model model, int u_num) {

		AptitudeDTO adto = aptitudeservice.ap_selectByAnum(a_num);
		String a_link = adto.getA_link().substring(9, adto.getA_link().length() - 4);
		System.out.println(a_link);
		for (int i : a_subnum) {
			awservice.aw_insert(new A_wrongnoteDTO(a_num, i, u_num));
		}
		model.addAttribute("a_link", a_link);
		model.addAttribute("u_num", u_num);
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);
		List<A_wrongMyNoteDTO> a_list = new ArrayList<A_wrongMyNoteDTO>();
		for (A_wrongnoteDTO awdto : aw_list) {
			adto = aptitudeservice.ap_selectByAnum(awdto.getA_num());
			a_link = adto.getA_link().substring(9, adto.getA_link().length() - 4);
			a_list.add(new A_wrongMyNoteDTO(awdto.getA_num(), awdto.getA_subnum(), u_num, a_link));
		}
		model.addAttribute("a_list", a_list);

		return "aptitude/au_wrongnote";
	}

	@RequestMapping("/showA_wrong.do")
	public String showWrong(int a_num, int a_subnum, Model model) {
		String a_link = asubservice.searchLink(a_num, a_subnum);
		System.out.println(a_link);
		AptitudeDTO adto = aptitudeservice.ap_selectByAnum(a_num);
		String answer_link = adto.getA_answer().substring(0, adto.getA_answer().length() - 4);
		String show_link;
		if(a_subnum>9) show_link = a_link.substring(9,a_link.length() - 8);
		else show_link = a_link.substring(9,a_link.length() - 7);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("show_link", show_link);
		model.addAttribute("a_link", a_link);
		model.addAttribute("a_num", a_num);
		model.addAttribute("a_subnum", a_subnum);
		return "aptitude/showA_wrong";
	}

	@RequestMapping("/check_a_Before.do")
	@ResponseBody
	public String checkBefore(HttpSession session, int a_num, int a_subnum) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);

		A_wrongnoteDTO a_dto = aw_list.get(0);
		if (a_dto.getA_num() == a_num && a_dto.getA_subnum() == a_subnum) {
			return "1"; //첫 페이지!
		}

		return "0";
	}
	
	@RequestMapping("/check_a_Next.do")
	@ResponseBody
	public String checkNext(HttpSession session, int a_num, int a_subnum) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);

		A_wrongnoteDTO a_dto = aw_list.get(aw_list.size()-1);
		if (a_dto.getA_num() == a_num && a_dto.getA_subnum() == a_subnum) {
			return "1"; //마지막 페이지!
		}

		return "0";
	}
	
	
	@RequestMapping("/a_before.do")
	public String showBeforeWrong(int a_num, int a_subnum, Model model,HttpSession session){
		int u_num = (Integer)(session.getAttribute("u_num"));
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);
		for(int i=1;i<aw_list.size();i++){
			A_wrongnoteDTO a_dto = aw_list.get(i);
			if(a_dto.getA_num()==a_num && a_dto.getA_subnum()==a_subnum){
				i--;
				a_num = aw_list.get(i).getA_num();
				a_subnum = aw_list.get(i).getA_subnum();
				break;
			}
		}
		String a_link = asubservice.searchLink(a_num, a_subnum);
		AptitudeDTO adto = aptitudeservice.ap_selectByAnum(a_num);
		String answer_link = adto.getA_answer().substring(0,adto.getA_answer().length()-4);
		String show_link;
		if(a_subnum>9) show_link = a_link.substring(9,a_link.length() - 8);
		else show_link = a_link.substring(9,a_link.length() - 7);
		model.addAttribute("show_link", show_link);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("a_link", a_link);
		model.addAttribute("a_num", a_num);
		model.addAttribute("a_subnum", a_subnum);
		return "aptitude/showA_wrong";
	}

	@RequestMapping("/a_next.do")
	public String showNextWrong(int a_num, int a_subnum, Model model,HttpSession session){
		int u_num = (Integer)(session.getAttribute("u_num"));
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);
		for(int i=0;i<aw_list.size()-1;i++){
			A_wrongnoteDTO a_dto = aw_list.get(i);
			if(a_dto.getA_num()==a_num && a_dto.getA_subnum()==a_subnum){
				i++;
				a_num = aw_list.get(i).getA_num();
				a_subnum = aw_list.get(i).getA_subnum();
				break;
			}
		}
		String a_link = asubservice.searchLink(a_num, a_subnum);
		AptitudeDTO adto = aptitudeservice.ap_selectByAnum(a_num);
		String answer_link = adto.getA_answer().substring(0,adto.getA_answer().length()-4);
		String show_link;
		if(a_subnum>9) show_link = a_link.substring(9,a_link.length() - 8);
		else show_link = a_link.substring(9,a_link.length() - 7);
		model.addAttribute("show_link", show_link);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("a_link", a_link);
		model.addAttribute("a_num", a_num);
		model.addAttribute("a_subnum", a_subnum);
		return "aptitude/showA_wrong";
	}
	
	
	@RequestMapping("/showA_Answer.do")
	@ResponseBody
	public String showAnswer(int a_num, int a_subnum, Model model) {
		AptitudeDTO edto = aptitudeservice.ap_selectByAnum(a_num);
		String answer_link = edto.getA_answer().substring(0, edto.getA_answer().length() - 4);

		System.out.println(answer_link);
		System.out.println(a_subnum);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("a_num", a_num);
		model.addAttribute("a_subnum", a_subnum);
		return "1";
	}

	@RequestMapping("/a_deleteNote.do")
	public String noteDelete(int a_num, int a_subnum, Model model) {
		model.addAttribute("a_num", a_num);
		model.addAttribute("a_subnum", a_subnum);
		return "aptitude/deleteNote";
	}

	@RequestMapping(value = "/a_deleteNote.do", method = RequestMethod.POST)
	public String userDelete(int a_num, int a_subnum, String yesOrno, Model model, HttpSession session) {
		System.out.println(yesOrno);
		int u_num = (Integer) session.getAttribute("u_num");
		if (yesOrno.equals("예")) {
			awservice.aw_delete(new A_wrongnoteDTO(a_num, a_subnum, u_num));
		}
		List<A_wrongnoteDTO> aw_list = awservice.aw_selectByU_num(u_num);
		List<A_wrongMyNoteDTO> a_list = new ArrayList<A_wrongMyNoteDTO>();
		for (A_wrongnoteDTO awdto : aw_list) {
			AptitudeDTO adto = aptitudeservice.ap_selectByAnum(awdto.getA_num());
			String a_link = adto.getA_link().substring(9, adto.getA_link().length() - 4);
			a_list.add(new A_wrongMyNoteDTO(awdto.getA_num(), awdto.getA_subnum(), u_num, a_link));
		}
		model.addAttribute("a_list", a_list);
		return "redirect:au_wrongnote.do";
	}

}