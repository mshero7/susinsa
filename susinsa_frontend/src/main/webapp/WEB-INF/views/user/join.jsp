<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%><!-- spring 태그 -->
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
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <link href="${pageContext.servletContext.contextPath }/assets/css/shop-join.css" rel="stylesheet">
   <script src="${pageContext.servletContext.contextPath }/assets/js/user/shop-join.js" type="text/javascript"></script>
  	<script type="text/javascript">
	$(function () {
		$( "#user_id" ).change(function() {
			  alert( "Handler for .change() called." );
		});
	})
	
	</script>
  </head>
<body>
   <!-- Navigation -->
   <c:import url='/WEB-INF/views/includes/navigation.jsp'>
      <c:param name="active" value="join" />
   </c:import>
   <!-- /.Navigation -->
   
   <div id="container">
      <div class="card card-container">
            <form:form modelAttribute="userVo" id="join-form" name="joinForm" method="post"
             action="${pageContext.servletContext.contextPath }/user/join">
               <input type="hidden" name="a" value="join">
               <label class="block-label" for="user_id">아이디</label>
               <input type="button" id="check-button" value="체크" class="btn btn-light">
               <img style="display:none" id="check-image" src="${pageContext.servletContext.contextPath }/assets/images/check.png" />
               <form:input path="user_id" id="user_id" class="form-control" required="required"/>
               
               <p style="font-weight:bold; color:#f00; text-align:left; padding:0; margin:0 ">
                  <form:errors path="user_id" />
               </p>
               
               <label class="block-label">패스워드</label>
               <form:password path="user_password" id="user_password" class="form-control"/>
               <p style="font-weight:bold; color:#f00; text-align:left; padding:0; margin:0 ">
                  <form:errors path="user_password" />
               </p>
               
                <spring:hasBindErrors name="user_id">
                   <c:if test="${errors.hasFieldErrors('user_id') }">
                     <p style="font-weight:bold; color:red; text-align:left; padding:0">
                           <spring:message 
                             code="${errors.getFieldError( 'name' ).codes[0] }"                  
                             text="${errors.getFieldError( 'name' ).defaultMessage }" />
                       </p> 	
                  </c:if>
               </spring:hasBindErrors>
               

               
               <label class="block-label" for="name">이름</label>
               <input id="user_name" name="user_name" type="text" value="" class="form-control" required="required">
               <p style="font-weight:bold; color:#f00; text-align:left; padding:0; margin:0 ">
                  <form:errors path="user_name" />
               </p>
               
               <label class="block-label" for="phone">전화번호</label>
               <form:input path="user_phone" id="user_phone" class="form-control" required="required"/>
             	 <p style="font-weight:bold; color:#f00; text-align:left; padding:0; margin:0 ">
                  <form:errors path="user_phone" />
               </p>   
               <fieldset>
                  <label class="block-label" for="gender">성별</label><br>
                  <label>여</label> <form:radiobutton path="user_gender" value="F" checked="checked" />
                  <label>남</label> <form:radiobutton path="user_gender" value="M" />
               </fieldset>
               
               <input type="submit" value="가입하기" class="btn btn-lg btn-primary btn-block btn-join">
               
            </form:form>
      </div>
   </div>
	<!-- Footer -->
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>