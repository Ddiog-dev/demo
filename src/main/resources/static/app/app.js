var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/name',{
            templateUrl: 'src/main/resources/static/views/name.html',
            controller: 'namesController'
        })
        .when('/email',{
            templateUrl: 'ssrc/main/resources/static/views/email.html',
            controller: 'emailsController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});