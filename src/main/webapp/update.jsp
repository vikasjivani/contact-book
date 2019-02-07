<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	 <%@page import="com.axelor.serviceimp.ContectDaoImp"
    		import="java.util.List"
    		import="com.axelor.pojo.Contect"
    		import="com.axelor.pojo.Phone"
    %>
    
    <% ContectDaoImp cd = new ContectDaoImp();  

		String ans = request.getParameter("id");
		int id = Integer.parseInt(ans);
		Contect c = cd.getSingleContect(id);
		
    %>
	
	
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
						<form action="update" method="POST">
							<input type="text"  value="<%= c.getName() %>" name="name" class="txt" /> 
							<input type="hidden" value="<%= c.getCid() %>" name="id"  />
						
							<% List<Phone> list = c.getNumbers();
							    int i = 1;
								for(Phone p : list){
									
							%>
							<input type="text" 	value="<%= p.getNumber() %>"  name="<%= i++ %>" class="txt" /> 
							
							<% } %>
							
							<input type="submit" value="update" name="submit" class="txt2">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>