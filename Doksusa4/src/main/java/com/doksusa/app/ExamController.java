package com.doksusa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.exam.ExamDTO;
import com.doksusa.exam.ExamService;

@Controller
public class ExamController {

	@Autowired
	ExamService examservice;
	
	
	@RequestMapping(value="/esubject.do", method=RequestMethod.GET)
	public String showSubjectList(String e_subject, Model model){
		List<ExamDTO> list = examservice.exam_selectBySubject(e_subject);
		model.addAttribute("esubjectlist", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("esubjectlist");
		return "exam/esubjectlist";
	}
	
	@RequestMapping(value="/egrade.do", method=RequestMethod.GET)
	public String showGradeList(int e_grade, Model model){
		List<ExamDTO> list = examservice.exam_selectByGrade(e_grade);
		model.addAttribute("egradelist", list);
		model.addAttribute("e_grade", e_grade);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("egradelist");
		return "exam/egradelist";
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
		model.addAttribute("egradelist", list);
		return "exam/egradelist";
	}

	@RequestMapping("/e_delete.do")
	public String e_delete( int e_num,Model model){
		examservice.exam_delete(e_num);
		return "redirect:esubject.do";
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
