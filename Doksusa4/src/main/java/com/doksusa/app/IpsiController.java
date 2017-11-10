package com.doksusa.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IpsiController {
	@RequestMapping("/ipsi.do")
	public String showIpsi(){
		return "ipsi";
	}
}
