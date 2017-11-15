package com.doksusa.a_sub;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("asdao")
public class A_subDAOImpl implements A_subDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.as.";
	
	@Override
	public A_subDTO as_select(int a_num) {
		return session.selectOne(namespace + "as_select", a_num);
	}

	@Override
	public int as_insert(A_subDTO asdto) {
		return session.insert(namespace + "as_insert", asdto);
	}

	@Override
	public int as_update(int a_num) {
		return session.update(namespace + "as_update", a_num);
	}

	@Override
	public int as_delete(int a_num) {
		return session.delete(namespace + "as_delete", a_num);
	}

}
