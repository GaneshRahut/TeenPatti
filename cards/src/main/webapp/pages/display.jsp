<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style >
	
		.myDiv 
		{
		height: 100%;
	  	 width: 50%;
		 padding: 15px;
		 margin: 0 auto 0 auto;
		 border: 5px outset gray;
	  	 background-color: lightblue;
	  	 text-align: center;  
	  }
	</style>
	
<meta charset="UTF-8">
<title>handsDisplayed</title>
</head>
<body>

	<div class = "myDiv">
	<%int i = 0; %>
	<c:forEach items="${hands.getHands()}" var="hand">
       
       <%= "Player " + i %> <br>
       <%i++; %>
       <%int check =0; %>
       <c:forEach var = "j" begin = "0" end = "2">
			<c:out value = "${hand[j].getSuits()}" />
			<c:out value = "${hand[j].getRank()}" />
		<% if(check < 2){
			out.print(",");
		}	
		check++;
		%>
		
			
		</c:forEach>
		<br><br>
    </c:forEach>
    <br>
    <br>
    
    
    
   <form action="analyze">
   		<input type ="submit" value = "Analyze">
   </form>
  </div>
    

</body>
</html>