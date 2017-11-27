package com.doksusa.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("examService")
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamDAO exam;
	
	public void setExam(ExamDAO exam) {
		this.exam = exam;
	}
	
	@Override
	public List<ExamDTO> exam_selectAll() {
		return exam.exam_selectAll();
	}
	
	
	@Override
	public List<ExamDTO> exam_selectBySubject(String e_subject) {
		return exam.exam_selectBySubject(e_subject);
	}

	@Override
	public List<ExamDTO> exam_selectByGrade(int e_grade) {
		return exam.exam_selectByGrade(e_grade);
	}
	
	
	

	@Override
	public ExamDTO exam_selectByEnum(int e_num) {
		return exam.exam_selectByEnum(e_num);
	}

	@Override
	public int exam_insert(ExamDTO examdto) {
		return exam.exam_insert(examdto);
	}

	@Override
	public int exam_update(int e_num) {
		return exam.exam_update(e_num);
	}

	@Override
	public int exam_delete(int e_num) {
		return exam.exam_delete(e_num);
	}

	
}
