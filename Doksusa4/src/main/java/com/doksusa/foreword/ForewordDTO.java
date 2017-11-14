package com.doksusa.foreword;

public class ForewordDTO {

	String f_foreword;

	public ForewordDTO() {
		super();
	}

	public ForewordDTO(String f_foreword) {
		super();
		this.f_foreword = f_foreword;
	}

	public String getF_foreword() {
		return f_foreword;
	}

	public void setF_foreword(String f_foreword) {
		this.f_foreword = f_foreword;
	}

	@Override
	public String toString() {
		return "ForewordDTO [f_foreword=" + f_foreword + "]";
	}


}
