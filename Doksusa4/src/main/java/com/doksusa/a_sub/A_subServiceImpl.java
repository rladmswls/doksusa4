package com.doksusa.a_sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("asService")
public class A_subServiceImpl implements A_subService {

	@Autowired
	A_subDAO as;
	

	public void setAs(A_subDAO as) {
		this.as = as;
	}

	@Override
	public A_subDTO as_select(int a_num) {
		return as.as_select(a_num);
	}

	@Override
	public int as_insert(A_subDTO asdto) {
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
