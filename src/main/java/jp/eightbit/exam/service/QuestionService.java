package jp.eightbit.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Question> findAll(Integer chapterId) {
		return questionMapper.findAll((long)chapterId);
	}
	
	/**
	 * 問題idを基に問題を１つ取得する
	 * @param id
	 * @return
	 */
	@Transactional
	public Question findOne(Integer id) {
		return questionMapper.findOne((long)id);
	}
	
	/**
	 * 問題の作成を実行する
	 * @param question
	 */
	@Transactional
	public void save(Question question) {
		questionMapper.save(question);
	}
	
	/**
	 * 問題編集を実行する
	 * @param question
	 */
	@Transactional
	public void update(Question question) {
		System.out.println(question);
//		questionMapper.update(question);
	}
}
