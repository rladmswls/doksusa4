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
	public String cm_selectUnick(int u_num){
		return cm.cm_selectUnick(u_num);
	}
		
	@Override
	public int cm_insert(CommunityDTO cmdto) {
		return cm.cm_insert(cmdto);
	}

	@Override
	public int cm_update(CommunityDTO cmdto) {
		return cm.cm_update(cmdto);
	}

	@Override
	public int cm_delete(int c_num) {
		return cm.cm_delete(c_num);
	}

	@Override
	public List<CommunityDTO> cm_selectBy(int c_group) {
		return cm.cm_selectBy(c_group);
	}
	
	
	

	@Override
	public List<CommunityDTO> cm_searchTitleBy(String str) {
		return cm.cm_searchTitleBy(str);
	}

	@Override
	public List<CommunityDTO> cm_searchContentBy(String str) {
		return cm.cm_searchContentBy(str);
	}
	
	@Override
	public List<CommunityDTO> cm_searchForewordBy(String f_foreword) {
		return cm.cm_searchForewordBy(f_foreword);
	}

	@Override
	public List<CommunityDTO> unum_selectBy(int u_num) {
		return cm.unum_selectBy(u_num);
	}


	

}
