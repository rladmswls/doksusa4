package com.doksusa.aptitude;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("apService")
public class AptitudeServiceImpl implements AptitudeService{

	@Autowired
	AptitudeDAO ap;
	
	public void setAp(AptitudeDAO ap) {
		this.ap = ap;
	}

	@Override
	public List<AptitudeDTO> ap_selectAll() {
		return ap.ap_selectAll();
	}

	@Override
	public List<AptitudeDTO> ap_selectByA_school(String a_school) {
		return ap.ap_selectByA_school(a_school);
	}
	
	

	@Override
	public AptitudeDTO ap_selectByAnum(int a_num) {
		return ap.ap_select(a_num);
	}

	@Override
	public int ap_insert(AptitudeDTO apdto) {
		return ap.ap_insert(apdto);
	}

	@Override
	public int ap_update(AptitudeDTO apdto) {
		return ap.ap_update(apdto);
	}

	@Override
	public int ap_delete(int a_num) {
		return ap.ap_delete(a_num);
	}

}
