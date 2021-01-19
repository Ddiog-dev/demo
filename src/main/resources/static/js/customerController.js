mainApp.controller('customerController', function($scope,$http) {

    $scope.allCustomer=function (){
        let url = "http://localhost:8080/server/all";

        $http.get(url).then( function(response) {
            $scope.customers = response.data;
        });
    };

    $scope.addCustomer=function (){
        let url = "http://localhost:8080/server/add?name="+$scope.newname+"&email="+$scope.newemail;
        $http.get(url).then( function(response) {
            console.log(response.data);
            $scope.allCustomer();
        });
    };

    $scope.findCustomer=function (){
        let url = "http://localhost:8080/server/findByName?name="+$scope.findname;
        $http.get(url).then( function(response) {
            console.log(response.data);
            $scope.findresult= response.data;
        });
    };

    $scope.allCustomer();
});