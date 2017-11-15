package com.doksusa.e_sub;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("esubdao")
public class E_subDAOImpl implements E_subDAO {

	@Autowired
	SqlSession session;

	String namespace = "com.doksusa.es.";
	
	@Override
	public List<E_subDTO> esub_selectAll() {
		return session.selectList(namespace + "esub_selectAll");
	}

}
