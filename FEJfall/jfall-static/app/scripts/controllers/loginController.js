'use strict';

angular.module('jfall.Controllers')
    .controller('LoginCtrl', function ($scope, $rootScope, $location, $http) {
        $scope.user = {};

        $scope.login = function() {
            $scope.loginError = false;
            $http({
                method: 'post',
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                url: '/api/login',
                data: $scope.user
            }).success(function() {
                $rootScope.loggedIn = true;
                $location.path('/');
            }).error(function() {
                $scope.loginError = true;
            });
        }
    });
