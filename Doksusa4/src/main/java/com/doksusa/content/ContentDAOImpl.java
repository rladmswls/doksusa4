package com.doksusa.content;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("codao")
public class ContentDAOImpl implements ContentDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.co.";
	
	@Override
	public int co_insert(ContentDTO codto) {
		return session.insert(namespace + "co_insert", codto);
	}

	@Override
	public int co_update(int c_num) {
		return session.update(namespace + "co_update", c_num);
	}

	@Override
	public int co_delete(int c_num) {
		return session.delete(namespace + "co_delete", c_num);
	}

}
