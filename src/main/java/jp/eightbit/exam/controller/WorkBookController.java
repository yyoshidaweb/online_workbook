package jp.eightbit.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkBookController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
