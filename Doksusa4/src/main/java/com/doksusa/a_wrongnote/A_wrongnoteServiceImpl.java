package com.doksusa.a_wrongnote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("awService")
public class A_wrongnoteServiceImpl implements A_wrongnoteService {

	@Autowired
	A_wrongnoteDAO aw;
	

	public void setAs(A_wrongnoteDAO aw) {
		this.aw = aw;
	}


	@Override
	public List<A_wrongnoteDTO> aw_selectByU_num(int u_num) {
		return aw.aw_selectByU_num(u_num);
	}


	@Override
	public List<A_wrongnoteDTO> aw_selectByA_num(int a_num) {
		return aw.aw_selectByA_num(a_num);
	}


	@Override
	public int aw_insert(A_wrongnoteDTO awdto) {
		return aw.aw_insert(awdto);
	}


	@Override
	public int aw_delete(A_wrongnoteDTO awdto) {
		return aw.aw_delete(awdto);
	}
	
	

}
