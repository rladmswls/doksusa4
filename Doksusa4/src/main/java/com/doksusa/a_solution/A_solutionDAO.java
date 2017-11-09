package com.doksusa.a_solution;

public interface A_solutionDAO {
	
	public A_solutionDTO as_select(int a_num);
	
	public int as_insert(A_solutionDTO asdto);
	
	public int as_update(int a_num);
	
	public int as_delete(int a_num);

}
