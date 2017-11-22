package com.doksusa.e_wrongnote;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ewdao")
public class E_wrongnoteDAOImpl implements E_wrongnoteDAO {

	@Autowired
	SqlSession session;

	String namespace = "com.doksusa.ew.";

	@Override
	public List<E_wrongnoteDTO> ew_selectByU_num(int u_num) {
		return session.selectList(namespace + "ew_selectByU_num", u_num);
	}

	@Override
	public List<E_wrongnoteDTO> ew_selectByE_num(int e_num) {
		return session.selectList(namespace + "ew_selectByE_num", e_num);
	}

	@Override
	public int ew_insert(E_wrongnoteDTO ewdto) {
		return session.insert(namespace + "ew_insert", ewdto);
	}

	@Override
	public int ew_delete(E_wrongnoteDTO ewdto) {
		return session.delete(namespace + "ew_delete", ewdto);
	}

}
