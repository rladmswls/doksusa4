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
import com.doksusa.exam.ExamDTO;

@Controller
public class AptitudeController {

   @Autowired
   AptitudeService aptitudeservice;
   
   
   @RequestMapping(value="/aschool.do", method=RequestMethod.GET)
   public String showSchoolList(String a_school, Model model){
      List<AptitudeDTO> list = aptitudeservice.ap_selectByA_school(a_school);
      model.addAttribute("a_school", a_school);
      model.addAttribute("aschoollist", list);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("aschoollist");
      return "aptitude/aschoollist";
   }

   @RequestMapping("/a_insert.do")
   public String insert(){
      return "aptitude/a_insert";
   }
   
   @RequestMapping(value="/a_insert.do", method=RequestMethod.POST)
   public String a_insert(Model model,int a_year, String a_school, String a_title, String a_link, String a_answer){
      AptitudeDTO aptitudedto = new AptitudeDTO(0, a_year, a_school, a_title, a_link, a_answer);
      aptitudeservice.ap_insert(aptitudedto);
      List<AptitudeDTO> list = aptitudeservice.ap_selectByA_school(a_school);
      model.addAttribute("aschoollist", list);
      return "aptitude/aptitudelist";
   }
   
   @RequestMapping("/a_delete.do")
   public String ap_delete(int a_num, String a_school, Model model){
	   aptitudeservice.ap_delete(a_num);
	   List<AptitudeDTO> list = aptitudeservice.ap_selectByA_school(a_school);
	   model.addAttribute("aschoollist", list);
	   return "aptitude/aschoollist";
   }
   
   @RequestMapping("/au_wrongnote.do")
   public String au_wrongnote(){
	   return "aptitude/au_wrongnote";
   }
   
   @RequestMapping("/a_wrongnote.do")
   public String aomr(String a_school, Model model){
	   int as_end=0;
	   
	   if(a_school.equals("고려대")){
		   as_end = 40;
	   }else if(a_school.equals("홍익대")|| a_school.equals("수원대")|| a_school.equals("을지대")){
		   as_end = 60;
	   }else if(a_school.equals("한신대")){
		   as_end = 80;
	   }else{
		   as_end = 50;
	   }
	   model.addAttribute("as_end", as_end);
	   return "aptitude/a_wrongnote";
   }
   
   @RequestMapping(value="/a_wrongnote.do", method=RequestMethod.POST)
   public String wrongnote(int[] asu){
	   for(int i : asu){
		   
	   }
	   return "aptitude/au_wrongnote";
	   
   }
   
   
//   @RequestMapping("/examlist")
//   public String showList(Model model) {
//      List<ExamDTO> list = examservice.exam_selectAll();
//      model.addAttribute("examlist", list);
//      ModelAndView mv = new ModelAndView();
//      mv.setViewName("examlist");
//      return "examlist";
//   }
   
   
   
   
   
   
   
//   @RequestMapping("/examview.do")
//   public String showExam(int e_num, Model model){
//      ExamDTO dto = examservice.exam_selectByEnum(e_num);
//      model.addAttribute("examdto", dto);
//      ModelAndView mv = new ModelAndView();
//      mv.setViewName("examdto");
//      return "examdetail";
//   }
   

}