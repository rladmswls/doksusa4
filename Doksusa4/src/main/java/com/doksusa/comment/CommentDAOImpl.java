package com.doksusa.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("codao")
public class CommentDAOImpl implements CommentDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.ct.";
	
	@Override
	public List<CommentDTO> ct_selectAll() {
		return session.selectList(namespace + "ct_selectAll");
	}

	@Override
	public List<CommentDTO> ct_selectBy(int c_num) {
		return session.selectList(namespace + "ct_selectBy", c_num);
	}

	@Override
	public int ct_delete(int ctu_num) {
		return session.delete(namespace + "ct_delete", ctu_num);
	}

	@Override
	public int ct_insert(CommentDTO codto) {
		return session.insert(namespace + "ct_insert", codto);
	}

	@Override
	public int ct_update(CommentDTO codto) {
		return session.update(namespace + "ct_update", codto);
	}

	@Override
	public List<CommentDTO> ctu_selectBy(int ctu_num) {
		return session.selectList(namespace + "ctu_selectBy", ctu_num);
	}

	@Override
	public CommentDTO ct_selectOne(int ct_num) {
		return session.selectOne(namespace + "ct_selectOne", ct_num);
	}

	@Override
	public int ct_delete2(int ct_num) {
		return session.delete(namespace + "ct_delete2", ct_num);
	}

}
