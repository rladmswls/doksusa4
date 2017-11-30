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

import com.doksusa.e_sub.E_subService;
import com.doksusa.e_wrongnote.E_wrongMyNoteDTO;
import com.doksusa.e_wrongnote.E_wrongnoteDTO;
import com.doksusa.e_wrongnote.E_wrongnoteService;
import com.doksusa.exam.ExamDTO;
import com.doksusa.exam.ExamService;

class examcomp implements Comparator<ExamDTO>{
	@Override
	public int compare(ExamDTO o1, ExamDTO o2) {
		if( o2.getE_year()==o1.getE_year())
			return o2.getE_grade()-o1.getE_grade();
		else
			return o2.getE_year()-o1.getE_year();
	}
}

@Controller
public class ExamController {

	@Autowired
	ExamService examservice;
	@Autowired
	E_wrongnoteService ewservice;
	@Autowired
	E_subService esubservice;
	
	@RequestMapping(value = "/esubject.do", method = RequestMethod.GET)
	public String showSubjectList(String e_subject, Model model) {
		System.out.println(e_subject);
		List<ExamDTO> list = examservice.exam_selectBySubject(e_subject);
		Collections.sort(list, new examcomp());
		model.addAttribute("e_subject", e_subject);
		model.addAttribute("esubjectlist", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("esubjectlist");
		mv.setViewName("e_subject");
		return "exam/esubjectlist";
	}

	@RequestMapping(value = "/egrade.do", method = RequestMethod.GET)
	public String showGradeList(String e_subject, Integer e_grade, Model model) {
		List<ExamDTO> list = examservice.exam_selectBySubject(e_subject);
		List<ExamDTO> elist = new ArrayList<ExamDTO>();
		if (e_grade == null) {
			for (ExamDTO edto : list) {
				elist.add(edto);
			}
		} else {
			for (ExamDTO edto : list) {
				if (e_grade == edto.getE_grade()) {
					elist.add(edto);
				}
			}
		}
		Collections.sort(elist,new examcomp());
		// List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("egradelist", elist);
		model.addAttribute("e_subject", e_subject);
		model.addAttribute("e_grade", e_grade);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("egradelist");
		if (e_grade == null) {
			return "redirect:esubject.do";
		} else {
			return "exam/egradelist";
		}
	}

	@RequestMapping("/e_checkWrong.do")
	@ResponseBody
	public String checkWrong(int[] e_subnum, int e_num, HttpSession session) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<E_wrongnoteDTO> e_u_list = ewservice.ew_selectByU_num(u_num);
		for (E_wrongnoteDTO e_u_dto : e_u_list) {

			for (int i : e_subnum) {
				if (e_u_dto.getE_num() == e_num && e_u_dto.getE_subnum() == i)
					return "1";// 중복 존재
			}
		}
		return "0";
	}

	@RequestMapping("/eu_wrongnote.do")
	public String u_wrongnote(HttpSession session, Model model) {
		int u_num = (Integer) session.getAttribute("u_num");
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);
		List<E_wrongMyNoteDTO> e_list = new ArrayList<E_wrongMyNoteDTO>();
		List<String> flist = new ArrayList<String>();
		for (E_wrongnoteDTO ewdto : ew_list) {
			ExamDTO edto = examservice.exam_selectByEnum(ewdto.getE_num());
			String e_link = edto.getE_link().substring(6, edto.getE_link().length() - 4);
			E_wrongMyNoteDTO dd = new E_wrongMyNoteDTO(ewdto.getE_num(), ewdto.getE_subnum(), u_num, e_link);
			e_list.add(dd);
			flist.add(dd.getE_link());
			
		}
		List<String> e_subject_list = new ArrayList<String>(new HashSet<String>(flist));
		model.addAttribute("e_list", e_list);
		model.addAttribute("e_subject_list", e_subject_list);
		return "exam/eu_wrongnote";
	}

	@RequestMapping("/e_wrongnote.do")
	public String omr(String e_subject, Model model, String e_num) {
		int end = 0;

		if (e_subject.equals("언어") || e_subject.equals("외국어")) {
			end = 45;
		} else if (e_subject.equals("수리-가형") || e_subject.equals("수리-나형")) {
			end = 30;
		} else {
			end = 20;
		}
		model.addAttribute("end", end);
		model.addAttribute("e_num", e_num);
		return "exam/wrongnote";
	}

	@RequestMapping(value = "/e_wrongnote.do", method = RequestMethod.POST)
	public String wrongnote(int[] e_subnum, int e_num, Model model, HttpSession session) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		ExamDTO edto = examservice.exam_selectByEnum(e_num);
		String e_link = edto.getE_link().substring(6, edto.getE_link().length() - 4);
		System.out.println(e_link);
		for (int i : e_subnum) {
			ewservice.ew_insert(new E_wrongnoteDTO(e_num, i, u_num));
		}
		model.addAttribute("e_link", e_link);
		model.addAttribute("u_num", u_num);
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);
		List<E_wrongMyNoteDTO> e_list = new ArrayList<E_wrongMyNoteDTO>();
		for (E_wrongnoteDTO ewdto : ew_list) {
			edto = examservice.exam_selectByEnum(ewdto.getE_num());
			e_link = edto.getE_link().substring(6, edto.getE_link().length() - 4);
			e_list.add(new E_wrongMyNoteDTO(ewdto.getE_num(), ewdto.getE_subnum(), u_num, e_link));
		}
		model.addAttribute("e_list", e_list);

		return "exam/eu_wrongnote";
	}

	@RequestMapping("/showE_wrong.do")
	public String showWrong(int e_num, int e_subnum, Model model) {
		String e_link = esubservice.searchLink(e_num, e_subnum);
		ExamDTO edto = examservice.exam_selectByEnum(e_num);
		String answer_link = edto.getE_answer().substring(0, edto.getE_answer().length() - 4);
		String show_link;
		if(e_subnum>9) show_link = e_link.substring(6,e_link.length() - 7);
		else show_link = e_link.substring(6,e_link.length() - 6);
		model.addAttribute("show_link", show_link);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("e_link", e_link);
		model.addAttribute("e_num", e_num);
		model.addAttribute("e_subnum", e_subnum);
		return "exam/showE_wrong";
	}

	@RequestMapping("/check_e_Before.do")
	@ResponseBody
	public String checkBefore(HttpSession session, int e_num, int e_subnum) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);

		E_wrongnoteDTO e_dto = ew_list.get(0);
		if (e_dto.getE_num() == e_num && e_dto.getE_subnum() == e_subnum) {
			return "1"; //첫 페이지!
		}

		return "0";
	}
	
	@RequestMapping("/check_e_Next.do")
	@ResponseBody
	public String checkNext(HttpSession session, int e_num, int e_subnum) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);

		E_wrongnoteDTO e_dto = ew_list.get(ew_list.size()-1);
		if (e_dto.getE_num() == e_num && e_dto.getE_subnum() == e_subnum) {
			return "1"; //마지막 페이지!
		}

		return "0";
	}

	@RequestMapping("/e_before.do")
	public String showBeforeWrong(int e_num, int e_subnum, Model model, HttpSession session) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);
		for (int i = 1; i < ew_list.size(); i++) {
			E_wrongnoteDTO e_dto = ew_list.get(i);
			if (e_dto.getE_num() == e_num && e_dto.getE_subnum() == e_subnum) {
				i--;
				e_num = ew_list.get(i).getE_num();
				e_subnum = ew_list.get(i).getE_subnum();
				break;
			}
		}
		String e_link = esubservice.searchLink(e_num, e_subnum);
		ExamDTO edto = examservice.exam_selectByEnum(e_num);
		String answer_link = edto.getE_answer().substring(0, edto.getE_answer().length() - 4);
		String show_link;
		if(e_subnum>9) show_link = e_link.substring(6,e_link.length() - 7);
		else show_link = e_link.substring(6,e_link.length() - 6);
		model.addAttribute("show_link", show_link);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("e_link", e_link);
		model.addAttribute("e_num", e_num);
		model.addAttribute("e_subnum", e_subnum);
		return "exam/showE_wrong";
	}

	@RequestMapping("/e_next.do")
	public String showNextWrong(int e_num, int e_subnum, Model model, HttpSession session) {
		int u_num = (Integer) (session.getAttribute("u_num"));
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);
		for (int i = 0; i < ew_list.size() - 1; i++) {
			E_wrongnoteDTO e_dto = ew_list.get(i);
			if (e_dto.getE_num() == e_num && e_dto.getE_subnum() == e_subnum) {
				i++;
				e_num = ew_list.get(i).getE_num();
				e_subnum = ew_list.get(i).getE_subnum();
				break;
			}
		}
		String e_link = esubservice.searchLink(e_num, e_subnum);
		ExamDTO edto = examservice.exam_selectByEnum(e_num);
		String answer_link = edto.getE_answer().substring(0, edto.getE_answer().length() - 4);
		String show_link;
		if(e_subnum>9) show_link = e_link.substring(6,e_link.length() - 7);
		else show_link = e_link.substring(6,e_link.length() - 6);
		model.addAttribute("show_link", show_link);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("e_link", e_link);
		model.addAttribute("e_num", e_num);
		model.addAttribute("e_subnum", e_subnum);
		return "exam/showE_wrong";
	}

	@RequestMapping("/showE_Answer.do")
	@ResponseBody
	public String showAnswer(int e_num, int e_subnum, Model model) {
		ExamDTO edto = examservice.exam_selectByEnum(e_num);
		String answer_link = edto.getE_answer().substring(0, edto.getE_answer().length() - 4);

		System.out.println(answer_link);
		System.out.println(e_subnum);
		model.addAttribute("answer_link", answer_link);
		model.addAttribute("e_num", e_num);
		model.addAttribute("e_subnum", e_subnum);
		return "1";
	}

	@RequestMapping("/e_deleteNote.do")
	public String noteDelete(int e_num, int e_subnum, Model model) {
		model.addAttribute("e_num", e_num);
		model.addAttribute("e_subnum", e_subnum);
		return "exam/deleteNote";
	}

	@RequestMapping(value = "/e_deleteNote.do", method = RequestMethod.POST)
	public String userDelete(int e_num, int e_subnum, String yesOrno, Model model, HttpSession session) {
		System.out.println(yesOrno);
		int u_num = (Integer) session.getAttribute("u_num");
		if (yesOrno.equals("예")) {
			ewservice.ew_delete(new E_wrongnoteDTO(e_num, e_subnum, u_num));
		}
		List<E_wrongnoteDTO> ew_list = ewservice.ew_selectByU_num(u_num);
		List<E_wrongMyNoteDTO> e_list = new ArrayList<E_wrongMyNoteDTO>();
		for (E_wrongnoteDTO ewdto : ew_list) {
			ExamDTO edto = examservice.exam_selectByEnum(ewdto.getE_num());
			String e_link = edto.getE_link().substring(6, edto.getE_link().length() - 4);
			e_list.add(new E_wrongMyNoteDTO(ewdto.getE_num(), ewdto.getE_subnum(), u_num, e_link));
		}
		model.addAttribute("e_list", e_list);
		return "redirect:eu_wrongnote.do";
	}

	@RequestMapping("/e_insert.do")
	public String insert() {
		return "exam/e_insert";
	}

	@RequestMapping(value = "/e_insert.do", method = RequestMethod.POST)
	public String e_insert(Model model, int e_year, int e_grade, String e_subject, String e_link, String e_answer,
			String e_solution) {
		System.out.println(e_year);
		ExamDTO examdto = new ExamDTO(0, e_year, e_grade, e_subject, e_link, e_answer, e_solution);
		examservice.exam_insert(examdto);
		List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("e_subject", e_subject);
		model.addAttribute("e_grade", e_grade);
		model.addAttribute("egradelist", list);
		return "redirect:eu_wrongnote.do";
	}

	@RequestMapping("/e_delete.do")
	public String e_delete(int e_num, String e_subject, Model model) {
		examservice.exam_delete(e_num);
		model.addAttribute("e_subject", e_subject);
		return "redirect:esubject.do";
	}

	@RequestMapping("/e_delete2.do")
	public String e_delete2(String e_subject, int e_num, int e_grade, Model model) {
		examservice.exam_delete(e_num);
		List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("e_subject", e_subject);
		model.addAttribute("e_grade", e_grade);
		model.addAttribute("egradelist", list);
		return "redirect:egrade.do";
	}

	// @RequestMapping("/examlist")
	// public String showList(Model model) {
	// List<ExamDTO> list = examservice.exam_selectAll();
	// model.addAttribute("examlist", list);
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("examlist");
	// return "examlist";
	// }

	// @RequestMapping("/examview.do")
	// public String showExam(int e_num, Model model){
	// ExamDTO dto = examservice.exam_selectByEnum(e_num);
	// model.addAttribute("examdto", dto);
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("examdto");
	// return "examdetail";
	// }

}
