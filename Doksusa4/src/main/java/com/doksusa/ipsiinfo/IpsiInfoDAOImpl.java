package com.doksusa.ipsiinfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("ipsidao")
public class IpsiInfoDAOImpl implements IpsiInfoDAO {

	@Qualifier
	SqlSession session;

	String namespace = "com.doksusa.ipsi.";

	@Override
	public List<IpsiInfoDTO> ipsi_selectAll() {
		return session.selectList(namespace + "ipsi_selectAll");
	}

	@Override
	public List<IpsiInfoDTO> ipsi_selectByKey(String key) {
		return session.selectList(namespace + "ipsi_selectByKey", "%" + key + "%");
	}

	@Override
	public int ipsi_insert(IpsiInfoDTO ipsidto) {
		return session.insert(namespace + "ipsi_insert", ipsidto);
	}

	@Override
	public int ipsi_update(String university) {
		return session.update(namespace + "ipsi_update", university);
	}

	@Override
	public int ipsi_delete(String university) {
		return session.delete(namespace + "ipsi_delete", university);
	}

	@Override
	public String ipsi_selectLogo(String university) {
		return session.selectOne(namespace + "ipsi_selectLogo", university);
	}

}
