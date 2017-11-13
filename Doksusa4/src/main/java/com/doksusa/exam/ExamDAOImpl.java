package com.doksusa.exam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("examdao")
public class ExamDAOImpl implements ExamDAO{
	
	@Autowired
	SqlSession session;

	String namespace = "com.doksusa.exam.";

	@Override
	public List<ExamDTO> exam_selectAll() {
		return session.selectList(namespace + "exam_selectAll");
	}

	@Override
	public ExamDTO exam_selectByEnum(int e_num) {
		return session.selectOne(namespace + "exam_exam_selectByEnum", e_num);
	}

	@Override
	public int exam_insert(ExamDTO examdto) {
		return session.insert(namespace + "exam_insert", examdto);
	}

	@Override
	public int exam_update(int e_num) {
		return session.update(namespace + "exam_update", e_num);
	}

	@Override
	public int exam_delete(int e_num) {
		return session.delete(namespace + "exam_delete", e_num);
	}

	@Override
	public List<ExamDTO> exam_selectBySubject(String e_subject) {
		return session.selectList(namespace + "exam_selectBySubject", e_subject);
	}
	
	
}
