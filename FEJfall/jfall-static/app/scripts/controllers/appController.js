'use strict';

angular.module('jfall.Controllers')
    .controller('AppCtrl', function ($scope, TakenSrv) {
        TakenSrv.findAllTaken().then(function(taken){
            $scope.openTaken = taken.filter(function(element) {
                return element.status === 'Open';
            }).length;
        });
    });
