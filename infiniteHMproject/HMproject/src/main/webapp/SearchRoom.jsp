<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanDao" class="infinite.HMproject.HotelDAO" />
	<form action="SearchRoom.jsp" method="get" style="text-align: center">
		<center>
			Room Id : <input type="text" name="roomId" /> <br />
			<br /> <input type="submit" value="SearchRoom" />
		</center>
		<br />
		<br />
	</form>
	<c:if test="${param.roomId != null}">
		<c:set var="roomId" value="${param.roomId}" />
		<c:set var="room" value="${beanDao.searchroom(roomId)}" />
        Room Id : <b> <c:out value="${room.roomId}" />
		</b>
		<br />
        Type : <b> <c:out value="${room.type}" />
		</b>
		<br />
        Status : <b> <c:out value="${room.status}" />
		</b>
		<br />
        CostPerDay: <b> <c:out value="${room.costperday}" />
		</b>
		<br />

	</c:if>

</body>
</html>