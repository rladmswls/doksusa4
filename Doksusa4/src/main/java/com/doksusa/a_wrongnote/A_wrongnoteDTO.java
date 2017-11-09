package com.doksusa.a_wrongnote;

public class A_wrongnoteDTO {
	int a_num;
	   int u_num;
	   public A_wrongnoteDTO() {
	      super();
	   }
	   public A_wrongnoteDTO(int a_num, int u_num) {
	      super();
	      this.a_num = a_num;
	      this.u_num = u_num;
	   }
	   public int getA_num() {
	      return a_num;
	   }
	   public void setA_num(int a_num) {
	      this.a_num = a_num;
	   }
	   public int getU_num() {
	      return u_num;
	   }
	   public void setU_num(int u_num) {
	      this.u_num = u_num;
	   }
	   @Override
	   public String toString() {
	      return "A_wrongnoteDTO [a_num=" + a_num + ", u_num=" + u_num + "]";
	   }
}
