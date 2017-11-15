package com.doksusa.a_wrongnote;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("awdao")
public class A_wrongnoteDAOImpl implements A_wrongnoteDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.aw.";
	

}
