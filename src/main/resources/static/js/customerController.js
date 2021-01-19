mainApp.controller('customerController', function($scope,$http) {
    $scope.message = "This page will be used to display add student form";
    var url = "http://localhost:8080/server/all";

    $http.get(url).then( function(response) {
        $scope.customers = response.data;
    });
});