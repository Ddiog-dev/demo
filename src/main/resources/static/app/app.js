var mainApp = angular.module("mainApp", ['ngRoute']);
mainApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/all', {
            templateUrl: 'all.htm', controller: '/js/customerController'
        })
        .when('/add', {
            templateUrl: 'add.htm', controller: '/js/studentController'
        })
        .otherwise ({
            redirectTo: '/add'
        });

}]);