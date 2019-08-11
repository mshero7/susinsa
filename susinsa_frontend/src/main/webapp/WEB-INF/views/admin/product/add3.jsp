<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>ddd</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">

<!-- include libraries(jQuery, bootstrap) -->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/admin-main.css"
	rel="stylesheet">
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

<style type="text/css">
.table-title {
	padding-bottom: 10px;
	margin: 0 0 10px;
}

.table-title h2 {
	margin: 6px 0 0;
	font-size: 22px;
}

.table-title .add-new {
	float: right;
	height: 30px;
	font-weight: bold;
	font-size: 12px;
	text-shadow: none;
	min-width: 100px;
	border-radius: 50px;
	line-height: 13px;
}

.table-title .add-new i {
	margin-right: 4px;
}

.table-title .mixing {
	float: right;
	height: 30px;
	font-weight: bold;
	font-size: 12px;
	text-shadow: none;
	min-width: 100px;
	border-radius: 50px;
	line-height: 13px;
}

.table-title .add-new i {
	margin-right: 4px;
}

table.table {
	table-layout: fixed;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table th:last-child {
	width: 100px;
}

table.table td a {
	cursor: pointer;
	display: inline-block;
	margin: 0 5px;
	min-width: 24px;
}

table.table td a.add {
	color: #27C46B;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

table.table td a.add i {
	font-size: 24px;
	margin-right: -1px;
	position: relative;
	top: 3px;
}

table.table .form-control {
	height: 32px;
	line-height: 32px;
	box-shadow: none;
	border-radius: 2px;
}

table.table td .add {
	display: none;
}
</style>

<script>
	$(document).on("click", "i.del", function() {
		$(this).parent().remove();
	});
	$(document).on("click", "i.del", function() {
		$(this).parent().remove();
	});
	$(function() {
		$(document).on(
				"change",
				".uploadFile",
				function() {
					var uploadFile = $(this);
					var files = !!this.files ? this.files : [];
					if (!files.length || !window.FileReader)
						return; // no file selected, or no FileReader support

					if (/^image/.test(files[0].type)) { // only image file
						var reader = new FileReader(); // instance of the FileReader
						reader.readAsDataURL(files[0]); // read the local file

						reader.onloadend = function() { // set image data as background of div
							//alert(uploadFile.closest(".upimage").find('.imagePreview').length);
							uploadFile.closest(".imgUp").find('.imagePreview')
									.css("background-image",
											"url(" + this.result + ")");
						}
					}

				});
	});

	$(document)
			.ready(
					function() {
						$('[data-toggle="tooltip"]').tooltip();
						var actions = $("table td:last-child").html();
						// Append table with add row form on add new button click
						$(".add-new")
								.click(
										function() {
											$(this)
													.attr("disabled",
															"disabled");
											var index = $(
													"table tbody tr:last-child")
													.index();
											var row = '<tr>'
													+ '<td><input type="text" class="form-control" name="name" id="name"></td>'
													+ '<td><input type="text" class="form-control" name="department" id="department"></td>'
													+ '<td>' + actions
													+ '</td>' + '</tr>';
											$("table").append(row);
											$("table tbody tr").eq(index + 1)
													.find(".add, .edit")
													.toggle();
											$('[data-toggle="tooltip"]')
													.tooltip();
										});
						// Add row on add button click
						$(document).on(
								"click",
								".add",
								function() {
									var empty = false;
									var input = $(this).parents("tr").find(
											'input[type="text"]');
									input.each(function() {
										if (!$(this).val()) {
											$(this).addClass("error");
											empty = true;
										} else {
											$(this).removeClass("error");
										}
									});
									$(this).parents("tr").find(".error")
											.first().focus();
									if (!empty) {
										input.each(function() {
											$(this).parent("td").html(
													$(this).val());
										});
										$(this).parents("tr").find(
												".add, .edit").toggle();
										$(".add-new").removeAttr("disabled");
									}
								});
						// Edit row on edit button click
						$(document).on(
								"click",
								".edit",
								function() {
									$(this).parents("tr").find(
											"td:not(:last-child)").each(
											function() {
												$(this).html(
														'<input type="text" class="form-control" value="'
																+ $(this)
																		.text()
																+ '">');
											});
									$(this).parents("tr").find(".add, .edit")
											.toggle();
									$(".add-new").attr("disabled", "disabled");
								});
						// Delete row on delete button click
						$(document).on("click", ".delete", function() {
							$(this).parents("tr").remove();
							$(".add-new").removeAttr("disabled");
						});
					});
</script>
<style>
body {
	background-color: #f5f5f5;
}

.imageTPreview {
	width: 100%;
	height: 180px;
	background-position: center center;
	background:
		url(http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg);
	background-color: #fff;
	background-size: cover;
	background-repeat: no-repeat;
	display: inline-block;
	box-shadow: 0px -3px 6px 2px rgba(0, 0, 0, 0.2);
}

.imagePreview {
	width: 100%;
	height: 400px;
	background-position: center center;
	background:
		url(http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg);
	background-color: #fff;
	background-size: cover;
	background-repeat: no-repeat;
	display: inline-block;
	box-shadow: 0px -3px 6px 2px rgba(0, 0, 0, 0.2);
}

.btn-primary {
	display: block;
	border-radius: 0px;
	box-shadow: 0px 4px 6px 2px rgba(0, 0, 0, 0.2);
	margin-top: -5px;
}

.imgUp {
	margin-bottom: 15px;
}

.del {
	position: absolute;
	top: 0px;
	right: 15px;
	width: 30px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	background-color: rgba(255, 255, 255, 0.6);
	cursor: pointer;
}

.imgAdd {
	width: 30px;
	height: 30px;
	border-radius: 50%;
	background-color: #4bd7ef;
	color: #fff;
	box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.2);
	text-align: center;
	line-height: 30px;
	margin-top: 0px;
	cursor: pointer;
	font-size: 15px;
}
</style>

</head>

<body>
	ss
	<div class="wrapper">
		<!-- Sidebar  -->
		<c:import url="/WEB-INF/views/admin/includes/sidebar.jsp"></c:import>

		<!-- Page Content  -->
		<div id="content">
			<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />

			<h1>상품 추가</h1>
			<div class="col-md-8 order-md-1">
				<form class="needs-validation" novalidate>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="firstName">상품 이름</label> <input type="text"
								class="form-control" id="firstName" placeholder="" value=""
								required>

							<div class="col-md-6 mb-3">
								<label for="username">상품 가격</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"></span>
									</div>
									<input type="text" class="form-control" id="username"
										placeholder="Username" required>
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="username">상품 무게</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"></span>
									</div>
									<input type="text" class="form-control" id="username"
										placeholder="Username" required>
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="username">상품 카테고리</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"></span>
									</div>
									<input type="text" class="form-control" id="username"
										placeholder="Username" required>
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="username">상품 브랜드</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"></span>
									</div>
									<input type="text" class="form-control" id="username"
										placeholder="Username" required>
								</div>
							</div>
						</div>
						<br>
						<div class="col-md-6 mb-3 imgUp">
							<div class="imagePreview "></div>
							<label class="btn btn-primary"> Upload<input type="file"
								class="uploadFile img" value="Upload Photo"
								style="width: 0px; height: 0px; overflow: hidden;">
							</label>
						</div>
						<!-- col-2 -->
					</div>

					<div class="mb-3">
						<label for="address">상품 상세 설명</label> <input type="text"
							class="form-control" id="address" placeholder="1234 Main St"
							required>
						<div class="invalid-feedback">Please enter your shipping
							address.</div>
					</div>

					<div class="mb-3">
						<div class="table-wrapper">
							<div class="table-title">
								<div class="row">
									<div class="col-sm-8">
										<h2>
											<b>옵션 상세 정보</b>
										</h2>
									</div>
									<div class="col-sm-4">
										<button type="button" class="btn btn-info add-new">
											<i class="fa fa-plus"></i> Add New
										</button>
									</div>
								</div>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><b>Name</b> ex) 사이즈</th>
										<th><b>Value</b> ex) S/M/L</th>
										<th hidden="true">Phone</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<tr hidden="true">
										<td>John Doe</td>
										<td>Administration</td>
										<td hidden="true">(171) 555-2222</td>
										<td><a class="add" title="Add" data-toggle="tooltip"><i
												class="material-icons">&#xE03B;</i></a> <a class="edit"
											title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i></a> <a class="delete"
											title="Delete" data-toggle="tooltip"><i
												class="material-icons">&#xE872;</i></a></td>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="mb-3">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-8">
											<h2>
												<b>옵션 조합 결과</b>
											</h2>
										</div>
										<div class="col-sm-4">
											<button type="button" class="btn btn-info mixing">
												<i class="fa fa-plus"></i> 조합하기
											</button>
										</div>
									</div>
								</div>
								
							</div>
						</div>
					</div>

					<hr class="mb-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input"
							id="same-address"> <label class="custom-control-label"
							for="same-address">Shipping address is the same as my
							billing address</label>
					</div>
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="save-info">
						<label class="custom-control-label" for="save-info">Save
							this information for next time</label>
					</div>
					<hr class="mb-4">

					<h4 class="mb-3">Payment</h4>

					<div class="d-block my-3">
						<div class="custom-control custom-radio">
							<input id="credit" name="paymentMethod" type="radio"
								class="custom-control-input" checked required> <label
								class="custom-control-label" for="credit">Credit card</label>
						</div>
						<div class="custom-control custom-radio">
							<input id="debit" name="paymentMethod" type="radio"
								class="custom-control-input" required> <label
								class="custom-control-label" for="debit">Debit card</label>
						</div>
						<div class="custom-control custom-radio">
							<input id="paypal" name="paymentMethod" type="radio"
								class="custom-control-input" required> <label
								class="custom-control-label" for="paypal">PayPal</label>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="cc-name">Name on card</label> <input type="text"
								class="form-control" id="cc-name" placeholder="" required>
							<small class="text-muted">Full name as displayed on card</small>
							<div class="invalid-feedback">Name on card is required</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="cc-number">Credit card number</label> <input
								type="text" class="form-control" id="cc-number" placeholder=""
								required>
							<div class="invalid-feedback">Credit card number is
								required</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 mb-3">
							<label for="cc-expiration">Expiration</label> <input type="text"
								class="form-control" id="cc-expiration" placeholder="" required>
							<div class="invalid-feedback">Expiration date required</div>
						</div>
						<div class="col-md-3 mb-3">
							<label for="cc-cvv">CVV</label> <input type="text"
								class="form-control" id="cc-cvv" placeholder="" required>
							<div class="invalid-feedback">Security code required</div>
						</div>
					</div>
					<br>

					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
						to check22out</button>
				</form>
			</div>

		</div>

	</div>
	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
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


</body>

</html>