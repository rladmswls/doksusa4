package com.doksusa.aptitude;

import java.util.List;

public interface AptitudeDAO {
	
	public List<AptitudeDTO> ap_selectAll();
	
	public AptitudeDTO ap_select(int a_num);
	
	public int ap_insert(AptitudeDTO apdto);
	
	public int ap_update(AptitudeDTO apdto);
	
	public int ap_delete(int a_num);

}
