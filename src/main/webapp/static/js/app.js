'use strict';

var app = angular.module('O2O', ['ngRoute', 'ngMaterial']);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/home', {
                templateUrl: 'partials/components/home.component.html',
                controller: 'homeController'
            }).
            when('/espace', {
                templateUrl: 'partials/components/espaceList.component.html',
                controller: 'espaceListController'
            }).
            when('/subscribe', {
                templateUrl: 'partials/components/subscribe.component.html',
                controller: 'subscribeController'
            }).
            when('/login', {
                templateUrl: 'partials/components/login.component.html',
                controller: 'loginController'
            }).
            when('/manageLocal', {
                templateUrl: 'partials/components/manageLocal.component.html',
                controller: 'manageLocalController'
            }).
            when('/profil', {
                templateUrl: 'partials/components/profil.component.html',
                controller: 'profilController'
            }).
            when('/location', {
                templateUrl: 'partials/components/locationList.component.html',
                controller: 'locationListController'
            }).
            otherwise({
                redirectTo: '/home'
            });
}]);

app.config(['$mdDateLocaleProvider', function($mdDateLocaleProvider) {
  // Example of a French localization.
  $mdDateLocaleProvider.months = ['janvier', 'février', 'mars', 'avril', 'mai', 'juin', 'juillet', 'aout', 'septembre', 'octobre', 'novembre', 'decembre'];
  $mdDateLocaleProvider.shortMonths = ['Janv', 'Févr', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil', 'Aout', 'Sept', 'Oct', 'Nov', 'Dec'];
  $mdDateLocaleProvider.days = ['dimanche', 'lundi', 'mardi', 'mercredi', 'jeudi', 'vendredi'];
  $mdDateLocaleProvider.shortDays = ['Di', 'Lu', 'Ma', 'Mer', 'Jeu', 'Ven', 'Sam'];
  // Can change week display to start on Monday.
  $mdDateLocaleProvider.firstDayOfWeek = 1;
  // Example uses moment.js to parse and format dates.
  $mdDateLocaleProvider.parseDate = function(dateString) {
    var m = moment(dateString, 'L', true);
    return m.isValid() ? m.toDate() : new Date(NaN);
  };
  $mdDateLocaleProvider.formatDate = function(date) {
    return moment(date).format('L');
  };
  // In addition to date display, date components also need localized messages
  // for aria-labels for screen-reader users.
  $mdDateLocaleProvider.weekNumberFormatter = function(weekNumber) {
    return 'Semaine ' + weekNumber;
  };
  $mdDateLocaleProvider.msgCalendar = 'Calendrier';
  $mdDateLocaleProvider.msgOpenCalendar = 'Ouvrir le calendrier';
}]);
