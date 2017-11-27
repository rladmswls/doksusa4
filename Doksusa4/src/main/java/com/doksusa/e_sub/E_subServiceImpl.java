package com.doksusa.e_sub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("esubService")
public class E_subServiceImpl implements E_subService{

	
	@Autowired
	E_subDAO esub;
	
	public void setE_sub(E_subDAO esub) {
		this.esub = esub;
	}
	
	@Override
	public List<E_subDTO> esub_selectAll() {
		return esub.esub_selectAll();
	}

	@Override
	public String searchLink(int e_num, int e_subnum) {
		return esub.searchLink(e_num, e_subnum);
	}

}
