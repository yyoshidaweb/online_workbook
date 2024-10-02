package jp.eightbit.exam.controller;

import java.util.List;

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
public class WorkbookController {
	@Autowired
	WorkbookService workbookService;
	
	@Autowired
	ChapterService chapterService;

	/**
	 * 問題集一覧ページを表示する。
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model) {
		List<Workbook> workbookList = workbookService.findAll();
		model.addAttribute("workbookList", workbookList);
		return "index";
	}
	
	/**
	 * 問題集詳細ページを表示する。
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/workbook/{id}")
	public String showWorkbook(@PathVariable(name = "id") Integer id, Model model) {
		Workbook workbook = workbookService.findOne(id);
		List<Chapter> chapterList = chapterService.findAll(id);
		model.addAttribute("workbook", workbook);
		model.addAttribute("chapterList", chapterList);
		System.out.println(model.getAttribute("chapterList"));
		return "workbookShow";
	}
	
	/**
	 * 問題集作成ページを表示する
	 * @param model
	 * @return
	 */
	@GetMapping("workbook/create")
	public String create(Model model) {
		Workbook workbook = new Workbook();
		model.addAttribute("workbook", workbook);
		return "workbookCreate";
	}
	
	/**
	 * 問題集作成を実行する
	 * @param workbook
	 * @return
	 */
	@PostMapping("workbook/createExecute")
	public String createExecute(@ModelAttribute("workbook") @Validated Workbook workbook, BindingResult result, Model model) {
		if (result.hasErrors()) {
		      return "workbookCreate";
		    } else {
		      workbookService.save(workbook);
		      return "redirect:/";
		    }
	}
	
	/**
	 * 問題集編集ページを表示する
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("workbook/edit/{id}")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		Workbook workbook = workbookService.findOne(id);
		model.addAttribute("workbook", workbook);
		return "workbookEdit";
	}
	
	/**
	 * 問題集編集を実行する
	 * @param id
	 * @param workbook
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("workbook/update/{id}")
	public String update(@PathVariable(name = "id") Long id, @ModelAttribute("workbook") @Validated Workbook workbook, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("workbook", workbook);
			return "workbookEdit";
		} else {
			workbook.setId(id);
			workbookService.update(workbook);
			return "redirect:/";
		}
	}
	
	/**
	 * 問題集を削除する
	 * @param id
	 * @return
	 */
	@PostMapping("workbook/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		workbookService.delete(id);
		return "redirect:/";
	}
}
