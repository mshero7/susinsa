<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->
	<div class="container">
		<div class="row">
			<c:import url='/WEB-INF/views/includes/sidebar.jsp'/>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="https://static.massimodutti.net/3/static2//media/2018/new-home/women//W-Slider-Jade_6.jpg?201908110215011239996000&impolicy=massimodutti-itxmediumhigh&imwidth=2000"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="https://static.massimodutti.net/3/static2//media/2018/new-home/women//W-Slider-SpecialPrices_6.jpg?201908110215011239996000&impolicy=massimodutti-itxmediumhigh&imwidth=2000"
								alt="Second slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:forEach items="${product_list}" var="p_vo" varStatus="status" begin="0" step="1">
						<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<!-- 이미지 URL -->
							<a href='${pageContext.servletContext.contextPath }/product/get/${p_vo.product_no }'>
							<img class="card-img-top" src="${pageContext.servletContext.contextPath }/assets/images/${p_vo.image_upload_name }"></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href='${pageContext.servletContext.contextPath }/product/get/${p_vo.product_no }'>
									${p_vo.product_name }</a>
								</h4>
								<h5>${p_vo.product_price }</h5>
								<p class="card-text">Comment 22!!</p>
							</div>
							<!-- 별점 -->
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
			
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
