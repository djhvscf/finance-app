'use strict';

var Finance = {};

var App = angular.module('Finance', ['Finance.filters', 'Finance.services',
      'Finance.directives','ngGrid','ngTable','ngDragDrop', 'ui.bootstrap','angularFileUpload']);

// Declare app level module which depends on filters, and services
App.config(function ($routeProvider,$provide,$httpProvider) {
	
	$routeProvider.when('/gastos/all', {
        templateUrl: 'layoutservice/gastos/all',
        controller: GastoController
    });
	
	$routeProvider.when('/salarios/all', {
        templateUrl: 'layoutservice/salarios/all',
        controller: SalarioController
    });
	
	$routeProvider.otherwise({redirectTo: '/gastos'});
	
	//RESPONSE INTERCEPTOR FOR ALL THE ANGULAR CALLS
	$provide.factory('responseHttpInterceptor', function($q) {
		return function(promise) {
			return promise.then(function(response) {
				// do something on success
				return response;
			}, function(response) {
				// do something on error
				if(response.status === 401){
					window.location.href = "/finance/#/login";
				}
				return $q.reject(response);
			});
		};
	});

	$httpProvider.responseInterceptors.push('responseHttpInterceptor');
	
	//RESPONSE INTERCEPTOR FOR ALL THE JQUERY CALLS: EX:THE JQGRID
	$.ajaxSetup({
	    beforeSend: function() {
	    },
	    complete: function(response) {
	    	if(response.status === 401){
				window.location.href = "/finance/#/login";
			}
	    }
	});
	
});