package com.doksusa.exam;

public class ExamDTO {
	
	int e_num;
	int e_year;
	String e_subject;
	int e_subnum;
	String e_answer;
	String e_link;
	String e_title;
	
	public ExamDTO() {
		super();
	}

	public ExamDTO(int e_num, int e_year, String e_subject, int e_subnum, String e_answer, String e_link,
			String e_title) {
		super();
		this.e_num = e_num;
		this.e_year = e_year;
		this.e_subject = e_subject;
		this.e_subnum = e_subnum;
		this.e_answer = e_answer;
		this.e_link = e_link;
		this.e_title = e_title;
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

	public String getE_answer() {
		return e_answer;
	}

	public void setE_answer(String e_answer) {
		this.e_answer = e_answer;
	}

	public String getE_link() {
		return e_link;
	}

	public void setE_link(String e_link) {
		this.e_link = e_link;
	}

	public String getE_title() {
		return e_title;
	}

	public void setE_title(String e_title) {
		this.e_title = e_title;
	}

	@Override
	public String toString() {
		return "ExamDTO [e_num=" + e_num + ", e_year=" + e_year + ", e_subject=" + e_subject + ", e_subnum=" + e_subnum
				+ ", e_answer=" + e_answer + ", e_link=" + e_link + ", e_title=" + e_title + "]";
	}
	
	
	
	
	
	
	
}