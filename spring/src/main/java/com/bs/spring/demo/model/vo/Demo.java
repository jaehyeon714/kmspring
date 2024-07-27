package com.bs.spring.demo.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, 기본생성자, toString, hashcode, equals를 구현
@AllArgsConstructor // 매개변수있는 생성자 생성
@NoArgsConstructor // 기본생성자 생성
@Builder // 빌더패턴으로 객체를 생성하는 메소드 제공
public class Demo {
	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String[] devLang;
	private double devHeight;
	private Date birthDay;
//	private Timestamp enrollDate;
	private Address myadddress;
}
