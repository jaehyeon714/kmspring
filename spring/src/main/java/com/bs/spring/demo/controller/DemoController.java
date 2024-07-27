package com.bs.spring.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.demo.model.vo.Address;
import com.bs.spring.demo.model.vo.Demo;

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
		
		Demo demo = Demo.builder().devName(name)
				.devAge(age)
				.devEmail(email)
				.devGender(gender)
				.devLang(hobby)
				.build();
		
		request.setAttribute("demo", demo);
		return "demo/demoResult";
	}
	
	//클라이언트 요청주소 /demo/demo2 인 서비스 만들기
	///WEB_INF/views/demo/demo.jsp
	@RequestMapping("/demo/demo2")
	public String demo2(String devName, int devAge, String devEmail, 
			String devGender, String[] devLang, Model model) {
		System.out.println(devName+" "+devAge+" "+devEmail
				+" "+devGender+" "+Arrays.toString(devLang));
		Demo d = Demo.builder()
				.devName(devName)
				.devAge(devAge)
				.devEmail(devEmail)
				.devGender(devGender)
				.devLang(devLang)
				.build();
		model.addAttribute("demo", d); 
		// ==request.setAttribute("demo",d)
		
		return "demo/demoResult";
	}
	
	//파리미터값에 대한 상세설정하기
	//@RequestParam어노테이션을 이용
	//파라미터값을 매핑, 기본값설정, 필수값여부를 설정
	@RequestMapping("/demo/demo3")
	public String demo3(
			@RequestParam(name="name") String devName,
			@RequestParam(defaultValue = "10", required = false) int devAge,
			@RequestParam String devEmail,
			@RequestParam String[] devLang) {
		System.out.println(devName + " " + devAge + " " + devEmail
				+ " " + Arrays.toString(devLang));
//		Demo demo = new Demo(devName, devAge, devEmail, devLang);
		return "demo/demo";
	}
	
	// 객체자체로 파라미터값을 받아오기
	// 파라미터의 name값과 클래스의 필드값이 일치해야함.
	@RequestMapping("/demo/demo4")
	public String demo4(Demo demo, Address address) {
		demo.setMyadddress(address);
		System.out.println(demo);
		return "demo/demo";
	}
	
	//파라미터 데이터 Map형식으로 받아서 처리하기
	@RequestMapping("/demo/demo5")
	public String demo5(@RequestParam Map param) {
		System.out.println(param);
		return "demo/demo";
	}
	
	//jsp에 출력할 데이터 전달하기
	
}
