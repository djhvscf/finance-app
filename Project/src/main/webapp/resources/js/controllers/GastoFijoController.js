'use strict';

/**
 * Users
 * @constructor
 */
var GastoFijoController = function($scope, $http,$location,$modal,$log) {
   
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = 1;
	$scope.requestObject.pageSize = 10;
	$scope.requestObject.direction = "DESC";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "ALL";
	$scope.requestObject.searchTerm = "";

    $scope.init = function() {};
    
    $scope.init();
    
    var grid_selector = "#gastosFijosList",
    pager_selector = "#gastosFijosPager",
    grid = $(grid_selector);

    grid.jqGrid(
	{
		url : 'rest/protected/gastosFijos/getAll',
		datatype: "json",
		mtype: "POST",
		ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
		ajaxRowOptions: { contentType: "application/json; charset=utf-8", dataType: "json" },
		postData: JSON.stringify($scope.requestObject),
		colNames : [ 'Id Gasto Fijo', 'Nombre', 'Monto', 'Fecha'],
		colModel : [ {
			name : 'idGastoFijo',
			hidden: true
		}, {
			name : 'nombre'
		}, {
			name : 'monto'
		}, {
			name : 'posibleFechaPago'
		}],
		jsonReader : {
	    	root:"gastosFijos",
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

				grid.setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
			}

		},
		onSortCol: function(index,iCol,sortorder){
			$scope.requestObject.sortBy = [];
			$scope.requestObject.sortBy.push(index);
			$scope.requestObject.direction = sortorder.toUpperCase();
			grid.setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
		},
		ondblClickRow: function(rowid){		
			var data = grid.jqGrid('getRowData', rowid);
			$scope.requestObject.gastoFijo = {};
			$scope.requestObject.gastoFijo.idGastoFijo = data.idGastoFijo;
			$scope.requestObject.gastoFijo.monto = data.monto;
			$scope.requestObject.gastoFijo.nombre = data.nombre;
			$scope.requestObject.gastoFijo.posibleFechaPago = data.posibleFechaPago;

			$("#openModifyGastoFijoModal").click();
		},
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : pager_selector,
		sortname : 'nombre',
		viewrecords : true,
		sortorder : "desc",
		caption : "Gastos Fijos",
		footerrow: true,
		loadComplete : function() {
			var table = this;
			setTimeout(function(){
				enableTooltips(table);
				var sum = grid.jqGrid('getCol', 'monto', false, 'sum');
				grid.jqGrid('footerData','set', {nombre: 'Total:', monto: sum});
			}, 1);
		}
	});

    grid.jqGrid('navGrid', pager_selector, {
		edit : false,
		add : true,
		del : true,
		search: false,
		refresh: false
	});

	function enableTooltips(table) {
		$('#add_gastosFijosList')[0].title = "Agregar gasto fijo";
		$('#del_gastosFijosList')[0].title = "Eliminar gasto fijo";
	}

	$scope.setSearchColumn = function(searchValue,event){
		$(".searchBtnGroup .btn").removeClass("active");
		$scope.requestObject.searchColumn = searchValue;
	};

	$scope.search = function(){
		grid.setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid",[{ page: 1}]);
	};

	$(window).bind('resize', function() {
		$("#gastosFijosList").setGridWidth($(window).width()-300);
	}).trigger('resize');

	$("#add_gastosFijosList .ui-pg-div").click(function(ev){
		ev.preventDefault();
		return false;
	});
	
	$("#del_gastosFijosList .ui-pg-div").click(function(ev){
		ev.preventDefault();
		return false;
	});

	$scope.open = function(type){
		var modalInstance = $modal.open({
			templateUrl: 'layoutservice/gastosFijos/'+type+'GastoFijoModal',
			controller: ModalInstanceCreateGastoFijoCtrl,
			resolve: {
				gastoFijo: function() {
					return $scope.requestObject.gastoFijo;
				},
				type: function() {
					return type;
				}
			}
		});

	    modalInstance.result.then(function () {
	    	grid.setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
	    },function () {
	      $log.info('Modal dismissed at: ' + new Date());	      
	    });

	};

	$("#add_gastosFijosList .ui-pg-div").click(function(ev){
		$("#openAddNewGastoFijoModal").click();
	});
	
	$("#del_gastosFijosList .ui-pg-div").click(function(ev){
		var rowId = grid.jqGrid('getGridParam', 'selrow');
		if(rowId !== null) {
			var idGastoFijo = grid.jqGrid('getCell', rowId, 'idGastoFijo');
			$http.post('rest/protected/gastosFijos/delete',idGastoFijo)
			.success(function(response) {
				if(response.code === 200){
					grid.trigger( 'reloadGrid' );
					//Show success message
				}
			});
		} else {
			//Show error message
		}
	});
};

var ModalInstanceCreateGastoFijoCtrl = function ($http, $scope, $modalInstance, gastoFijo, type) {
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = "";
	$scope.requestObject.pageSize = 0;
	$scope.requestObject.direction = "";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "";
	$scope.requestObject.searchTerm = "";

	$scope.requestObject.gastoFijo = {};
	
	$scope.init = function() {
		if(gastoFijo !== undefined && type === 'modify'){
			$scope.requestObject.gastoFijo.idGastoFijo = gastoFijo.idGastoFijo;
			$scope.requestObject.gastoFijo.monto = gastoFijo.monto;
			$scope.requestObject.gastoFijo.nombre = gastoFijo.nombre;
			$scope.requestObject.gastoFijo.posibleFechaPago = gastoFijo.posibleFechaPago;
			
		} else {
			gastoFijo = null;
		}
	};

	$scope.create = function(event) {
		if((gastoFijo === null) ? this.createGastoFijoModal.$valid : this.modifyGastoFijoModal.$valid){
			this.onError = false;
			$http.post('rest/protected/gastosFijos/save',$scope.requestObject)
			.success(function(response) {
				if(response.code === 200){
					gastoFijo = null;
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