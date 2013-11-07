'use strict';

angular.module('jfall.Model',
    [
    ]);

angular.module('jfall.DataAccess',
    [
        'ngResource',
        'jfall.Model'
    ]);

angular.module('jfall.Controllers',
    [
        'jfall.DataAccess'
    ]);

angular.module('jfall',
    [
        'ngCookies',
        'ngRoute',
        'jm.i18next',
        'jfall.Controllers'
    ]);