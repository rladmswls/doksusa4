package com.doksusa.a_solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("asService")
public class A_solutionServiceImpl implements A_solutionService {

	@Autowired
	A_solutionDAO as;
	

	public void setAs(A_solutionDAO as) {
		this.as = as;
	}

	@Override
	public A_solutionDTO as_select(int a_num) {
		return as.as_select(a_num);
	}

	@Override
	public int as_insert(A_solutionDTO asdto) {
		return as.as_insert(asdto);
	}

	@Override
	public int as_update(int a_num) {
		return as.as_update(a_num);
	}

	@Override
	public int as_delete(int a_num) {
		return as.as_delete(a_num);
	}

}
