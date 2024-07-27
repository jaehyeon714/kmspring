<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bs.spring.student.model.vo.Student" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<section id="content">
	<table class="table"id="tbl-dev">
		<tr>
			<th scope="col">이름</th>
			<td>${student.name }</td>
		</tr>
		<tr>
			<th scope="col">나이</th>
			<td>${student.age }</td>
		</tr>
		<tr>
			<th scope="col">학년</th>
			<td>${student.grade }</td>
		</tr>
		<tr>
			<th scope="col">반</th>
			<td>${student.classroom }</td>
		</tr>
		<tr>
			<th scope="col">학과</th>
			<td>${student.major }</td>
		</tr>
	</table>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>