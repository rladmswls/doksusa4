package com.doksusa.comment;

import java.util.List;

public interface CommentDAO {

	public List<CommentDTO> ct_selectAll();

	public List<CommentDTO> ct_selectBy(int c_num);
	
	public int ct_delete(int ctu_num);
	
	
	public int ct_insert(CommentDTO codto);

	public int ct_update(CommentDTO codto);
	
	public CommentDTO ct_selectOne(int ct_num);
	
	
	public List<CommentDTO> ctu_selectBy(int ctu_num);
	
}
