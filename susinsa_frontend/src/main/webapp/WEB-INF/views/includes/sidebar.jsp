<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-lg-3">
	<h1 class="my-4">SUSINSA</h1>
	<div class="list-group">
		<c:forEach items="${category_list}" var="vo" varStatus="status">
			<a href="#" class="list-group-item" hidden="true">${vo.category_no}</a>
			<a href="#" class="list-group-item">${vo.category_name}</a>
		</c:forEach>
	</div>
</div>