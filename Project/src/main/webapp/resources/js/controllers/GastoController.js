'use strict';

/**
 * Gasto Controller
 * @constructor
 */
var GastoController = function( $scope, $http, $location, $modal, $log ) {
	
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = 1;
	$scope.requestObject.pageSize = 10;
	$scope.requestObject.direction = "DESC";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "ALL";
	$scope.requestObject.searchTerm = "";
	$scope.total = 0;

	$scope.init = function() {};
    
    $scope.init();
    
    var grid_selector = "#gastosList",
	pager_selector = "#gastosPager",
	grid = $(grid_selector);
	
    grid.jqGrid(
	{
		url : 'rest/protected/gastos/getAll',
		datatype: "json",
		mtype: "POST",
		ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
		ajaxRowOptions: { contentType: "application/json; charset=utf-8", dataType: "json" },
		postData: JSON.stringify($scope.requestObject),
		colNames : [ 'Id Gasto', 'Lugar', 'Monto', 'Descripción', 'Fecha'],
		colModel : [ {
			name : 'idGasto',
			hidden: true
		}, {
			name : 'lugar'
		}, {
			name : 'monto'
		}, {
			name : 'descripcion'
		}, {
			name : 'fecha'
		}],
		jsonReader : {
	    	root:"gastos",
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
			$scope.requestObject.gasto = {};
			$scope.requestObject.gasto.idGasto = data.idGasto;
			$scope.requestObject.gasto.monto = data.monto;
			$scope.requestObject.gasto.lugar = data.lugar;
			$scope.requestObject.gasto.descripcion = data.descripcion;
			$scope.requestObject.gasto.fecha = data.fecha;

			$("#openModifyGastoModal").click();
		},
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : pager_selector,
		sortname : 'fecha',
		viewrecords : true,
		sortorder : "desc",
		caption : "Gastos",
		footerrow: true,
		loadComplete : function() {
			var table = this;
			setTimeout(function(){
				enableTooltips(table);
				var sum = grid.jqGrid('getCol', 'monto', false, 'sum');
				grid.jqGrid('footerData','set', {lugar: 'Total:', monto: sum});
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
		$('#add_gastosList')[0].title = "Agregar gasto";
		$('#del_gastosList')[0].title = "Eliminar gast0";
	}

	$scope.setSearchColumn = function(searchValue,event){
		$(".searchBtnGroup .btn").removeClass("active");
		$scope.requestObject.searchColumn = searchValue;
	};

	$scope.search = function(){
		grid.setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid",[{ page: 1}]);
	};

	$(window).bind('resize', function() {
		$("#gastosList").setGridWidth($(window).width()-300);
	}).trigger('resize');

	//CUSTOM ACTIONS
	$("#add_gastosList .ui-pg-div").click(function(ev){
		ev.preventDefault();
		return false;
	});
	
	$("#del_gastosList .ui-pg-div").click(function(ev){
		ev.preventDefault();
		return false;
	});

	$scope.open = function(type){
		var modalInstance = $modal.open({
			templateUrl: 'layoutservice/gastos/'+type+'GastoModal',
			controller: ModalInstanceCreateGastoCtrl,
			resolve: {
				gasto: function() {
					return $scope.requestObject.gasto;
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

	$("#add_gastosList .ui-pg-div").click(function(ev){
		$("#openAddNewGastoModal").click();
	});
	
	$("#del_gastosList .ui-pg-div").click(function(ev){
		var rowId = grid.jqGrid('getGridParam', 'selrow');
		if(rowId !== null) {
			var idGasto = grid.jqGrid('getCell', rowId, 'idGasto');
			$http.post('rest/protected/gastos/delete',idGasto)
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

var ModalInstanceCreateGastoCtrl = function ($http, $scope, $modalInstance, gasto, type) {
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = "";
	$scope.requestObject.pageSize = 0;
	$scope.requestObject.direction = "";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "";
	$scope.requestObject.searchTerm = "";

	$scope.requestObject.gasto = {};
	
	$scope.init = function() {
		if(gasto !== undefined && type === 'modify'){
			$scope.requestObject.gasto.idGasto = gasto.idGasto;
			$scope.requestObject.gasto.monto = gasto.monto;
			$scope.requestObject.gasto.lugar = gasto.lugar;
			$scope.requestObject.gasto.descripcion = gasto.descripcion;
		} else {
			gasto = null;
		}
	};

	$scope.create = function(event) {
		if((gasto === null) ? this.createGastoModal.$valid : this.modifyGastoModal.$valid){
			this.onError = false;
			$http.post('rest/protected/gastos/save',$scope.requestObject)
			.success(function(response) {
				if(response.code === 200){
					gasto = null;
					$modalInstance.close();
					//Show success message
				}
			});
		}else{
			this.onError = true;
			//Show error message
		}
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
	
	$scope.init();
};