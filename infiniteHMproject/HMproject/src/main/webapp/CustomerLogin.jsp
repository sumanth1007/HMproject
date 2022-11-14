<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
</head>
<body>
	<jsp:useBean id="beanDao" class="infinite.HMproject.HotelDAO" />
	<form method="post" action="CustomerLogin.jsp">
		<center>
			<h2>Please Login:</h2>
			UserId:<input type="text" name="userId" size="30" /><br /> <br />
			Password:<input type="password" name="pass" size="30" /><br /> <br />
			<input type="submit" value="Login" /><br />
			<br />
		</center>
	</form>

	<c:if test="${param.userId != null && param.pass != null}">
		<jsp:useBean id="login" class="infinite.HMproject.CustomerDetails" />
		<jsp:setProperty property="*" name="login" />
		<c:set var="userId" value="${param.userId}" />
		<c:set var="password" value="${param.pass}" />
		<c:set var="count" value="${beanDao.loginCheck(userId, password)}" />
		<c:set var="user" value="${user}" scope="session" />
		<c:if test="${count==1}">
			<center>
				<a href="ShowHotel.jsp"><input type=submit value=SHOWHOTEL></a>
			</center>
		</c:if>
		<c:if test="${count==0}">
			<c:out value="Invalid creaditialss..."></c:out>
		</c:if>

		<center>
	</c:if>

</body>
</html>