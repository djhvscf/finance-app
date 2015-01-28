<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="now" value="<%=new java.util.Date().getTime()%>" />

<script src="resources/js/lib/json2.js"></script>
<script src="resources/js/lib/jquery-1.8.2.js"></script>
<script src="resources/js/lib/jstorage.js"></script>
<script src="resources/js/lib/jquery-ui.min.js"></script>

<script src="resources/js/lib/functions.js"></script>
<script src="resources/js/lib/placeholders.js"></script>

<!-- JQGRID -->
<script src="resources/js/jqgrid/i18n/grid.locale-en.js"></script>
<script src="resources/js/jqgrid/jquery.jqGrid.src.js"></script>

<script src="resources/js/lib/angular/angular.js"></script>
<script src="resources/js/lib/angular/ng-table.js"></script>
<script src="resources/js/lib/angular/ng-grid-2.0.5.min.js"></script>
<script src="resources/js/lib/angular/ng-grid-flexible-height.js"></script>
<script src="resources/js/lib/angular/angular-dragdrop.min.js"></script>
<script src="resources/js/lib/jquery.scrollTo.min.js"></script>

<!-- UPLOAD FILE -->
<script src="resources/js/uploadfile/angular-file-upload-shim.min.js"></script>
<script src="resources/js/uploadfile/angular-file-upload.min.js"></script>

<script src="resources/js/app.js"></script>
<script src="resources/js/filters.js"></script>
<script src="resources/js/directives.js"></script>
<script src="resources/js/services.js"></script>

<script src="resources/js/controllers/UsersController.js"></script>
<script src="resources/js/controllers/RentController.js"></script>
<script src="resources/js/controllers/RentListController.js"></script>
<script src="resources/js/controllers/UserRentController.js"></script>

<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/js/lib/ui-bootstrap-tpls-0.9.0.min.js"></script>

<script type="text/javascript">
	jQuery(function($) {
		
		$(window).bind('resize',onResize);
		setTimeout(onResize,500);
		
		function onResize(){
			
			var h = $("#wrapper").innerHeight();
			var hTotal = $(window).height();
			var header = $(".navbar").height();
			
			if(h > hTotal ){
			}else{
				
				var offset = 100;
				var d = hTotal-header-offset;
				$("#wrapper").height(d);
			}
		}	 
	});
</script>