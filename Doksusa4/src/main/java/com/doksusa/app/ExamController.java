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
