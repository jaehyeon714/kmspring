package com.bs.spring.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.spring.student.model.vo.Student;

@Controller
public class StudentControllerOld {
	
	@RequestMapping("/student/enrollstudent.do")
	public String studentController() {
		return "student/student";
	}
	
	@RequestMapping("/student/enrollstudentend.do")
	public String studentInfo(String name, int age, int grade,
			int classroom, String major, Model model) {
		
		Student s = Student.builder()
				.name(name)
				.age(age)
				.grade(grade)
				.classroom(classroom)
				.major(major)
				.build();
		model.addAttribute("student", s);
		
		return "student/studentend";
	}
}
