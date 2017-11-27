package com.doksusa.e_sub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public String searchLink(int e_num, int e_subnum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("e_num", e_num);
		map.put("e_subnum", e_subnum);
		return session.selectOne(namespace+"es_searchLink",map);
	}

}
