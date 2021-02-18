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
<title>handReport</title>
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
    
    </div>
    <br>
    <div class ="myDiv">
    
    The Ranks are <br>
   
   	<c:forEach var = "i" begin = "0" end = "${numberOfPlayers - 1 }">
         player position  <c:out value = "${ranks[i][1]}"/>'s rank is 
        
         <c:out value = "${ ranks[i][0]}"/><p>
      </c:forEach>
      
      The winner is "${winner}"
      
       <form action="displayInfo">
       		<input type = "text" name = "name" value = "${numberOfPlayers}">
   			<input type ="submit" value = "Deal Again">
  		</form>
      
    </div>
    
    <br>
	
	
</body>
</html>