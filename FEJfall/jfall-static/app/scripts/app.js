'use strict';

moment.lang('nl');

angular.module('jm.i18next').config(function ($i18nextProvider) {

    'use strict';

    $i18nextProvider.options = {
        useCookie: false,
        useLocalStorage: false,
        lng: 'nl',
        debug: true,
        fallbackLng: 'nl',
        resGetPath: '../locales/__lng__/__ns__.json'
    };
});

angular.module('jfall').
  config(function ($routeProvider) {
    $routeProvider
      .when('/takenlijst', {
        templateUrl: 'views/takenlijst.html',
        controller: 'TakenlijstCtrl'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .otherwise({
        redirectTo: '/takenlijst'
      });
  }).
  config(function($httpProvider) {
        $httpProvider.defaults.withCredentials = false;
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];

        $httpProvider.interceptors.push(function($rootScope, $location, $q, $cookies) {
            return {
                'request': function(request) {

                    $rootScope.loggedIn = $rootScope.loggedIn || $rootScope.username;
                    if (!$rootScope.loggedIn && $location.path() != '/login') {
                        $location.path('/login');
                    }

                    return request;
                },
                'responseError': function(rejection) {
                    // if we're not logged-in to the web service, redirect to login page
                    if (rejection.status === 401 && $location.path() != '/login') {
                        $rootScope.loggedIn = false;
                        $location.path('/login');
                    }
                    return $q.reject(rejection);
                }
            };
        });
    }).
    factory('$exceptionHandler', function () {
        return function (exception, cause) {
            var logRecord = {
                timestamp: new Date(),
                    level: 'SEVERE',
                message: exception.message
            }
            alert(logRecord.message + " - " + logRecord.timestamp);

            $.ajax({
                type: "POST",
                url: "/api/log",
                data: logRecord,
                dataType: 'json'
            });
        };
    });

