angular.module('O2O').controller('loginController', ['$scope', '$http', '$location', 'UserService', loginController]);

function loginController($scope, $http, $location, UserService) {
    this.isSignUpDisplay = false;
    this.user = {
        'email': '',
        'password': ''
    }

    this.login = function() {
        $http.post('http://localhost:8080/user/login', this.user)
        .then(function(response) {
            if (response.data.length !== 0) {
                UserService.user = response.data;
                $location.path('/profil');
            }
        });
    }
}
