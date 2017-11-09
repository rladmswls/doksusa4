package com.doksusa.aptitude;

public class AptitudeDTO {
	   int a_num;
	   String a_school;
	   int a_year;
	   String a_subject;
	   int a_subnum;
	   int a_answer;
	   String a_link;
	   public AptitudeDTO() {
	      super();
	   }
	   public AptitudeDTO(int a_num, String a_school, int a_year, String a_subject, int a_subnum, int a_answer, String a_link) {
	      super();
	      this.a_num = a_num;
	      this.a_school = a_school;
	      this.a_year = a_year;
	      this.a_subject = a_subject;
	      this.a_subnum = a_subnum;
	      this.a_answer = a_answer;
	      this.a_link = a_link;
	   }
	   public int getA_num() {
	      return a_num;
	   }
	   public void setA_num(int a_num) {
	      this.a_num = a_num;
	   }
	   public String getA_school() {
	      return a_school;
	   }
	   public void setA_school(String a_school) {
	      this.a_school = a_school;
	   }
	   public int getA_year() {
	      return a_year;
	   }
	   public void setA_year(int a_year) {
	      this.a_year = a_year;
	   }
	   public String getA_subject() {
	      return a_subject;
	   }
	   public void setA_subject(String a_subject) {
	      this.a_subject = a_subject;
	   }
	   public int getA_subnum() {
	      return a_subnum;
	   }
	   public void setA_subnum(int a_subnum) {
	      this.a_subnum = a_subnum;
	   }
	   public int getA_answer() {
	      return a_answer;
	   }
	   public void setA_answer(int a_answer) {
	      this.a_answer = a_answer;
	   }
	   public String getA_link() {
	      return a_link;
	   }
	   public void setA_link(String a_link) {
	      this.a_link = a_link;
	   }
	   @Override
	   public String toString() {
	      return "AptitudeDTO [a_num=" + a_num + ", a_school=" + a_school + ", a_year=" + a_year + ", a_subject=" + a_subject
	            + ", a_subnum=" + a_subnum + ", a_answer=" + a_answer + ", a_link=" + a_link + "]";
	   }
}
