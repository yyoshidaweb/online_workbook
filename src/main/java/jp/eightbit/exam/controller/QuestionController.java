package jp.eightbit.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.eightbit.exam.entity.Chapter;
import jp.eightbit.exam.entity.Question;
import jp.eightbit.exam.entity.Workbook;
import jp.eightbit.exam.service.ChapterService;
import jp.eightbit.exam.service.QuestionService;
import jp.eightbit.exam.service.WorkbookService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private WorkbookService workbookService;
	
	@GetMapping("/workbook/{workbookId}/{chapterId}/{id}")
	public String showQuestion(@PathVariable(name = "workbookId") Integer workbookId, @PathVariable(name = "chapterId") Integer chapterId, @PathVariable(name = "id") Integer id, Model model) {
		Question question = questionService.findOne(id);
		Chapter chapter = chapterService.findOne(workbookId, chapterId);
		chapter.setWorkbookId((long)workbookId);
		model.addAttribute("question", question);
		model.addAttribute("chapter", chapter);
		return "questionShow";
	}
}
