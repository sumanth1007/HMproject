<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="id" value="${param.id}" />
	<form method="get" action="ShowHotel.jsp">
		<jsp:useBean id="beanDao" class="infinite.HMproject.HotelDAO" />


		<table border='3'>
			<tr>
				<th>roomId</th>
				<th>type</th>
				<th>Status</th>
				<th>CostPerDay</th>

			</tr>
			<c:forEach var="ShowRoom" items="${beanDao.searchRoom(id)}">
				<tr>
					<td><c:out value="${ShowRoom.roomId}"></c:out></td>
					<td><c:out value="${ShowRoom.type}"></c:out></td>
					<td><c:out value="${ShowRoom.status}"></c:out></td>
					<td><c:out value="${ShowRoom.costperday}"></c:out></td>
					
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</body>
</html>