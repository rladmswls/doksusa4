package com.doksusa.a_wrongnote;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("awdao")
public class A_wrongnoteDAOImpl implements A_wrongnoteDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.aw.";

	@Override
	public List<A_wrongnoteDTO> aw_selectByU_num(int u_num) {
		return session.selectList(namespace+"aw_selectByU_num", u_num);
	}

	@Override
	public List<A_wrongnoteDTO> aw_selectByE_num(int e_num) {
		return session.selectList(namespace+"aw_selectByE_num", e_num);
	}

	@Override
	public int aw_insert(A_wrongnoteDTO awdto) {
		return session.insert(namespace+"aw_insert", awdto);
	}

	@Override
	public int aw_delete(A_wrongnoteDTO awdto) {
		return session.delete(namespace+"aw_delete", awdto);
	}
	
	

}
