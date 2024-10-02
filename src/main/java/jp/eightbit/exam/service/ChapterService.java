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
	
	@Transactional
	public List<Chapter> findAll(Integer workbookId) {
		return chapterMapper.findAll((long)workbookId);
	}
}
