package com.doksusa.community;

import java.util.List;

public interface CommunityDAO {

	public List<CommunityDTO> cm_selectAll();

	public List<CommunityDTO> cm_selectBy(int c_group);
	
	public String cm_selectUnick(int u_num);
	
	public CommunityDTO cm_select(int c_num);

	public int cm_insert(CommunityDTO cmdto);

	public int cm_update(CommunityDTO cmdto);

	public int cm_delete(int c_num);
	
	
	
	public List<CommunityDTO> cm_searchTitleBy(String str);
	
	public List<CommunityDTO> cm_searchContentBy(String str);
	
	
	public List<CommunityDTO> cm_searchForewordBy(String f_foreword);
	
	
	
	
	
	public List<CommunityDTO> unum_selectBy(int u_num);
	
	
	
	
	
	

}
