package jp.eightbit.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.eightbit.exam.entity.Chapter;

@Mapper
public interface ChapterMapper {
	List<Chapter> findAll(Long workbookId);
	
	Chapter findOne(@Param("workbookId") Long workbookId, @Param("id") Long id);
	
	void save(Chapter chapter);
	
	void update(Chapter chapter);
	
	void delete(Long id);
}
