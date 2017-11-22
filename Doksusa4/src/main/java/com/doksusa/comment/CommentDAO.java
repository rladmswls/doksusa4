package com.doksusa.comment;

import java.util.List;

public interface CommentDAO {

	public List<CommentDTO> ct_selectAll();

	public List<CommentDTO> ct_selectBy(int c_num);
	
	public int ct_delete(int ct_num);
	
	
	public int ct_insert(CommentDTO codto);

	public int ct_update(int ct_num);

	
}
