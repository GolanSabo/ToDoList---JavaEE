<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, il.ac.shenkar.todolist.*" %>
<jsp:useBean id="items" type="java.util.List<Item>" scope="request" />
<<jsp:useBean id="user" class="il.ac.shenkar.todolist.User" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link href='https://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="includes/style.css">
	<script src="includes/script.js"></script>
	<title>Home</title>
</head>
<body id="homePage">
	<header>
	 <!-- Second navbar for search -->
    <nav class="navbar navbar-inverse">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-3">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" id="logo">To-Do-List</a>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-3">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="Controller?action=backToHome">Home</a></li>
            <li><a href="Controller?action=addItem">Add Item</a></li>
            <li><a href="Controller?action=accountSettings">Account Settings</a></li>
            <li><a href="Controller?action=logout">Logout</a></li>
            <li>
              <a class="btn btn-default btn-outline btn-circle"  data-toggle="collapse" href="#nav-collapse3" aria-expanded="false" aria-controls="nav-collapse3">Search</a>
            </li>
          </ul>
          <div class="collapse nav navbar-nav nav-collapse" id="nav-collapse3">
            <form class="navbar-form navbar-right" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" />
              </div>
              <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
            </form>
          </div>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
	</header>
	
	<jsp:setProperty name="user" property="*" />
	<div class="container">
	<div id="wrapper">
	<% Cookie[] cookies = request.getCookies(); %>
	<h1>Welcome <%
					for (Cookie cookie : cookies){
						if (cookie.getName().equals("userName")){
							out.println(cookie.getValue());
						}
					}
				%>
	</h1>
		<h3>You have <jsp:getProperty name="user" property="itemCount" /> tasks</h3>
		<div class="panel panel-primary">
	        <div class="panel-heading">
	            <h3 class="panel-title">Items</h3>
	        </div>   
	        <ul class="list-group">
				<%
					int count=0;
					if(items.size() != 0 && items != null){
						for(Item i: items){
							count++;
				%>
	            <li class="list-group-item">
	                <div class="row toggle" data-toggle="detail-<%=count %>" id="dropdown-detail-<%=count %>">
	                    <div class="col-xs-10">
	                       <section id="textStyle">
	                       		<section id="left"><%=i.getDescription()%></section>
	                       		<section id="right"><%=i.getDueDate()%></section>
	                       	</section>
	                    </div>
	                    <div class="col-xs-2"><i class="fa fa-chevron-down pull-right"></i></div>
	                </div>
	                <div id="detail-<%=count %>">
	                    <hr></hr>
	                    <div class="container">
	                        <div class="fluid-row">
	                            <div class="col-xs-1">
	                                <i class="fa fa-trash-o fa-fw"></i>
	                            </div>
	                            <div class="col-xs-5">
	                                <form method="post" action="Controller" enctype="application/x-www-form-urlencoded" >
	                                	
										<input type="hidden" name="itemId" value="<%= String.valueOf(i.getId())%>">
										<input type="submit" name="action" value="delete" class="btn btn-warning">
									</form>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </li>       
					<%	
							}
						}
					else{
						%>
						<section id="textStyle"> <% out.println("No tasks to show");%></section>
						<%
						}
					%>
	        </ul>
	      </div>
		</div>
</div>
	
</body>
</html>