package com.doksusa.foreword;

import java.util.List;

public interface ForewordService {

	public List<ForewordDTO> fore_selectAll();

	public ForewordDTO fore_select(String foreword);

	public int fore_insert(ForewordDTO foredto);

	public int fore_update(ForewordDTO foredto);

	public int fore_delete(String foreword);

}
