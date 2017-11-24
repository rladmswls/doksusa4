package com.doksusa.aptitude;

import java.util.List;

public interface AptitudeService {

	public List<AptitudeDTO> ap_selectAll();
	
	public List<AptitudeDTO> ap_selectByA_school(String a_school);
	

	public AptitudeDTO ap_selectByAnum(int a_num);

	public int ap_insert(AptitudeDTO apdto);

	public int ap_update(AptitudeDTO apdto);

	public int ap_delete(int a_num);

}
