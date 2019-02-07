<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link 	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<link href="mycss.css" rel="stylesheet" >

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="form_main">
					<h4 class="heading">
						<strong>Quick </strong> Contact <span></span>
					</h4>
					<div class="form">
						<form action="addContect" method="POST">
							<input type="text" required=""  placeholder="Please input your Name" name="name" class="txt" /> 
							<input type="text" required=""	placeholder="Please input your 1 mobile No"  name="no1" class="txt" /> 
							<input type="text" placeholder="Please input your 2 mobile No"  name="no2" class="txt" /> 
							

							
							<input type="submit" value="submit" name="submit" class="txt2">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>