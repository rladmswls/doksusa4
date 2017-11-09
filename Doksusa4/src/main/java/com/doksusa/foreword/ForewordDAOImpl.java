package com.doksusa.foreword;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("foredao")
public class ForewordDAOImpl implements ForewordDAO{

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.fore.";
	
	@Override
	public List<ForewordDTO> fore_selectAll() {
		return session.selectList(namespace + "fore_selectAll");
	}

	@Override
	public ForewordDTO fore_select(String foreword) {
		return session.selectOne(namespace + "fore_select", foreword);
	}

	@Override
	public int fore_insert(ForewordDTO foredto) {
		return session.insert(namespace + "fore_insert",foredto);
	}

	@Override
	public int fore_update(ForewordDTO foredto) {
		return session.update(namespace + "fore_update", foredto);
	}

	@Override
	public int fore_delete(String foreword) {
		return session.delete(namespace + "fore_delete", foreword);
	}

}
