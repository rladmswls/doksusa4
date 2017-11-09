package com.doksusa.aptitude;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("apdao")
public class AptitudeDAOImpl implements AptitudeDAO {

	@Autowired
	SqlSession session;
	
	String namespace = "com.doksusa.ap.";
	
	@Override
	public List<AptitudeDTO> ap_selectAll() {
		return session.selectList(namespace + "ap_selectAll");
	}

	@Override
	public AptitudeDTO ap_select(int a_num) {
		return session.selectOne(namespace + "ap_select", a_num);
	}

	@Override
	public int ap_insert(AptitudeDTO apdto) {
		return session.insert(namespace + "ap_insert",apdto);
	}

	@Override
	public int ap_update(AptitudeDTO apdto) {
		return session.update(namespace + "ap_update", apdto);
	}

	@Override
	public int ap_delete(int a_num) {
		return session.delete(namespace + "ap_delete", a_num);
	}

}
