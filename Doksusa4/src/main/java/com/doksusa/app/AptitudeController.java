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