package jp.eightbit.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.eightbit.exam.entity.Question;
import jp.eightbit.exam.mapper.QuestionMapper;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	
	/**
	 * 章に紐づく問題をすべて取得する
	 * @param chapterId
	 * @return
	 */
	public List<Question> findAll(Integer chapterId) {
		return questionMapper.findAll((long)chapterId);
	}
	
	public Question findOne(Integer id) {
		return questionMapper.findOne((long)id);
	}
}
