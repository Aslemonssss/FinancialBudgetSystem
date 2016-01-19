<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="test" uri="http://www.mytest.org/tags/test" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="<c:url value='/js/jquery-1.10.2.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/jquery.validate.min.js'/>" type="text/javascript"></script>
</head>
<body>
	<form:form modelAttribute="contentModel" method="post"> 	
		
		<form:errors path="*"></form:errors><br/><br/>
			
		name：<form:input path="name" /><br/>
		<form:errors path="name"></form:errors><br/>
		
		
		age：<form:input path="age" /><br/>
		<form:errors path="age"></form:errors><br/>
		
		email：<form:input path="email" /><br/>
		<form:errors path="email"></form:errors><br/>

		<input type="submit" value="Submit" />
		
	</form:form>  
</body>
<test:jsValidate modelAttribute="contentModel"></test:jsValidate>
</html>