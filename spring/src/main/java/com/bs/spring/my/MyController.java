package com.bs.spring.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
//	@RequestMapping("/mypage")
//	public String mypage() {
//		return "mypage";
//	}
	
	@RequestMapping("/mypage")
	public void mypage() {}
	
}
