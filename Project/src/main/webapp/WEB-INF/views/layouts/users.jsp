<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head><title>Cenfoteca | Users</title></head>

<div class="usersGeneralContainer">

	<div class="container">
		
		<div class="row">
		
			<form class="navbar-form navbar-left" role="search">
		      
		      	<div class="form-group">
			        <div class="btn-group searchBtnGroup" data-toggle="buttons-radio">
						<button type="button" class="btn btn-default active" ng-click="setSearchColumn('all',$event)">All</button>
						<button type="button" class="btn btn-default" ng-click="setSearchColumn('firstName',$event)">First Name</button>
						<button type="button" class="btn btn-default" ng-click="setSearchColumn('lastName',$event)">Last Name</button>
					</div>
				</div>
		      
		      
				<div class="form-group">
				  <input type="text" class="form-control" placeholder="Search" ng-model="requestObject.searchTerm">
				</div>
		      	
		      	<button type="submit" class="btn btn-default" ng-click="search()">
		      		<i class="glyphicon glyphicon-search"></i>
		      	</button>
		      	
		    </form>
		    
		 </div>
		 
	</div>
	
	<!-- please put the jqgrid inside a div, because is causing some angular problems -->
	<div>
		<table id="usersList"></table> 
		<div id="usersPager"></div>
	</div>
	
	<button type="button" id="openAddNewUserModal" class="hide btn btn-default" ng-click="open('create')">D</button>
	<button type="button" id="openEditUserModal" class="hide btn btn-default" ng-click="open('modify')">E</button>
	
</div>