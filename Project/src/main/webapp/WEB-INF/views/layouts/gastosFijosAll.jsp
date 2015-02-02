<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head><title>Finance app | Gastos Fijos</title></head>

<div class="usersGeneralContainer">
	<div class="container">
		<div class="row">
			<form class="navbar-form navbar-left" role="search">
		      	<div class="form-group">
			        <div class="btn-group searchBtnGroup" data-toggle="buttons-radio">
						<button type="button" class="btn btn-default active" ng-click="setSearchColumn('all',$event)">Todos</button>
						<button type="button" class="btn btn-default" ng-click="setSearchColumn('firstName',$event)">Monto</button>
						<button type="button" class="btn btn-default" ng-click="setSearchColumn('lastName',$event)">Lugar</button>
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
	<div class="form-group">
		<table id="gastosFijosList"></table> 
		<div id="gastosFijosPager"></div>
	</div>
	
	<button type="button" id="openAddNewGastoFijoModal" class="hide btn btn-default" ng-click="open('create')">D</button>
	<button type="button" id="openModifyGastoFijoModal" class="hide btn btn-default" ng-click="open('modify')">E</button>
</div>