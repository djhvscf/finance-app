'use strict';

/**
 * RentListController
 * @constructor
 */
var RentListController = function($scope, $http,$location) {
   
	$scope.items ={};
	
    $scope.init = function() {
    	
    	$('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    	$('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    	
    	$http.get('rest/protected/rent/getAll')
		.success(function(response) {
			$scope.items = response.alquileres;
		});
    	
    };
    
    
    $scope.rentMovie = function(idAlquiler){
    	
    	$http.get('rest/protected/rent/rent?id='+idAlquiler)
		.success(function(response) {
			if(response.code == 200){
				
				$http.get('rest/protected/rent/getAll')
				.success(function(response) {
					$scope.items = response.alquileres;
				});
				
			}
		});
    	
    };
    
    $scope.init();
    
    
};