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

<!-- Editor - SummerNote -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">



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

#table1 {
	table-layout: fixed;
}

#table1 tr th, #table1 tr td {
	border-color: #e9e9e9;
}

#table1 th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

#table1 th:last-child {
	width: 100px;
}

#table1 td a {
	cursor: pointer;
	display: inline-block;
	margin: 0 5px;
	min-width: 24px;
}

#table1 td a.add {
	color: #27C46B;
}

#table1 td a.edit {
	color: #FFC107;
}

#table1 td a.delete {
	color: #E34724;
}

#table1 td i {
	font-size: 19px;
}

#table1 td a.add i {
	font-size: 24px;
	margin-right: -1px;
	position: relative;
	top: 3px;
}

#table1 .form-control {
	height: 32px;
	line-height: 32px;
	box-shadow: none;
	border-radius: 2px;
}

#table1 td .add {
	display: none;
}

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

<!-- 이미지 업로드 -->


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
													"#table1 tbody tr:last-child")
													.index();
											var row = '<tr>'
													+ '<td class="opt_name"><input type="text" class="form-control" name="opt_name' + index + '"  id="opt_name' + index + '"></td>'
													+ '<td class="opt_detail_name"><input type="text" class="form-control" name="opt_detail_name' + index + '" id="opt_detail_name' + index + '"></td>'
													+ '<td>' + actions
													+ '</td>' + '</tr>';
											$("#table1").append(row);
											$("#table1 tbody tr").eq(index + 1)
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
						$('#option-mixing')
								.click(
										function() {
											var tr = $('#table1 tr');
											var td = tr.children()

											var opt1;
											var opt2;
											var opt3 = new Array();

											// 옵션 설정
											tr
													.each(function(index) {
														var opt_name = $(this)
																.find(
																		".opt_name")
																.html();
														var opt_detail_name = $(
																this)
																.find(
																		".opt_detail_name")
																.html();
														if (opt_name
																&& opt_detail_name) {
															if (index == 2) {
																opt1 = opt_detail_name
																		.split('/');
															}

															if (index == 3) {
																opt2 = opt_detail_name
																		.split('/');
															}
														}
													});

											// 옵션 조합
											opt1.forEach(function(item) {
												opt2.forEach(function(item2) {
													opt3.push(item + '/'
															+ item2);
												});
											});

											console.log(opt3);

											var html = '';

											opt3
													.forEach(function(item,
															index) {
														console.log(item);
														console.log(index);
														html += '<tr>';
														html += '<td name="opt_full_detail_name'+ index +'">';
														html += item;
														html += '</td>';
														html += '<td><input type="text" class="form-control" name="opt_full_detail_extra'+ index +'"/></td>';
														html += '<td><input type="text" class="form-control" name="opt_full_detail_stock'+ index +'"/></td>';
														html += '</tr>';
													})
											console.log(html);
											$('#table2 tbody').append(html);
											return false;
										});

						//Remove button
						$(document).on('click', '#remScnt', function() {
							if (i > 2) {
								$(this).closest('tr').remove();
								i--;
							}
							return false;
						});
					});
</script>
<!-- 옵션 조합 -->
<script>
	
</script>

</head>

<body>
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
							<label for="product_name">상품 이름</label> <input type="text"
								class="form-control" id="product_name" value="" required>
							<div>
								<label for="product_price">상품 가격</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"></span>
									</div>
									<input type="text" class="form-control" id="product_price"
										required>
								</div>
							</div>
							<div>
								<label for="product_weight">상품 무게</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"></span>
									</div>
									<input type="text" class="form-control" id="product_weight"
										placeholder="" required>
								</div>
							</div>
							<div class="col-mb-3">
								<div class="btn-group mb-3">
									<button type="button" class="btn btn-info dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">상품 카테고리</button>
									<div class="dropdown-menu">
										<c:forEach items="${category_list}" var="vo"
											varStatus="status">
											<a class="dropdown-item">${vo.category_name}</a>
										</c:forEach>
									</div>
								</div>
								<div class="btn-group mb-3">
									<button type="button" class="btn btn-warning dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">브랜드</button>
									<div class="dropdown-menu">
										<a class="dropdown-item">Action</a> <a class="dropdown-item"
											href="#">Another action</a> <a class="dropdown-item" href="#">Something
											else here</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 이미지 업로드 -->
					<div class="mb-3">
						<h2>
							<b>이미지 업로드</b>
						</h2>
						<div class="container">
							<div class="row">
								<div class="col-sm-4 imgUp">
									<div class="imagePreview"></div>
									<label class="btn btn-primary"> Upload<input
										type="file" class="uploadFile img" value="Upload Photo"
										style="width: 100%; height: 0px; overflow: hidden;">
									</label>
								</div>
								<!-- col-2 -->
								<a class="fa fa-plus imgAdd"></a>
							</div>
							<!-- row -->
						</div>
						<!-- container -->
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
							<table class="table table-bordered" id="table1">
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
											<button type="button" id="option-mixing"
												class="btn btn-info mixing">
												<i class="fa fa-plus"></i> 조합하기
											</button>
										</div>
									</div>

								</div>
								<table class="table table-bordered" id="table2">
									<thead>
										<tr>
											<th><b>옵션 조합 결과</b></th>
											<th><b>추가 금액</b></th>
											<th>재고량</th>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="mb-3">
						<h2>상품 상세 설명</h2>
						<div class="form-label-group">
							<textarea name="detail" id="summernote" id="product_detail"
								placeholder="상품 상세를 입력해주세요." required="required">
								
							</textarea>
							<label for="summernote"></label>
						</div>
					</div>

					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">상품
						등록</button>
				</form>
			</div>

		</div>

	</div>
	<!-- jQuery CDN - version (=without AJAX) -->
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


	<!-- Editor - SummerNote -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>



	<!-- Summernote -->
	<script type="text/javascript">
		$(function() {
			$('#summernote')
					.summernote(
							{
								height : 600,
								minHeight : null, // set minimum height of editor
								maxHeight : null, // set maximum height of editor
								fontNames : [ '맑은고딕', 'Arial', 'Arial Black',
										'Comic Sans MS', 'Courier New', ],
								fontNamesIgnoreCheck : [ '맑은고딕' ],
								focus : false,

								callbacks : {
									onImageUpload : function(files, editor,
											welEditable) {
										for (var i = files.length - 1; i >= 0; i--) {
											sendFile(files[i], this);
										}
									}
								}

							});
		});

		function sendFile(file, el) {
			var form_data = new FormData();
			form_data.append('file', file);
			$.ajax({
				data : form_data,
				type : "POST",
				url : "/susinsa_backend/api/file/upload",
				cache : false,
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(img_name) {
					$(el).summernote('editor.insertImage', img_name);
				},
				error : function(request, status, error) {
					console.log(form_data);
					alert("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);
				}
			});
		}
	</script>
	<script>
		$(function() {
			$(".imgAdd")
					.click(
							function() {
								$(this)
										.closest(".row")
										.find('.imgAdd')
										.before(
												'<div class="col-sm-4 imgUp"><div class="imagePreview"></div><label class="btn btn-primary">Upload<input type="file" class="uploadFile img" value="Upload Photo" style="width:100%;height:0px;overflow:hidden;"></label><i class="fa fa-times del"></i></div>');
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
									uploadFile.closest(".imgUp").find(
											'.imagePreview').css(
											"background-image",
											"url(" + this.result + ")");
								}
							}

						});
			});
		});
	</script>
</body>

</html>