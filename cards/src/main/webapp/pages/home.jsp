<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>home</title>
</head>
<body>
	<div class ="myDiv">
		<form action ="displayInfo">
			Enter Number of Players
			<input type = "text" name = "name">
			<input type = "submit" value = "Deal Cards">
		</form>
	</div>
</body>
</html>