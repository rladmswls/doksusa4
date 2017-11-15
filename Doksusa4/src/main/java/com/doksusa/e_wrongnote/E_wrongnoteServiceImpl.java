package com.doksusa.e_wrongnote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ewService")
public class E_wrongnoteServiceImpl implements E_wrongnoteService {

	@Autowired
	E_wrongnoteDAO ew;
	

	public void setEs(E_wrongnoteDAO ew) {
		this.ew = ew;
	}
	

}
