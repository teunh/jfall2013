'use strict';

angular.module('jfall.Controllers')
  .controller('TakenlijstCtrl', function ($scope, TakenSrv) {
        var filterOptions = ['urgentie'];

        $scope.filter = {};
        $scope.predicate = 'urgentie';
        $scope.reverse = true;
        $scope.taken = TakenSrv.findAllTaken();
        $scope.urgenties = TakenSrv.listUrgenties();

        $scope.toonDatum = function(datum) {
            return moment(datum).startOf('day').fromNow();
        };

        $scope.changeFilter = function() {
            angular.forEach(filterOptions, function(value) {
                if ($scope.filter[value] === null) {
                    $scope.filter[value] = "";
                }
            });
        };

        $scope.bepaalUrgentieClass = function(urgentie) {
            switch (urgentie.value) {
                case 0: return "label-success";
                case 1: return "label-warning";
                case 2: return "label-danger";
            }
        };

        $scope.changeOrder = function(property) {
            if ($scope.predicate === property) {
                $scope.reverse = !$scope.reverse;
            } else {
                $scope.predicate = property;
            }
        };

        $scope.doAction = function() {
            throw { message: "Dit gaat fout!"};
        }
  });
