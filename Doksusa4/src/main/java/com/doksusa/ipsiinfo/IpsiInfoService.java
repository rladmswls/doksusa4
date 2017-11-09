package com.doksusa.ipsiinfo;

import java.util.List;

public interface IpsiInfoService {

	public List<IpsiInfoDTO> ipsi_selectAll();

	public List<IpsiInfoDTO> ipsi_selectByKey(String key);

	public String ipsi_selectLogo(String university);

	public int ipsi_insert(IpsiInfoDTO ipsidto);

	public int ipsi_update(String university);

	public int ipsi_delete(String university);

}
