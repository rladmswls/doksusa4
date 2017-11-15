package com.doksusa.a_wrongnote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("awService")
public class A_wrongnoteServiceImpl implements A_wrongnoteService {

	@Autowired
	A_wrongnoteDAO aw;
	

	public void setAs(A_wrongnoteDAO aw) {
		this.aw = aw;
	}
	

}
