package com.doksusa.a_solution;

public class A_solutionDTO {
	
	int a_num;
	String a_sol;

	public A_solutionDTO() {
		super();
	}

	public A_solutionDTO(int a_num, String a_sol) {
		super();
		this.a_num = a_num;
		this.a_sol = a_sol;
	}

	public int getA_num() {
		return a_num;
	}

	public void setA_num(int a_num) {
		this.a_num = a_num;
	}

	public String getA_sol() {
		return a_sol;
	}

	public void setA_sol(String a_sol) {
		this.a_sol = a_sol;
	}

	@Override
	public String toString() {
		return "A_solutionDTO [a_num=" + a_num + ", a_sol=" + a_sol + "]";
	}
}
