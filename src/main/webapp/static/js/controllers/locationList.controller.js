angular.module('O2O').controller("locationListController", ['$http', 'UserService', locationListController]);

function locationListController($http, UserService) {
    this.userService = UserService;
}
