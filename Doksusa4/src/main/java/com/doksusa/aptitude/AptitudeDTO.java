package com.doksusa.aptitude;

public class AptitudeDTO {
	int a_num;
	int a_year;
	String a_school;
	String a_title;
	String a_link;
	String a_answer;

	public AptitudeDTO() {
		super();
	}

	public AptitudeDTO(int a_num, int a_year, String a_school, String a_title, String a_link, String a_answer) {
		super();
		this.a_num = a_num;
		this.a_year = a_year;
		this.a_school = a_school;
		this.a_title = a_title;
		this.a_link = a_link;
		this.a_answer = a_answer;
	}

	public int getA_num() {
		return a_num;
	}

	public void setA_num(int a_num) {
		this.a_num = a_num;
	}

	public int getA_year() {
		return a_year;
	}

	public void setA_year(int a_year) {
		this.a_year = a_year;
	}

	public String getA_school() {
		return a_school;
	}

	public void setA_school(String a_school) {
		this.a_school = a_school;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getA_link() {
		return a_link;
	}

	public void setA_link(String a_link) {
		this.a_link = a_link;
	}

	public String getA_answer() {
		return a_answer;
	}

	public void setA_answer(String a_answer) {
		this.a_answer = a_answer;
	}

	@Override
	public String toString() {
		return "AptitudeDTO [a_num=" + a_num + ", a_year=" + a_year + ", a_school=" + a_school + ", a_title=" + a_title
				+ ", a_link=" + a_link + ", a_answer=" + a_answer + "]";
	}

}
