<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Susinsa - 관리자 페이지</title>

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

	<div class="wrapper">
		<!-- Sidebar  -->
		<c:import url="/WEB-INF/views/admin/includes/sidebar.jsp"></c:import>

		<!-- Page Content  -->
		<div id="content">
			<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
			<h1>회원관리</h1>
			<table class="table" id="user_table">
				<thead>
					<tr>
						<th scope="col">고유번호</th>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">성별</th>
						<th scope="col">핸드폰번호</th>
						<th scope="col">가입일자</th>
						<th scope="col">회원탈퇴</th>
						<th scope="col">장바구니내역</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${user_list}" var="vo" varStatus="status">
						<tr>
							<th scope="row">${ vo.user_no }</th>
							<td>${ vo.user_id }</td>
							<td>${ vo.user_name}</td>
							<td>${ vo.user_gender}</td>
							<td>${ vo.user_phone}</td>
							<td>${ vo.user_date}</td>
							<td><button type="button" class="btn btn-danger"
									onclick="deleteUser(${vo.user_no});">회원 삭제</button></td>
							<td><button type="button" id="cartInfo" class="btn btn-info"
									data-toggle="modal" data-target="#CartInfo"
									onclick="UserCart(${vo.user_no})">카트 정보 확인</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 회원 장바구니 내역 모달 -->
			<div class="modal fade bd-example-modal-lg" id="CartInfo"
				tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h3 class="modal-title" id="exampleModalLabel">회원 장바구니 내역</h3>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="container-fluid">
								<table class="table" id="cart_info_table">
									<thead>
										<tr>
											<th scope="col">번호</th>
											<th scope="col">상품 이름</th>
											<th scope="col">옵션 이름</th>
											<th scope="col">수량</th>
											<th scope="col">상품 가격</th>
											<th scope="col">총 가격</th>
										</tr>
									</thead>

									<tbody>

									</tbody>
								</table>
								<p class="text-right" id="cart_amount"></p>
								<p class="text-right" id="cart_sum"></p>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- 회원 장바구니 내역 모달 끝 -->


	<!-- jQuery CDN - Slim version -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<!-- jQuery Custom Scroller CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#sidebar").mCustomScrollbar({
				theme : "minimal"
			});

			$('#sidebarCollapse').on('click', function() {
				$('#sidebar, #content').toggleClass('active');
				$('.collapse.in').toggleClass('in');
				$('a[aria-expanded=true]').attr('aria-expanded', 'false');
			});

			$("#user_table").on('click', '.btn-danger', function () {
			    $(this).closest('tr').remove();
			});
			
		});
		
		function deleteUser(user_no) {
			$.ajax({
				url: "/susinsa_backend/api/admin/user/delete/"+ user_no,
				type: "DELETE",
				contentType : "application/json; charset=UTF-8",
				success: function (data) {
					alert("삭제 되었습니다.");
				}
			});
		}
		
		function UserCart(user_no) {
			var params = "user_no="+user_no
			$.ajax({
				url: "/susinsa_backend/api/cart/get/list",
				data: params,
				type: "GET",
				contentType : "application/json; charset=UTF-8",
				success: function (data) {
					var html = '';
					var amount = 0;
					var sum = 0;
					Object.keys(data.data).map(function(objectKey, index) {
					    var value = data.data[objectKey];
					    console.log(value);
					    html += '<tr>';
					    html += '<td>' + (index+1) + "</td>";
						html += '<td>' + value.product_name + "</td>";
						html += '<td>' + value.cart_count + "</td>";
						html += '<td>' + value.opt_full_detail_name + "</td>";
						html += '<td>' + value.product_price + "</td>";
						html += '<td>' + value.total + "</td>";
						html += '</tr>';
						amount += value.cart_count;
						sum += value.total;
						
						$('#cart_info_table tbody').append(html);
					});
					$('#cart_amount').html("카트 수량 : "+amount); 
					$('#cart_sum').html("카트 총 금액 : " + sum);
				}
			});
		}
	</script>
</body>

</html>