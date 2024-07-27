<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<section id="content">
	<div id="student-container">
		<h2>학생정보등록</h2>
		<form id="student" method="post" action="/spring/student/enrollstudentend.do">
			<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" name="name">
			</div>
			</div>
			<div class="form-group row">
			<label for="age" class="col-sm-2 col-form-label">나이</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="age" name="age">
			</div>
			</div>
			<div class="form-group row">
			<label for="grade" class="col-sm-2 col-form-label">학년</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="grade" name="grade">
			</div>
			</div>
			<div class="form-group row">
			<label for="classroom" class="col-sm-2 col-form-label">반</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="classroom" name="classroom">
			</div>
			</div>
			<div class="form-group row">
			<label for="major" class="col-sm-2 col-form-label">학과</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="major" name="major">
			</div>
			</div>
			<div class="form-group-row">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-outline-info col-sm-12">
						저장
					</button>
				</div>
			</div>
		</form>
	</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>