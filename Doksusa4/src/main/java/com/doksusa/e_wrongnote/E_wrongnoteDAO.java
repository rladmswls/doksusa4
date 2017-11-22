package com.doksusa.e_wrongnote;

import java.util.List;

public interface E_wrongnoteDAO {

	public List<E_wrongnoteDTO> ew_selectByU_num(int u_num);

	public List<E_wrongnoteDTO> ew_selectByE_num(int e_num);

	public int ew_insert(E_wrongnoteDTO ewdto);

	public int ew_delete(E_wrongnoteDTO ewdto);

}
