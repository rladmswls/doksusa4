package com.doksusa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doksusa.aptitude.AptitudeDTO;
import com.doksusa.aptitude.AptitudeService;

@Controller
public class AptitudeController {

	@Autowired
	AptitudeService aptitudeservice;
	
	
	@RequestMapping(value="/aschool.do", method=RequestMethod.GET)
	public String showSchoolList(String a_school, Model model){
		List<AptitudeDTO> list = aptitudeservice.ap_selectByA_school(a_school);
		model.addAttribute("aschoollist", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aschoollist");
		return "aptitude/aschoollist";
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
