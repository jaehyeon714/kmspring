package com.bs.spring.student.model.vo;

import com.bs.spring.demo.model.vo.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	private String name;
	private int age;
	private int grade;
	private int classroom;
	private String major;
}
