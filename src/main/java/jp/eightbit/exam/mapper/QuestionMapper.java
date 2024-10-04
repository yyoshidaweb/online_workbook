package jp.eightbit.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.eightbit.exam.entity.Question;

@Mapper
public interface QuestionMapper {
	List<Question> findAll(Long chapterId);
	
	Question findOne(@Param("chapterId") Long chapterId, @Param("id") Long id);
	
	void save(Question question);
	
	void update(Question question);
	
	void delete(Long id);
}
