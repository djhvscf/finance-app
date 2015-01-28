<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!doctype html>

<html xmlns:ng="http://angularjs.org" class="ng-app:Finance" id="ng-app" ng-app="Finance">
	<head>
	    <meta charset="utf-8">
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<link rel="SHORTCUT ICON" href="resources/images/favicon.ico" type="image/x-icon" />
	    <c:import url="/WEB-INF/views/css.jsp"></c:import>		   	    
	    
	    <!--[if lte IE 8]>
	    	<meta http-equiv="X-UA-Compatible" content="IE=edge" >
			<script src="resources/js/ie-shiv.js"></script>
			<script src="resources/js/json3.min.js"></script>
		<![endif]-->
		
		<c:import url="/WEB-INF/views/loginJavascript.jsp"></c:import>
	</head>
	
	<body>
		<div id="wrapper">
		    <div ng-view class="generalContainer container"></div>
		</div>		
	</body>
	
</html>