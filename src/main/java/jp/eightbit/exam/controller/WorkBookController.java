package jp.eightbit.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.eightbit.exam.entity.Workbook;
import jp.eightbit.exam.service.WorkbookService;

@Controller
public class WorkBookController {
	@Autowired
	WorkbookService workbookService;

	@GetMapping("/")
	public String index(Model model) {
		List<Workbook> workbookList = workbookService.findAll();
		model.addAttribute("workbookList", workbookList);
		return "index";
	}
}
