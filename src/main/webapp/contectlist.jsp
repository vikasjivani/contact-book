





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
   String comments = (String)session.getAttribute("comments");
   if(null == comments){
     comments = "";
   }

  
   String comment  = request.getParameter("comment");
   if(null != comment){
     comments = comments + comment + "<br />";
     session.setAttribute("comments", comments);
     response.sendRedirect(request.getContextPath() + "/prg.jsp");
     return;
   }
 %>
    
    
    
    
    <%@page import="com.axelor.serviceimp.ContectDaoImp"
    		import="java.util.List"
    		import="com.axelor.pojo.User"
    		import="com.axelor.pojo.Contect"
    		import="com.axelor.pojo.Phone"
    %>
    
    <% ContectDaoImp cd = new ContectDaoImp(); 
    
    User u =(User)session.getAttribute("user");

	List<Contect> list = cd.getContectList(u.getUid());

    %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Table with Add and Delete Row Feature</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script>
            function ajex(){
                
                var value=document.getElementById('txtName').value;
                var url="renderaAjex.jsp?value="+value;
                
               // document.getElementById('area').innerHTML=value;
                
        if (window.XMLHttpRequest)
        {
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("area").innerHTML=xmlhttp.responseText;
            }
        }

        xmlhttp.open("GET", url, true);
        xmlhttp.send();

            }
            
            </script>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
    body {
        color: #404E67;
        background: #F5F7FA;
		font-family: 'Open Sans', sans-serif;
	}
	.table-wrapper {
		width: 700px;
		margin: 30px auto;
        background: #fff;
        padding: 20px;	
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
    .table-title {
        padding-bottom: 10px;
        margin: 0 0 10px;
    }
    .table-title h2 {
        margin: 6px 0 0;
        font-size: 22px;
    }
    .table-title .add-new {
        float: right;
		height: 30px;
		font-weight: bold;
		font-size: 12px;
		text-shadow: none;
		min-width: 100px;
		border-radius: 50px;
		line-height: 13px;
    }
	.table-title .add-new i {
		margin-right: 4px;
	}
    table.table {
        table-layout: fixed;
    }
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
    }
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }
    table.table th:last-child {
        width: 100px;
    }
    table.table td a {
		cursor: pointer;
        display: inline-block;
        margin: 0 5px;
		min-width: 24px;
    }    
	table.table td a.add {
        color: #27C46B;
    }
    table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #E34724;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table td a.add i {
        font-size: 24px;
    	margin-right: -1px;
        position: relative;
        top: 3px;
    }    
    table.table .form-control {
        height: 32px;
        line-height: 32px;
        box-shadow: none;
        border-radius: 2px;
    }
	table.table .form-control.error {
		border-color: #f50000;
	}
	table.table td .add {
		display: none;
	}
</style>

</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Contect <b>List</b></h2></div>
                    <div class="col-sm-4">
                       <a href="addcontect.jsp"> <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button></a>
                    </div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone 1</th>
                        <th>Phone 2</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="area">
                
                
                <% for(Contect c : list) { %>
                
                    <tr>
                        <td> <%= c.getName() %> </td>
                        <% List<Phone> num = (List<Phone>)c.getNumbers(); %>
                        <% for(Phone p : num) { %>
                        <td><%= p.getNumber() %></td>
						<% } %>		                        
                        <td>
                            <a  href= "update.jsp?id=<%= c.getCid() %>" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a href= "DeleteContect?id=<%= c.getCid() %>" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>
                    
                    <% } %>
                   
                </tbody>
            </table>
        </div>
    </div>  
    
    <center><input type="text" name="txtName" id="txtName" onkeyup="ajex()"></center>
     
</body>
</html>                            