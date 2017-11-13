package com.doksusa.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cmdao")
public class CommunityDAOImpl implements CommunityDAO{
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.cm.";

	@Override
	public List<CommunityDTO> cm_selectAll() {
		return session.selectList(namespace + "cm_selectAll");
	}

	@Override
	public CommunityDTO cm_select(int c_num) {
		return session.selectOne(namespace + "cm_select", c_num);
	}

	@Override
	public int cm_insert(CommunityDTO cmdto) {
		return session.insert(namespace + "cm_insert", cmdto);
	}

	@Override
	public int cm_update(int c_num) {
		return session.update(namespace + "cm_update", c_num);
	}

	@Override
	public int cm_delete(int c_num) {
		return session.delete(namespace + "cm_delete", c_num);
	}

}
