package jp.eightbit.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.eightbit.exam.entity.Chapter;
import jp.eightbit.exam.entity.Question;
import jp.eightbit.exam.entity.Workbook;
import jp.eightbit.exam.service.ChapterService;
import jp.eightbit.exam.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ChapterService chapterService;
	
	/**
	 * 問題詳細ページを表示する
	 * @param workbookId
	 * @param chapterId
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/workbook/{workbookId}/{chapterId}/{id}")
	public String showQuestion(@PathVariable(name = "workbookId") Integer workbookId, @PathVariable(name = "chapterId") Integer chapterId, @PathVariable(name = "id") Integer id, Model model) {
		Question question = questionService.findOne(id);
		Chapter chapter = chapterService.findOne(chapterId);
		chapter.setWorkbookId((long)workbookId);
		model.addAttribute("question", question);
		model.addAttribute("chapter", chapter);
		return "questionShow";
	}
	
	/**
	 * 問題作成ページを表示する
	 * @param workbookId
	 * @param chapterId
	 * @param model
	 * @return
	 */
	@GetMapping("/workbook/{workbookId}/{chapterId}/question/create")
	public String createQuestion(@PathVariable(name = "workbookId") Integer workbookId, @PathVariable(name = "chapterId") Integer chapterId, Model model) {
		Chapter chapter = chapterService.findOne(chapterId);
		chapter.setWorkbookId((long)workbookId);
		Question question = new Question();
		question.setChapterId((long)chapterId);
		model.addAttribute("chapter", chapter);
		model.addAttribute("question", question);
		return "questionCreate";
	}
	
	/**
	 * 問題作成を実行する
	 * @param question
	 * @param result
	 * @param chapter
	 * @param model
	 * @return
	 */
	@PostMapping("/question/createExecute")
	public String createExecute(@ModelAttribute("question") @Validated Question question, BindingResult result, @ModelAttribute("chapter") Chapter chapter, Model model) {
		if (result.hasErrors()) {
			return "questionCreate";
		} else {
			String workbookIdString = chapter.getWorkbookId().toString();
			String chapterIdString = question.getChapterId().toString();
			questionService.save(question);
			return "redirect:/workbook/" + workbookIdString + "/" + chapterIdString;
		}
	}
	
	/**
	 * 問題編集ページを表示する
	 * @param workbookId
	 * @param chapterId
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/workbook/{workbookId}/{chapterId}/{id}/edit")
	public String editQuestion(@PathVariable(name = "workbookId") Integer workbookId, @PathVariable(name = "chapterId") Integer chapterId, @PathVariable(name = "id") Integer id, Model model) {
		Chapter chapter = chapterService.findOne(chapterId);
		chapter.setWorkbookId((long)workbookId);
		Question question = questionService.findOne(id);
		question.setChapterId((long)chapterId);
		model.addAttribute("chapter", chapter);
		model.addAttribute("question", question);
		return "questionEdit";
	}
	
	/**
	 * 問題編集を実行する
	 * @param id
	 * @param question
	 * @param result
	 * @param chapter
	 * @param model
	 * @return
	 */
	@PostMapping("/question/update/{id}")
	public String updateChapter(@PathVariable(name = "id") Long id, @ModelAttribute("question") @Validated Question question, BindingResult result, @ModelAttribute("chapter") Chapter chapter, Model model) {
		if (result.hasErrors()) {
			return "questionEdit";
		} else {
			question.setId(id);
			questionService.update(question);
			String workbookIdString = chapter.getWorkbookId().toString();
			String chapterIdString = chapter.getId().toString();
			return "redirect:/workbook/" + workbookIdString + "/" + chapterIdString;
		}
	}
}
