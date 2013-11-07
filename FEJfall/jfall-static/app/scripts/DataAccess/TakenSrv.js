angular.module('jfall.DataAccess').
    service('TakenSrv', function ($resource, $q, Task) {
        var taken = undefined;
        var TaskResource = $resource('/api/task/:taskId',
            {search: {method:'GET', params:{urgency:'@urgency', assignedTo:'@assignedTo', process:'@process'  }, isArray:true}
            });

        this.listUrgenties = function() {
            return Task.getValues();
        };

        function getTaken() {
            if (taken == undefined) {
                var d = $q.defer();
                var takenTemp = TaskResource.query({}, function() {
                    taken = Task.fromJsonArray(takenTemp);
                    d.resolve(taken);
                });
                return d.promise;
            } else {
                return taken;
            }
        }
        this.findAllTaken = function(filter) {
            return getTaken();
        };
    });