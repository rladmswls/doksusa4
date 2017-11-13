package com.doksusa.exam;

import java.util.List;

public interface ExamService {

	public List<ExamDTO> exam_selectAll();

	public List<ExamDTO> exam_selectBySubject(String e_subject);
	
	public ExamDTO exam_selectByEnum(int e_num);

	public int exam_insert(ExamDTO examdto);

	public int exam_update(int e_num);

	public int exam_delete(int e_num);
}
