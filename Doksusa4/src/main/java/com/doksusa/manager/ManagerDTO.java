package com.doksusa.manager;

public class ManagerDTO {

	String m_id;
	String m_pw;
	
	
	@Override
	public String toString() {
		return "ManagerDTO [m_id=" + m_id + ", m_pw=" + m_pw + "]";
	}


	public ManagerDTO(String m_id, String m_pw) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getM_pw() {
		return m_pw;
	}


	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	
	

	
}
