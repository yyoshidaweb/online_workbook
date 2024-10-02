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
import jp.eightbit.exam.entity.Workbook;
import jp.eightbit.exam.service.ChapterService;
import jp.eightbit.exam.service.WorkbookService;

@Controller
public class ChapterController {
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private WorkbookService workbookService;
	
	/**
	 * 章詳細ページを表示する。
	 * @param workbookId
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/workbook/{workbookId}/{id}")
	public String showChapter(@PathVariable(name = "workbookId") Integer workbookId, @PathVariable(name = "id") Integer id, Model model) {
		Chapter chapter = chapterService.findOne(workbookId, id);
		model.addAttribute("chapter", chapter);
		return "chapterShow";
	}
	
	/**
	 * 章作成ページを表示する。
	 * @param workbookId
	 * @param model
	 * @return
	 */
	@GetMapping("/workbook/{workbookId}/chapter/create")
	public String createChapter(@PathVariable(name = "workbookId") Integer workbookId, Model model) {
		Workbook workbook = workbookService.findOne(workbookId);
		Chapter chapter = new Chapter();
		chapter.setWorkbookId((long)workbookId);
		model.addAttribute("workbook", workbook);
		model.addAttribute("chapter", chapter);
		return "chapterCreate";
	}
	
	/**
	 * 章作成を実行する。
	 * @param chapter
	 * @param result
	 * @param workbook
	 * @param model
	 * @return
	 */
	@PostMapping("/chapter/createExecute")
	public String createExecute(@ModelAttribute("chapter") @Validated Chapter chapter, BindingResult result, @ModelAttribute("workbook") Workbook workbook, Model model) {
		if (result.hasErrors()) {
			return "chapterCreate";
		} else {
			chapterService.save(chapter);
			String workbookIdString = chapter.getWorkbookId().toString();
			return "redirect:/workbook/" + workbookIdString;
		}
	}
	
	@GetMapping("/workbook/{workbookId}/{id}/edit")
	public String editChapter(@PathVariable(name = "workbookId") Integer workbookId, @PathVariable(name = "id") Integer id, Model model) {
		Workbook workbook = workbookService.findOne(workbookId);
		Chapter chapter = chapterService.findOne(workbookId, id);
		model.addAttribute("workbook", workbook);
		model.addAttribute("chapter", chapter);
		return "chapterEdit";
	}
}
