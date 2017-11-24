package com.doksusa.app;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.e_wrongnote.E_wrongMyNoteDTO;
import com.doksusa.e_wrongnote.E_wrongnoteDTO;
import com.doksusa.e_wrongnote.E_wrongnoteService;
import com.doksusa.exam.ExamDTO;
import com.doksusa.exam.ExamService;

@Controller
public class ExamController {

	@Autowired
	ExamService examservice;
	@Autowired
	E_wrongnoteService ewservice;
	List<E_wrongMyNoteDTO> ewlist = new ArrayList<E_wrongMyNoteDTO>();
	
	@RequestMapping(value="/esubject.do", method=RequestMethod.GET)
	public String showSubjectList(String e_subject,Model model){
		List<ExamDTO> list = examservice.exam_selectBySubject(e_subject);
		model.addAttribute("e_subject",e_subject);
		model.addAttribute("esubjectlist", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("esubjectlist");
		mv.setViewName("e_subject");
		return "exam/esubjectlist";
	}
	
	@RequestMapping(value="/egrade.do", method=RequestMethod.GET)
	public String showGradeList(String e_subject,int e_grade, Model model){
		System.out.println(e_grade);
		List<ExamDTO> list = examservice.exam_selectBySubject(e_subject);
		List<ExamDTO> elist = new ArrayList<ExamDTO>();
		for(ExamDTO edto : list){
			if(e_grade == edto.getE_grade()){
				elist.add(edto);
			}
		}
		//List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("egradelist", elist);
		model.addAttribute("e_subject",e_subject);
		model.addAttribute("e_grade", e_grade);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("egradelist");
		return "exam/egradelist";
	}

	@RequestMapping("/u_wrongnote.do")
	public String u_wrongnote() {
		return "exam/u_wrongnote";
	}
	
	@RequestMapping("/wrongnote.do")
	public String omr(String e_subject, Model model,String e_num){
		int end=0;
		
		if(e_subject.equals("언어") || e_subject.equals("외국어")){
			end = 45;
		}else if(e_subject.equals("수리-가형") || e_subject.equals("수리-나형")){
			end = 30;
		}else{
			end = 20;
		}
		model.addAttribute("end", end);
		model.addAttribute("e_num",e_num);
		return "exam/wrongnote";
	}
	
	@RequestMapping(value="/wrongnote.do", method=RequestMethod.POST)
	public String wrongnote(int[] e_subnum, int e_num,Model model,int u_num){
		
		ExamDTO edto = examservice.exam_selectByEnum(e_num);
		String e_link = edto.getE_link().substring(6,edto.getE_link().length()-4);
		for(int i:e_subnum){
			ewservice.ew_insert(new E_wrongnoteDTO(e_num, i, u_num));
		}
		model.addAttribute("e_link", e_link);
		model.addAttribute("u_num",u_num);
		List<E_wrongnoteDTO> e_list = ewservice.ew_selectByU_num(u_num);
		model.addAttribute("e_list",e_list);
		
		return "exam/u_wrongnote";
	}
	
	@RequestMapping("/showE_wrong.do")
	public String showWrong(E_wrongMyNoteDTO e_dto, Model model){
		model.addAttribute("e_dto",e_dto);
		System.out.println(e_dto);
		return "exam/showE_wrong";
	}
	
	
	@RequestMapping("/e_insert.do")
	public String insert(){
		return "exam/e_insert";
	}
	
	@RequestMapping(value="/e_insert.do", method=RequestMethod.POST)
	public String e_insert(Model model,int e_year, int e_grade, String e_subject, String e_link, String e_answer, String e_solution){
		ExamDTO examdto = new ExamDTO(0, e_year, e_grade, e_subject, e_link, e_answer, e_solution);
		examservice.exam_insert(examdto);
		List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("e_subject",e_subject);
		model.addAttribute("e_grade",e_grade);
		model.addAttribute("egradelist", list);
		return "exam/egradelist";
	}

	@RequestMapping("/e_delete.do")
	public String e_delete(int e_num, String e_subject, Model model){
		System.out.println(e_subject);
		examservice.exam_delete(e_num);
		List<ExamDTO> list = examservice.exam_selectBySubject(e_subject);
		model.addAttribute("e_subject",e_subject);
		model.addAttribute("esubjectlist", list);
		return "exam/esubjectlist";
	}
	
	@RequestMapping("/e_delete2.do")
	public String e_delete2(String e_subject,int e_num, int e_grade, Model model){
		examservice.exam_delete(e_num);
		List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("e_subject",e_subject);
		model.addAttribute("e_grade",e_grade);
		model.addAttribute("egradelist", list);
		return "exam/egradelist";
	}
	
	
	
	
	
//	@RequestMapping("/examlist")
//	public String showList(Model model) {
//		List<ExamDTO> list = examservice.exam_selectAll();
//		model.addAttribute("examlist", list);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("examlist");
//		return "examlist";
//	}
	
	
	
	
	
	
	
//	@RequestMapping("/examview.do")
//	public String showExam(int e_num, Model model){
//		ExamDTO dto = examservice.exam_selectByEnum(e_num);
//		model.addAttribute("examdto", dto);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("examdto");
//		return "examdetail";
//	}
	

}
