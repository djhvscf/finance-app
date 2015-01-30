'use strict';

/**
 * LoginController
 * @constructor
 */

var LoginController = function($scope, $http,$location) {
   
	$scope.user = {email:"dennis@sophy.com",password:"sopden"};
	
    $scope.init = function() {
    };
    
    $scope.checkLogin = function(){
    	$http.post('rest/login/checkuser',$scope.user).success(function (loginResponse) {
    		if(loginResponse.code == 200){
    			var usuario = {"idUser":loginResponse.idUsuario,"firstName":loginResponse.firstName,"lastName":loginResponse.lastName};
    			$.jStorage.set("user",usuario);
    		
    			var path = "/finance/app#/gastos/all";
    			window.location.href = path;
    			
    		}
    	});
    };
    
    $scope.init();
};