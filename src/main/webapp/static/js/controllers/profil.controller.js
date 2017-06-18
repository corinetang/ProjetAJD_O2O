angular.module('O2O').controller('profilController', ['$scope', '$http', '$window', 'UserService', profilController]);

function profilController($scope, $http, $window, UserService) {
    this.userService = UserService;

    this.editUser = function() {
        $http.post('http://localhost:8080/user/edit', this.userService.user)
        .then(function(response) {
            UserService.user = response.data;
            $location.path('/profil');
        });
    }
}
