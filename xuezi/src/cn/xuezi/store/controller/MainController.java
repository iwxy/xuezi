package cn.xuezi.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping("/showIndex.do")
	public String showIndex() {
		return "index";
	}

}
