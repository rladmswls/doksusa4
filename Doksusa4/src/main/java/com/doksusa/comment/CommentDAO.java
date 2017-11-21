package com.doksusa.comment;

import java.util.List;

import com.doksusa.community.CommunityDTO;

public interface CommentDAO {

	public List<CommentDTO> ct_selectAll();

	public List<CommunityDTO> ct_selectBy(int c_num);
	
}
