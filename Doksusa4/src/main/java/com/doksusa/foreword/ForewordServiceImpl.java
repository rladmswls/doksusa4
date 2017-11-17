package com.doksusa.foreword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("foreService")
public class ForewordServiceImpl implements ForewordService{

	@Autowired
	ForewordDAO fore;
	
	public void setFore(ForewordDAO fore) {
		this.fore = fore;
	}

	@Override
	public List<ForewordDTO> fore_selectAll() {
		return fore.fore_selectAll();
	}

	@Override
	public ForewordDTO fore_select(String f_foreword) {
		return fore.fore_select(f_foreword);
	}

	@Override
	public int fore_insert(ForewordDTO foredto) {
		return fore.fore_insert(foredto);
	}

	@Override
	public int fore_update(ForewordDTO foredto) {
		return fore.fore_update(foredto);
	}

	@Override
	public int fore_delete(String f_foreword) {
		return fore.fore_delete(f_foreword);
	}

	@Override
	public List<ForewordDTO> fore_selectForUser() {
		return fore.fore_selectForUser();
	}

}
