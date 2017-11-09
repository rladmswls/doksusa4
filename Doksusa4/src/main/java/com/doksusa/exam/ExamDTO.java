package com.doksusa.exam;

public class ExamDTO {
	
	int e_num;
	int e_year;
	String e_subject;
	int e_subnum;
	int e_answer;
	String e_link;
	@Override
	public String toString() {
		return "ExamDTO [e_num=" + e_num + ", e_year=" + e_year + ", e_subject=" + e_subject + ", e_subnum=" + e_subnum
				+ ", e_answer=" + e_answer + ", e_link=" + e_link + "]";
	}
	public ExamDTO(int e_num, int e_year, String e_subject, int e_subnum, int e_answer, String e_link) {
		super();
		this.e_num = e_num;
		this.e_year = e_year;
		this.e_subject = e_subject;
		this.e_subnum = e_subnum;
		this.e_answer = e_answer;
		this.e_link = e_link;
	}
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public int getE_year() {
		return e_year;
	}
	public void setE_year(int e_year) {
		this.e_year = e_year;
	}
	public String getE_subject() {
		return e_subject;
	}
	public void setE_subject(String e_subject) {
		this.e_subject = e_subject;
	}
	public int getE_subnum() {
		return e_subnum;
	}
	public void setE_subnum(int e_subnum) {
		this.e_subnum = e_subnum;
	}
	public int getE_answer() {
		return e_answer;
	}
	public void setE_answer(int e_answer) {
		this.e_answer = e_answer;
	}
	public String getE_link() {
		return e_link;
	}
	public void setE_link(String e_link) {
		this.e_link = e_link;
	}
	
	
	

}
