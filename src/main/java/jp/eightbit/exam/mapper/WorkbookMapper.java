package jp.eightbit.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.eightbit.exam.entity.Workbook;

@Mapper
public interface WorkbookMapper {
	List<Workbook> findAll();
	
	Workbook findOne(Long id);
	
	void save(Workbook workbook);
	
	void update(Workbook workbook);
	
	void delete(Long id);
}
