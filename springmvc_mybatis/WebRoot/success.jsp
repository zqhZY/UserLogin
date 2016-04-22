<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 继承外部文件头  -->
	<%@ include file="./publictemp/head.jsp" %>
</head>
<body>

	<!-- 继承页面的头 -->
 <div class="header">
 		
 		<c:if test="${userTCustom != null}">	
 
 			<%@ include file="./publictemp/headtop_desc_logined.jsp" %>
 			
 		</c:if>
 		<c:if test="${userTCustom == null}">
 			<%@ include file="./publictemp/headertop_desc.jsp" %>
 		</c:if>
 		
 		<div class="wrap">
 			<%@ include file="./publictemp/header_top.jsp" %>
 		</div>
 </div>
 
 <span>success,<span style="color:red">${userTCustom.name }</span>
 	<a href="${pageContext.request.contextPath}/index.jsp" >click here back to home page.</a> 	
 </span>
	
</body>
</html>

