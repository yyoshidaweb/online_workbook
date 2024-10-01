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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jp.eightbit.exam.entity.Workbook;
import jp.eightbit.exam.service.WorkbookService;

@Controller
public class WorkbookController {
	@Autowired
	WorkbookService workbookService;

	@GetMapping("/")
	public String index(Model model) {
		List<Workbook> workbookList = workbookService.findAll();
		model.addAttribute("workbookList", workbookList);
		return "index";
	}
	
	@GetMapping("/workbook/{id}")
	public String showWorkbook(@PathVariable(name = "id") Integer id, Model model) {
		Workbook workbook = workbookService.findOne(id);
		model.addAttribute("workbook", workbook);
		System.out.println(model.getAttribute("workbook"));
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
}
