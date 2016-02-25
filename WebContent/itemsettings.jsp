<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="includes/style.css">
<title>Insert title here</title>
</head>
<body>
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
	<div id="wrapper">
	<h2>Item Setting</h2>
	<form method="post" action="Controller" class="form-inline">
		 <div class="form-group">
			<label>Description</label>
			<input type="text" class="form-control" id="exampleInputName2" placeholder="Description">
		</div>
		 <div class="form-group">
			<label>Due Date</label>
			<input type="date" class="form-control" id="exampleInputDueDate2" placeholder="MM-dd-yyyy">
		</div>
		<input type="submit" name="action" value="updateItemDone" class="btn btn-default">
	</form>
	</div>
</body>
</html>