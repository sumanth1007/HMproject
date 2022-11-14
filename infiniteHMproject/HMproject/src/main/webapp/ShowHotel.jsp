<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@page import="java.sql.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<div class =img1>

	<img id="image-1" alt="hotel" src="images/hotel.jpeg"/>

</div>
</head>
<body style="background-image: images/hotel.jpeg;">
<form method="get" action="ShowHotel.jsp">
    <jsp:useBean id="beanDao" class="infinite.HMproject.HotelDAO"/>
    <link rel ="stylesheet" href="Hotel.css">
   <div class ="Hdetails">
    <center>
    <table border='3'>
        <tr>
         <th>hotelId</th>
         <th>hotelName</th>
         <th>Address1</th>
         <th>Address2</th>
         <th>city</th>
         <th>zipcode</th>
         <th>contactNo</th>
         <th> Rating</th>
         <th> Review</th>
         <th> AboutUs</th>
         </center>
              
             
         
        </tr>
      <c:forEach var="ShowHotel" items="${beanDao.showAllhotel()}">
          <tr>
              <td>${ShowHotel.hotelId}</td>
              <td>${ShowHotel.hotelName} </td>
              <td>${ShowHotel.address1} </td>
              <td>${ShowHotel.address2} </td>
              <td>${ShowHotel.city} </td>
              <td>${ShowHotel.zipcode}</td>
              <td>${ShowHotel.contactNo} </td>
              <td>${ShowHotel.rating} </td>
              <td>${ShowHotel.review}</td>
              <td>${ShowHotel.aboutus}</td>
              <td><a href="ShowRoom.jsp?id=${ShowHotel.hotelId}" >TRYTHIS</a></td>
              
          </tr>
          </div> 
      </c:forEach>
     </table>
</form>
</body>
</html>