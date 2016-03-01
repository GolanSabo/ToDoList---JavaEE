<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="includes/style.css">
	<script src="includes/script.js"></script>
<title>Change Password</title>
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
	          <a class="navbar-brand" href="#">To-Do-List</a>
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
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<h1>Change Password</h1>
				<p class="text-center">Use the form below to change your password. </p>
				<form method="post" id="passwordForm" action="Controller">
					<input type="password" placeholder="Old Password" name="oldPass" class="input-lg form-control" required><br>
					<input type="password" class="input-lg form-control" name="newPass" id="password1" placeholder="New Password" autocomplete="off" required>
					<br>
					<input type="password" class="input-lg form-control" name="newPass2" id="password2" placeholder="Repeat Password" autocomplete="off" required>
					<br>
				<button type="submit" class="col-xs-12 btn btn-primary btn btn-warning" data-loading-text="Changing Password..." name="action" value="changePass">Change Password</button>
				</form>
			</div><!--/col-sm-6-->
		</div><!--/row-->
	</div><!-- wrapper -->
</body>
</html>