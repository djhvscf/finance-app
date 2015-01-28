'use strict';

var Finance = {};

var App = angular.module('Finance', ['Finance.filters', 'Finance.services','Finance.directives']);

// Declare app level module which depends on filters, and services
App.config(function ($routeProvider,$provide,$httpProvider) {
	
	$routeProvider.when('/login', {
        templateUrl: 'layoutservice/loginlayout',
        controller: LoginController
    });
	
	$routeProvider.otherwise({redirectTo: '/login'});
	
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