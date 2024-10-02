package jp.eightbit.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.eightbit.exam.entity.Chapter;
import jp.eightbit.exam.mapper.ChapterMapper;

@Service
public class ChapterService {
	@Autowired
	private ChapterMapper chapterMapper;
	
	/**
	 * 問題集のidに紐づく章を全て取得する
	 * @param workbookId
	 * @return
	 */
	@Transactional
	public List<Chapter> findAll(Integer workbookId) {
		return chapterMapper.findAll((long)workbookId);
	}
	
	/**
	 * 章のidを基に章を一つ取得する。
	 * @param id
	 * @return
	 */
	@Transactional
	public Chapter findOne(Integer workbookId, Integer id) {
		return chapterMapper.findOne((long)workbookId, (long)id);
	}
	
	/**
	 * 章の作成を実行する
	 * @param chapter
	 */
	@Transactional
	public void save(Chapter chapter) {
		chapterMapper.save(chapter);
	}
	
	/**
	 * 章の編集を実行する
	 * @param chapter
	 */
	@Transactional
	public void update(Chapter chapter) {
		System.out.println(chapter);
//		chapterMapper.update(chapter);
	}
}
