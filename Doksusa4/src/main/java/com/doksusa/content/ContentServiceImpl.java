package com.doksusa.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("coService")
public class ContentServiceImpl implements ContentService{

	@Autowired
	ContentDAO co;
	
	public void setCo(ContentDAO co) {
		this.co = co;
	}

	@Override
	public int co_insert(ContentDTO codto) {
		return co.co_insert(codto);
	}

	@Override
	public int co_update(int c_num) {
		return co.co_update(c_num);
	}

	@Override
	public int co_delete(int c_num) {
		return co.co_delete(c_num);
	}

}
