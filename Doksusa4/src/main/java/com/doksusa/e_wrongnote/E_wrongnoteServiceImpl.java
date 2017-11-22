package com.doksusa.e_wrongnote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ewService")
public class E_wrongnoteServiceImpl implements E_wrongnoteService {

	@Autowired
	E_wrongnoteDAO ew;

	public void setEs(E_wrongnoteDAO ew) {
		this.ew = ew;
	}

	@Override
	public List<E_wrongnoteDTO> ew_selectByU_num(int u_num) {
		return ew.ew_selectByU_num(u_num);
	}

	@Override
	public List<E_wrongnoteDTO> ew_selectByE_num(int e_num) {
		return ew.ew_selectByE_num(e_num);
	}

	@Override
	public int ew_insert(E_wrongnoteDTO ewdto) {
		return ew.ew_insert(ewdto);
	}

	@Override
	public int ew_delete(E_wrongnoteDTO ewdto) {
		return ew.ew_delete(ewdto);
	}

}
