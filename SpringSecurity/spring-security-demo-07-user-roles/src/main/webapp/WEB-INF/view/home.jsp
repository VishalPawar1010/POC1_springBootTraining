<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home for security</title>
</head>
<body>
	<h1>welcome to spring security</h1>
	
	<!--display user name and role  -->
	<p>
		User : <security:authentication property ="principal.username"/>
		<br><br>
		Role(s) :  <security:authentication property ="principal.authorities"/>
	</p>
	
	<hr>
	<security:authorize access="hasRole('MANAGER')">
	<!-- add link to point /leaders   -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders" >Leadership Meeting</a> 
		(only for manager peeps)
	</p>
	<hr>
	
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- add link to point /systems   -->
	<p>
		<a href="${pageContext.request.contextPath}/systems" >IT system Meeting</a> 
		(only for admin peeps)
	</p>
	
	
	</security:authorize>
	
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>

</body>
</html>