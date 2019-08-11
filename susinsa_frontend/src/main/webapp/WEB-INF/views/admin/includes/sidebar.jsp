<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/admin-main.css"
	rel="stylesheet">
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

</head>
<body>
	<nav id="sidebar">
		<div class="sidebar-header">
			<h3>
				<a href="${pageContext.servletContext.contextPath }/admin">
					SUSINSA</a>
			</h3>
		</div>

		<ul class="list-unstyled components">
			<p>Administartion</p>
			<li><a href="#userSubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">User</a>
				<ul class="collapse list-unstyled" id="userSubmenu">
					<li><a
						href="${pageContext.servletContext.contextPath }/admin/user">User
							Information</a></li>
				</ul></li>

			<li><a href="#productSubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">Product</a>
				<ul class="collapse list-unstyled" id="productSubmenu">
					<li><a href="${pageContext.servletContext.contextPath }/admin/product">Product Information</a></li>
					<li><a href="${pageContext.servletContext.contextPath }/admin/product/add">Product Add</a></li>
				</ul></li>
			<li><a href="#orderSubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">Orders</a>
				<ul class="collapse list-unstyled" id="orderSubmenu">
					<li><a href="${pageContext.servletContext.contextPath }/admin/orders">Orders Information</a></li>
				</ul></li>
			<li>
			<li>
				<a href="#brandSubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">Brand</a>
				<ul class="collapse list-unstyled" id="brandSubmenu">
					<li><a href="${pageContext.servletContext.contextPath }/admin/brand">Brand Information</a></li>
				</ul>
			</li>
			<li>
				<a href="#categorySubmenu" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle">Category</a>
				<ul class="collapse list-unstyled" id="categorySubmenu">
					<li><a href="${pageContext.servletContext.contextPath }/admin/category">Category Information</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</body>
</html>