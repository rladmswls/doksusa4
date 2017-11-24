package com.doksusa.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("coService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO ct;
	
	public void setCm(CommentDAO ct) {
		this.ct = ct;
	}
	
	@Override
	public List<CommentDTO> ct_selectAll() {
		return ct.ct_selectAll();
	}

	@Override
	public List<CommentDTO> ct_selectBy(int c_num) {
		return ct.ct_selectBy(c_num);
	}

	@Override
	public int ct_delete(int ct_num) {
		return ct.ct_delete(ct_num);
	}

	@Override
	public int ct_insert(CommentDTO codto) {
		return ct.ct_insert(codto);
	}

	@Override
	public int ct_update(CommentDTO codto) {
		return ct.ct_update(codto);
	}


	
	
}
