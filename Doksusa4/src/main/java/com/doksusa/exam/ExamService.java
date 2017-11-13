package com.doksusa.exam;

import java.util.List;

public interface ExamService {

	public List<ExamDTO> exam_selectAll();

	public ExamDTO exam_select(int e_num);

	public int exam_insert(ExamDTO examdto);

	public int exam_update(int e_num);

	public int exam_delete(int e_num);
}
