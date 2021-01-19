let mainApp = angular.module("mainApp", ['ngRoute']);
mainApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider

        .when('/customers', {
            templateUrl: '/views/all.html',
            controller: 'customerController'
        })
        .otherwise({
            redirectTo: '/all'
        });
}]);