'use strict';

/**
 * UserRentController
 * @constructor
 */
var UserRentController = function($scope, $http,$location) {
   
    $scope.init = function() {
    	
    	$('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    	$('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    	
    	$http.get('rest/protected/rent/getUserAll')
		.success(function(response) {
			$scope.items = response.alquileres;
		});
    	
    };
    
    $scope.init();
    
    
};