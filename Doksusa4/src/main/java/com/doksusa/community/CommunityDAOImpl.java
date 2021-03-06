package com.doksusa.community;

import java.util.List;

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
	public int cm_update(CommunityDTO cmdto) {
		return session.update(namespace + "cm_update", cmdto);
	}

	@Override
	public int cm_delete(int c_num) {
		return session.delete(namespace + "cm_delete", c_num);
	}

	@Override
	public List<CommunityDTO> cm_selectBy(int c_group) {
		return session.selectList(namespace + "cm_selectBy", c_group);
		
	}

	@Override
	public String cm_selectUnick(int u_num) {
			return session.selectOne(namespace + "cm_selectUnick" , u_num);
		
	}

	@Override
	public List<CommunityDTO> cm_searchTitleBy(String str) {
		return session.selectList(namespace + "cm_searchTitleBy" , str);
	}



	@Override
	public List<CommunityDTO> cm_searchContentBy(String str) {
		return session.selectList(namespace + "cm_searchContentBy" , str);
	}

	@Override
	public List<CommunityDTO> cm_searchForewordBy(String f_foreword) {
		return session.selectList(namespace + "cm_searchForewordBy" , f_foreword);
	}

	@Override
	public List<CommunityDTO> unum_selectBy(int u_num) {
		return session.selectList(namespace + "unum_selectBy" , u_num);
	}


	
	
	

}
