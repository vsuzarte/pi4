var app = angular.module('ofertas', []);

app.controller('ofControl', function ($scope, $http) {


    $scope.ofertas = [];

    $http.get('oferta.json').then(function (response) {
        $scope.ofertas = response.data;
    });


});
