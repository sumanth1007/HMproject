<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddHotel.jsp">
    <center>
        Hotel Name :
        <input type="text" name ="hotelName"/> <br/><br/>
        Address1 :
                <input type="text" name ="address1"/> <br/><br/>
        Address2 :
                <input type="text" name ="address2"/> <br/><br/>
        City :
                <input type="text" name ="city"/> <br/><br/>
        Zipcode:
                 <input type="number" name ="zipcode"/> <br/><br/>
        Contact No :
                <input type="number" name ="contactNo"/> <br/><br/>
        Rating :    
                <input type="number" name ="rating"/> <br/><br/>
        Review :
                 <input type="text" name ="review"/> <br/><br/>
        About Us:
                  <input type="text" name ="aboutus"/> <br/><br/>
        
        <input type="submit" value ="Add"/><br/><br/>
    
    </form>
   
<c:if test="${param.hotelName!= null }">
    
    <jsp:useBean id="dao" class="infinite.HMproject.HotelDAO" />
    <jsp:useBean id="hotel" class="infinite.HMproject.HotelDetails" />
    <jsp:setProperty property="*" name="hotel"/>
    <c:out value="${dao.addhotel(hotel)}"/>
</c:if>
</body>
</html>


