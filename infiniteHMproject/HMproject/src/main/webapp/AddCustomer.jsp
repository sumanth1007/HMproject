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
<form method="get" action="AddCustomer.jsp">
    <center>
        Enter UserId :
        <input type="number" name ="userId"/><br/><br/>
        Enter password :
        <input type="text" name ="pass"/><br/><br/>
        
        Enter First Name :
        <input type="text" name ="firstName"/><br/><br/>
        
        Enter last Name :
        <input type="text" name ="lastName"/><br/><br/>
        
        Enter Contact No:
        <input type="text" name ="contactNo"/><br/><br/>
        
        Enter Id Proof :
        <input type="text" name ="idProof"/><br/><br/>
        
        Enter City :
        <input type="text" name ="city"/><br/><br/>
        
        <input type="submit" value ="Insert"/><br/><br/>
    </center>
<c:if test="${param.userId != null}">
    <jsp:useBean id="beanDao" class="infinite.HMproject.HotelDAO"/>
    <jsp:useBean id="customer" class="infinite.HMproject.CustomerDetails" />
    
        <jsp:setProperty property="*" name="customer"/>
        <c:out value="${beanDao.addCustomer(customer)}"/>
</c:if>
</form>
</body>
</html>