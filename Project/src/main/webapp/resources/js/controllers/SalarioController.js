'use strict';

/**
 * Users
 * @constructor
 */
var SalarioController = function($scope, $http,$location,$modal,$log) {
   
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = 1;
	$scope.requestObject.pageSize = 10;
	$scope.requestObject.direction = "DESC";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "ALL";
	$scope.requestObject.searchTerm = "";

    $scope.init = function() {
    	
    };
    
    $scope.init();
    
    var grid_selector = "#salariosList";
	var pager_selector = "#salariosPager";

    $(grid_selector).jqGrid(
	{
		url : 'rest/protected/salarios/getAll',
		datatype: "json",
		mtype: "POST",
		ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
		ajaxRowOptions: { contentType: "application/json; charset=utf-8", dataType: "json" },
		postData: JSON.stringify($scope.requestObject),
		colNames : [ 'Id Salario', 'Monto', 'Fecha'],
		colModel : [ {
			name : 'idSalario',
			hidden: true
		}, {
			name : 'monto'
		}, {
			name : 'fecha'
		}],
		jsonReader : {
	    	root:"salarios",
	        page:  $scope.requestObject.pageNumber,
	        total: function (obj) {

	        	$scope.gridError = false;
	        	$scope.$apply();
	        	$scope.totalPages = 0;

	        	if(obj.errorMessage == null){
	        		$scope.totalPages = obj.totalPages;
	        	}
	        	return $scope.totalPages;
	        },
	        records: function (obj) {

	        	var totalElements = 0;
	        	if(obj.errorMessage == null){
	        		totalElements = obj.totalElements;
	        	}else{
	        		//notifyWsErrorOnGrid(obj);
	        	}
	        	return totalElements;
	        },
	        repeatitems: false
        },
        onPaging: function(button){

			if( !($("#"+button).hasClass("ui-state-disabled")) ){

				if(button == "next_grid-pager"){
					$scope.requestObject.pageNumber += 1;
				}else if(button == "last_grid-pager"){
					$scope.requestObject.pageNumber = $scope.totalPages;
				}else if(button == "first_grid-pager"){
					$scope.requestObject.pageNumber = 1;
				}else if(button == "records"){
					var rowNum = $(".ui-pg-selbox").val();
					$scope.requestObject.pageSize = rowNum;
				}else if(button == "user"){
					var rowNum = $(".ui-pg-input").val();
					$scope.requestObject.pageNumber = rowNum;
				}else{
					$scope.requestObject.pageNumber -= 1;
				}

				$(grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
			}

		},
		onSortCol: function(index,iCol,sortorder){
			$scope.requestObject.sortBy = [];
			$scope.requestObject.sortBy.push(index);
			$scope.requestObject.direction = sortorder.toUpperCase();
			$(grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
		},
		ondblClickRow: function(rowid){		
			var data = $(grid_selector).jqGrid('getRowData', rowid);
			$scope.requestObject.salario = {};
			$scope.requestObject.salario.idSalario = data.idSalario;
			$scope.requestObject.salario.monto = data.monto;
			$scope.requestObject.salario.fecha = data.fecha;

			$("#openModifySalarioModal").click();
		},
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : pager_selector,
		sortname : 'id',
		viewrecords : true,
		sortorder : "desc",
		caption : "Salarios",
		loadComplete : function() {
			var table = this;
			setTimeout(function(){
				//updatePagerIcons(table);
				enableTooltips(table);
			}, 0);
		}
	});

    jQuery(grid_selector).jqGrid('navGrid', pager_selector, {
		edit : false,
		add : true,
		del : false,
		search: false,
		refresh: false
	});

	function enableTooltips(table) {
		$('#add_salariosList')[0].title = "Agregar salario";
	}

	$scope.setSearchColumn = function(searchValue,event){
		//quick fix for radio buttons - only one selected.
		$(".searchBtnGroup .btn").removeClass("active");
		$scope.requestObject.searchColumn = searchValue;
	};

	$scope.search = function(){
		$(grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid",[{ page: 1}]);
	};

	$(window).bind('resize', function() {
		$("#salariosList").setGridWidth($(window).width()-300);
	}).trigger('resize');


	//CUSTOM ACTIONS
	$("#add_salariosList .ui-pg-div").click(function(ev){
		ev.preventDefault();
		return false;
	});

	$scope.open = function(type){
		var modalInstance = $modal.open({
			templateUrl: 'layoutservice/salarios/'+type+'SalarioModal',
			controller: ModalInstanceCreateSalarioCtrl,
			resolve: {
				salario: function() {
					return $scope.requestObject.salario;
				},
				type: function() {
					return type;
				}
			}
		});

	    modalInstance.result.then(function () {
	    	$(grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
	    },function () {
	      $log.info('Modal dismissed at: ' + new Date());	      
	    });

	};

	$("#add_salariosList .ui-pg-div").click(function(ev){
		$("#openAddNewSalarioModal").click();
	});
};

var ModalInstanceCreateSalarioCtrl = function ($http, $scope, $modalInstance, salario, type) {
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = "";
	$scope.requestObject.pageSize = 0;
	$scope.requestObject.direction = "";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "";
	$scope.requestObject.searchTerm = "";

	$scope.requestObject.salario = {};
	
	$scope.init = function() {
		if(salario !== undefined && type === 'modify'){
			$scope.requestObject.salario.idSalario = salario.idSalario;
			$scope.requestObject.salario.monto = salario.monto;
		} else {
			salario = null;
		}
	};

	$scope.create = function(event) {
		if((salario === null) ? this.createSalarioModal.$valid : this.modifySalarioModal.$valid){
			this.onError = false;
			$http.post('rest/protected/salarios/save',$scope.requestObject)
			.success(function(response) {
				if(response.code === 200){
					salario = null;
					$modalInstance.close();
				}
			});
		}else{
			this.onError = true;
		}
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
	
	$scope.init();
};