package com.doksusa.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cmService")
public class CommunityServiceImpl implements CommunityService{

	@Autowired
	CommunityDAO cm;
	
	public void setCm(CommunityDAO cm) {
		this.cm = cm;
	}

	@Override
	public List<CommunityDTO> cm_selectAll() {
		return cm.cm_selectAll();
	}

	@Override
	public CommunityDTO cm_select(int c_num) {
		return cm.cm_select(c_num);
	}

	@Override
	public int cm_insert(CommunityDTO cmdto) {
		return cm.cm_insert(cmdto);
	}

	@Override
	public int cm_update(int c_num, String c_group) {
		return cm.cm_update(c_num, c_group);
	}

	@Override
	public int cm_delete(int c_num, String c_group) {
		return cm.cm_delete(c_num, c_group);
	}

}
