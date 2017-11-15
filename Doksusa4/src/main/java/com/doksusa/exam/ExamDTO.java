package com.doksusa.exam;

public class ExamDTO {

	int e_num;
	int e_year;
	int e_grade;
	String e_subject;
	String e_link;
	String e_answer;
	String e_solution;

	public ExamDTO() {
		super();
	}

	public ExamDTO(int e_num, int e_year, int e_grade, String e_subject, String e_link, String e_answer,
			String e_solution) {
		super();
		this.e_num = e_num;
		this.e_year = e_year;
		this.e_grade = e_grade;
		this.e_subject = e_subject;
		this.e_link = e_link;
		this.e_answer = e_answer;
		this.e_solution = e_solution;
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

	public int getE_grade() {
		return e_grade;
	}

	public void setE_grade(int e_grade) {
		this.e_grade = e_grade;
	}

	public String getE_subject() {
		return e_subject;
	}

	public void setE_subject(String e_subject) {
		this.e_subject = e_subject;
	}

	public String getE_link() {
		return e_link;
	}

	public void setE_link(String e_link) {
		this.e_link = e_link;
	}

	public String getE_answer() {
		return e_answer;
	}

	public void setE_answer(String e_answer) {
		this.e_answer = e_answer;
	}

	public String getE_solution() {
		return e_solution;
	}

	public void setE_solution(String e_solution) {
		this.e_solution = e_solution;
	}

	@Override
	public String toString() {
		return "ExamDTO [e_num=" + e_num + ", e_year=" + e_year + ", e_grade=" + e_grade + ", e_subject=" + e_subject
				+ ", e_link=" + e_link + ", e_answer=" + e_answer + ", e_solution=" + e_solution + "]";
	}

}