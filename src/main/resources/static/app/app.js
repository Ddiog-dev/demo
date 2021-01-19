let mainApp = angular.module("mainApp", ['ngRoute']);
mainApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider

        .when('/all', {
            templateUrl: '/views/all.html',
            controller: 'customerController'
        })
        .when('/viewStudents', {
            templateUrl: 'viewStudents.htm',
            controller: 'ViewStudentsController'
        })
        .otherwise({
            redirectTo: '/all'
        });
}]);