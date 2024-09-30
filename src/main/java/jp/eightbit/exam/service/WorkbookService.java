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
	 * 問題集作成を実行する
	 * @param workbook
	 */
	@Transactional
	public void save(Workbook workbook) {
		System.out.println(workbook);
		workbookMapper.save(workbook);
	}
}
