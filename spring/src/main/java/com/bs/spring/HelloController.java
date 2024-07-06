package com.bs.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
		System.out.println("HelloController생성 :)");
	}
	
	@RequestMapping("/")
	public String mainpage() {
		System.out.println("mainpage메소드 실행!!");
		return "index";
	}
	
}
