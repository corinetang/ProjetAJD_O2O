angular.module('O2O').controller('subscribeController', ['$scope', '$http', '$location', 'UserService', subscribeController]);

function subscribeController($scope, $http, $location, UserService) {
    this.userService = UserService;
    this.isSignUpDisplay = false;

    this.addUser = function() {
        $http.post('http://localhost:8080/user/create', this.userService.user)
        .then(function(response) {
            UserService.user = response.data;
            $location.path('/profil');
        });
    }
}
