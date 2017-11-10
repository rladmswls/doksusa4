package com.doksusa.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doksusa.ipsiinfo.IpsiInfoDTO;
import com.doksusa.ipsiinfo.IpsiInfoService;

@Controller
public class IpsiController {
	
	@Autowired
	IpsiInfoService ipsiservice;
	
	@RequestMapping("/ipsi.do")
	public String showIpsi(Model model){
		List<IpsiInfoDTO> ipsiInfo = ipsiservice.ipsi_selectAll();
		model.addAttribute("ipsiInfo",ipsiInfo);
		System.out.println("aa");
		return "ipsi";
	}
}
