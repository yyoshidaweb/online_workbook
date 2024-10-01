package jp.eightbit.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import jp.eightbit.exam.entity.Workbook;
import jp.eightbit.exam.mapper.WorkbookMapper;

@Service
public class WorkbookService {
	@Autowired
	private WorkbookMapper workbookMapper;
	
	/**
	 * 全ての問題集を取得する
	 * @return
	 */
	@Transactional
	public List<Workbook> findAll() {
		return workbookMapper.findAll();
	}
	
	/**
	 * idを基に問題集を1つ取得する
	 * @param id
	 * @return
	 */
	@Transactional
	public Workbook findOne(Integer id) {
		return workbookMapper.findOne((long)id);
	}
	
	/**
	 * 問題集作成を実行する
	 * @param workbook
	 */
	@Transactional
	public void save(Workbook workbook) {
		workbookMapper.save(workbook);
	}
	
	/**
	 * 問題集編集を実行する。
	 * @param workbook
	 */
	@Transactional
	public void update(Workbook workbook) {
		System.out.println(workbook);
//		workbookMapper.update(workbook);
	}
}
