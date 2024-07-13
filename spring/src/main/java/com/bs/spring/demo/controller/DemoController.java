package com.bs.spring.demo.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/demo/demo.do")
	public String parameterTestPage() {
		// /WEB-INF/view/ .jsp -> /WEB-INF/view/demo/demo.jsp
		return "demo/demo";
	}
	
	// 클라이언트가 보낸 데이터는 매핑메소드의 매개변수를 선언해서 처리함
	// 1. HttpServletRequest : 요청정보를 저장하고 있는 객체
	// 2. HttpServletResponse : 응답정보를 저장하고 있는 객체 -> 응답처리]
	// 3. HttpSession : Session 정보를 저장하는 객체(로그인 처리할 때)
	// 4. java.util.Locale : 서버의 로케일정보를 저장하는 객체 -> 지역에 대한 정보 ko_KR
	// 5. InputStream/Reader : 데이터를 서버로 읽어오는 객체 -> read()
	// 6. OutputStream/Writer : 데이터를 서버에서 클라이언트에 보내는 객체 -> write()
	// 7. 기본자료형 변수(int, double, String) : 클라이언트가 보낸 데이터 name과 일치하게 선언 -> 자동으로 저장시켜줌
	// 8. VO클래스타입 : 클라이언트가 보낸 다수의 데이터를 저장하는 객체 -> 필드명 name값이 일치할 때 자동 저장
	// * Date, 다른 클래스들.. spring 처리하지 못하는 것은 403 BadRequest에러를 발생!
	// 9. java.util.Map : 클라이언트가 보낸 데이터를 key:value 형식으로 데이터를 저장해줌!
	// * 주의! 단일값으로 저장 -> 복수값은 해결이 안됨.!
	// 매개변수앞에 사용하는 어노테이션
	// @RequestParam : 클라이언트가 보낸 데이터를 저장할 때 추가 옵션 설정을 할 수 있는 어노테이션
	// @RequestBody : 클라이언트가 보낸 데이터가 JSON방식일 때 자바클래스로 변경해서 저장해주는 어노테이션
	// @SessionAttribute : HttpSession에 저장된 특정값을 가져올 때
	// @ModelAttribute : Model 객체에 데이터를 저장
	// @CookieValue : Cookie에 저장된 특정 값을 가져올 때
	// @RequestHeader : RequestHeader에 특정 헤더값을 가져올 때 사용

	// 서블릿 방식대로 처리하기
	@RequestMapping("/demo/demo1.do")
	public String servletParamTest(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		
		String name = request.getParameter("devName");
		System.out.println(name);
		int age = Integer.parseInt(request.getParameter("devAge"));
		System.out.println(age);
		String email = request.getParameter("devEmail");
		System.out.println(email);
		String gender = request.getParameter("devGender");
		System.out.println(gender);
		// 다중값을 가져올 때는 getParameterValues() 메소드를 이용
		// String[]을 반환
		String[] hobby = request.getParameterValues("devLang");
		System.out.println(Arrays.toString(hobby));
		return "demo/demo";
	}
	
}
