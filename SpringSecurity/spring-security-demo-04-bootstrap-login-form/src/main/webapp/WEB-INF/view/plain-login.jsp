<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>plain-login</title>

<style>
.failed {
	color: red;
}
</style>

</head>
<body>
	<h3>Plain custom login form</h3>

	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<c:if test="${param.error != null }">
			<i class="failed">Sorry ! You entered invalid username/password</i>
		</c:if>

		<c:if test="${param.logout != null}">
			<div class="alert alert-success col-xs-offset-1 col-xs-10">You
				have been logged out.</div>
		</c:if>

		<p>
			User Name : <input type="text" name="username" />
		</p>
		<p>
			Password : <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>

</body>
</html>