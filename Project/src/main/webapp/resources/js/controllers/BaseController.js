'use strict';

/**
 * Users
 * @constructor
 */
var BaseController = function($scope, $http, $location, $modal, $log, options) {
   
	var defaults = { 
		grid_selector: '',
		pager_selector: '',
		url: '',
		colNames: [],
		colModel: [],
		jsonReaderRoot: '',
		ondblClickRow: $.noop,
		open: $.noop,
		caption: '',
		addButton: '',
		addButtonTitle: '',
		createModal: ''
	};
	
	$scope.requestObject = {};
	$scope.requestObject.pageNumber = 1;
	$scope.requestObject.pageSize = 10;
	$scope.requestObject.direction = "DESC";
	$scope.requestObject.sortBy = [];
	$scope.requestObject.searchColumn = "ALL";
	$scope.requestObject.searchTerm = "";

    $scope.init = function() {    	
		for ( var key in options ) { 
			if( options.hasOwnProperty( key ) ) {
				defaults[ key ] = options[ key ];
			}
		}
		return defaults;
    };
    
    $scope.init();
    
    $(defaults.grid_selector).jqGrid(
	{
		url : defaults.url,
		datatype: "json",
		mtype: "POST",
		ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
		ajaxRowOptions: { contentType: "application/json; charset=utf-8", dataType: "json" },
		postData: JSON.stringify($scope.requestObject),
		colNames : defaults.colNames,
		colModel : defaults.colModel,
		jsonReader : {
	    	root: jsonReaderRoot,
	        page: $scope.requestObject.pageNumber,
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

				$(defaults.grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
			}

		},
		onSortCol: function(index,iCol,sortorder){
			$scope.requestObject.sortBy = [];
			$scope.requestObject.sortBy.push(index);
			$scope.requestObject.direction = sortorder.toUpperCase();
			$(defaults.grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid");
		},
		ondblClickRow: defaults.ondblClickRow,
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : pager_selector,
		sortname : 'id',
		viewrecords : true,
		sortorder : "desc",
		caption : defaults.caption,
		loadComplete : function() {
			var table = this;
			setTimeout(function(){ enableTooltips(table); }, 0);
		}
	});

    jQuery(defaults.grid_selector).jqGrid('navGrid', pager_selector, {
		edit : false,
		add : true,
		del : true,
		search: false,
		refresh: false
	});

	function enableTooltips(table) {
		$(addButton)[0].title = defaults.addButtonTitle;
	}

	$scope.setSearchColumn = function(searchValue,event){
		//quick fix for radio buttons - only one selected.
		$(".searchBtnGroup .btn").removeClass("active");
		$scope.requestObject.searchColumn = searchValue;
	};

	$scope.search = function(){
		$(defaults.grid_selector).setGridParam({'postData':JSON.stringify($scope.requestObject)}).trigger("reloadGrid",[{ page: 1}]);
	};

	$(window).bind('resize', function() {
		$(defaults.grid_selector).setGridWidth($(window).width()-300);
	}).trigger('resize');


	//CUSTOM ACTIONS
	$(addButton + " .ui-pg-div").click(function(ev){
		ev.preventDefault();
		return false;
	});

	$scope.open = defaults.open;

	$(defaults.addButton + ".ui-pg-div").click(function(ev){
		$(defaults.createModal).click();
	});
};