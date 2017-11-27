package com.doksusa.e_sub;

import java.util.List;

public interface E_subService {

	public List<E_subDTO> esub_selectAll();
	public String searchLink(int e_num, int e_subnum);
	
}
