<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.DateFormat, java.text.SimpleDateFormat, java.util.Date" %>
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
		<title>Add item</title>
	</head>
	<body id="addItemPage">
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
          				</ul>
        		</div><!-- /.navbar-collapse -->
      		</div><!-- /.container -->
	    </nav><!-- /.navbar -->
	</header>
	<div class="container">
		<div class="row">
      		<div class="col-md-6 col-md-offset-3">
        		<div class="well well-sm">
          			<form class="form-horizontal" action="Controller" method="post">
          				<fieldset>
            				<legend class="text-center">Add Item</legend>    
            				<!-- Name input-->
            				<div class="form-group">
              					<label class="col-md-3 control-label" for="Description">Task</label>
              					<div class="col-md-9">
					                <input id="name" type="text" placeholder="Description" class="form-control" name="itemName" required >
              					</div>
            				</div>    
            				<!-- Email input-->
            				<div class="form-group">
              					<label class="col-md-3 control-label" for="date">Due Date</label>
              					<div class="col-md-9">
                					<input id="email" class="form-control"type="date" required name="itemDate" value="<%
										DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
										Date date = new Date();
										out.println(dateFormat.format(date));
										%>">
              					</div>		
            				</div>      
			            <!-- Form actions -->
			            <div class="form-group">
              				<div class="col-md-12 text-right">
          						<input type="submit" name="action" value="done" class="btn btn-primary btn-lg btn-warning">
              				</div>
            			</div>
          			</fieldset>
		          </form>
		        </div>
    		  </div>
			</div>
		</div>
	</body>
</html>