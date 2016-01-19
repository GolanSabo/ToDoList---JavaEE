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
	<link href='https://fonts.googleapis.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="includes/style.css">
	<script src="includes/script.js"></script>
	<title>Change Details</title>
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
	
	<div class="col-sm-6 col-sm-offset-3">
		<div class="row">
			<div id="wrapper">
				<h1>Account Settings </h1>
				<a href="Controller?action=changePass">Change Password</a>
				<form action="Controller" method="post" class="form-search">
			            <fieldset>
			                <input type="text" id="name" name="fullName" class="input-lg form-control" placeholder="Name"><br>
			                <input type="email" id="email" name="email" class="input-lg form-control" placeholder="Email"><br><br>
			                <button type="submit" class="btn btn-warning pull-left" name="action" value="changeAccount">Change Details</button>
			            </fieldset>
			    </form>
			    <br>
			    <button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModal">Delete Account</button>
			    
			 </div>
	     </div>
	</div>
	
</div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Delete Account</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure you want to delete your account?</p>
       
      </div>
      <div class="modal-footer">
       	<form method="get" action="Controller" enctype="application/x-www-form-urlencoded" >  
			<button type="submit" name="action" value="deleteUser" class="btn btn-warning">Yes</button>
	    	<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
		</form>
      </div>
    </div>

  </div>
</div>
</body>
</html>