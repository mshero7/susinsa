<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Wizard-v1</title>
<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Font-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/assets/css/raleway-font.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/assets/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<!-- Jquery -->
<link rel="stylesheet"
	href="https://jqueryvalidation.org/files/demo/site-demos.css">
<!-- Main Style Css -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/assets/css/style.css" />
	<!-- Bootstrap core CSS -->
<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="join" />
	</c:import>
	<!-- /.Navigation -->
	<div class="container">
		<div class="page-content">
			<div class="wizard-v1-content">
				<div class="wizard-form">
					<form class="form-register" id="form-register" action="#"
						method="post">
						<div id="form-total">
							<!-- SECTION 1 -->
							<h2>
								<span class="step-icon"><i class="zmdi zmdi-account"></i></span>
								<span class="step-number">STEP 1</span>
								 <span class="step-text">가입 정보 입력</span>
							</h2>
							<section>
								<div class="inner">
									<div class="form-row">
										<div class="form-holder form-holder-2">
											<label for="username">이름*</label> <input type="text"
												placeholder="이름" class="form-control" id="username"
												name="username" required>
										</div>
									</div>
									
									<div class="form-row">
										<div class="form-holder">
											<label for="userphone">핸드폰번호*</label> <input type="text"
												placeholder="핸드폰번호(ex:01025267336)" class="form-control" id="userphone"
												name="userphone" required>
										</div>
										<div class="form-holder">
											<label for="userphone">//</label>
											<button type="button" class="btn btn-info">가입 확인</button>
										</div>
									</div>
								</div>
							</section>
							<!-- SECTION 2 -->
							<h2>
								<span class="step-icon"><i class="zmdi zmdi-card"></i></span> <span
									class="step-number">STEP 2</span> <span class="step-text">회원 정보 입력</span>
							</h2>
							<section>
								<div class="inner">
									<div class="form-row">
										<div class="form-holder form-holder-2">
											<label for="username">아이디*</label> <input type="text"
												placeholder="아이디" class="form-control" id="userid"
												name="userid" required>
										</div>
									</div>
									<div class="form-row">
										<div class="form-holder">
											<label for="password">비밀번호*</label>
											<input type="password" placeholder="비밀번호" class="form-control" id="userpwd" name="userpwd" required >
										</div>
										<div class="form-holder">
											<label for="confirm_password">비밀번호 확인*</label>
											<input type="password" placeholder="비밀번호 확인" class="form-control" id="userpwd_chk" name="userpwd_chk" required>
										</div>
									</div>
									
									<div class="form-row">
										<div class="form-holder form-holder-2">
											<label for="username">이름*</label> <input type="text"
												placeholder="이름" class="form-control" id="username"
												name="username" required>
										</div>
									</div>
									
									<div class="form-row">
										<div class="form-holder">
											<label for="password">핸드폰번호*</label> <input type="text"
												placeholder="핸드폰번호" class="form-control" id="userphone"
												name="userphone" required>
										</div>
									</div>
								</div>
							</section>
							<!-- SECTION 3 -->
							<h2>
								<span class="step-icon"><i class="zmdi zmdi-receipt"></i></span>
								<span class="step-number">Step 3</span> <span class="step-text">회원 가입 성공</span>
							</h2>
							<section>
								<div class="form-row">
									쇼핑 시작!
								</div>
							</section>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->

	<script
		src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery.steps.js"></script>
	<script
		src="${pageContext.servletContext.contextPath }/assets/js/jquery/join.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
</body>
</html>