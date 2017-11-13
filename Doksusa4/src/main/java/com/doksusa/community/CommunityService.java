package com.doksusa.community;

import java.util.List;

public interface CommunityService {

	public List<CommunityDTO> cm_selectAll();

	public CommunityDTO cm_select(int c_num);

	public int cm_insert(CommunityDTO cmdto);

	public int cm_update(int c_num, String c_group);

	public int cm_delete(int c_num, String c_group);

}
