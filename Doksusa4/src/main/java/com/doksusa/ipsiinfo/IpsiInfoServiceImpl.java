package com.doksusa.ipsiinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ipsiService")
public class IpsiInfoServiceImpl implements IpsiInfoService {

	@Autowired
	IpsiInfoDAO ipsi;
	
	public void setIpsi(IpsiInfoDAO ipsi) {
		this.ipsi = ipsi;
	}

	@Override
	public List<IpsiInfoDTO> ipsi_selectAll() {
		return ipsi.ipsi_selectAll();
	}

	@Override
	public List<IpsiInfoDTO> ipsi_selectByKey(String key) {
		return ipsi.ipsi_selectByKey(key);
	}

	@Override
	public int ipsi_insert(IpsiInfoDTO ipsidto) {
		return ipsi.ipsi_insert(ipsidto);
	}

	@Override
	public int ipsi_update(String university) {
		return ipsi.ipsi_update(university);
	}

	@Override
	public int ipsi_delete(String university) {
		return ipsi.ipsi_delete(university);
	}

	@Override
	public String ipsi_selectLogo(String university) {
		return ipsi.ipsi_selectLogo(university);
	}

}
