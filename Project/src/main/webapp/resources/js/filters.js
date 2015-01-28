'use strict';

/* Filters */

var AppFilters = angular.module('Finance.filters', []);

AppFilters.filter('interpolate', ['version', function (version) {
    return function (text) {
        return String(text).replace(/\%VERSION\%/mg, version);
    };
}]);

AppFilters.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        if(input){
        	return input.slice(start);
        }
    }
});