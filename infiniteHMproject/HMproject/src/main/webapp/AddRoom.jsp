 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<jsp:useBean id="dao" class="infinite.HMproject.HotelDAO"/>
<form  method="get" action="AddRoom.jsp" >

Hotel Id:
<select name="hotelId" >
		<c:forEach var="id" items="${dao.showhotel()}">
			<option value="${id }">
			<c:out value="${id}" />
			</option>
		</c:forEach>
	</select><br/><br/>

 Room Type 



 <input type="text" name="type" />
 
 Costperday
 <input type="number" name="costperday" />

<input type="Submit"  value="AddRoom" />


</form>

<c:if test="${param.type!=null && param.costperday!=null}">
<jsp:useBean id="beanRoom" class="infinite.HMproject.Room" />
<jsp:setProperty property="*" name="beanRoom"/>

<c:out value="${dao.addroom(beanRoom)}"/>

</c:if>
</body>
</html>