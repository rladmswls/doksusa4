package com.doksusa.a_wrongnote;

import java.util.List;

public interface A_wrongnoteDAO {
	
	public List<A_wrongnoteDTO> aw_selectByU_num(int u_num);
	public List<A_wrongnoteDTO> aw_selectByE_num(int e_num);
	public int aw_insert(A_wrongnoteDTO awdto);
	public int aw_delete(A_wrongnoteDTO awdto);

}
