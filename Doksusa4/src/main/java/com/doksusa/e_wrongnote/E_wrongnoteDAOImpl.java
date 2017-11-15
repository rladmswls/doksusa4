package com.doksusa.e_wrongnote;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ewdao")
public class E_wrongnoteDAOImpl implements E_wrongnoteDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.ew.";
	

}
