'use strict';

/**
 * LoginController
 * @constructor
 */

var LoginController = function($scope, $http,$location) {
   
	$scope.user = {email:"gerardo@parajeles.com",password:"maruja"};
	
    $scope.init = function() {
    };
    
    $scope.checkLogin = function(){
    	$http.post('rest/login/checkuser',$scope.user).success(function (loginResponse) {
    		if(loginResponse.code == 200){
    			var usuario = {"idUser":loginResponse.idUsuario,"firstName":loginResponse.firstName,"lastName":loginResponse.lastName};
    			$.jStorage.set("user",usuario);
    		
    			var path = "/finance/app#/users";
    			window.location.href = path;
    			
    		}
    	});
    };
    
    $scope.init();
};