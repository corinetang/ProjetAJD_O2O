angular.module('O2O').controller('manageLocalController', ['$scope', '$http', 'UserService', manageLocalController]);

function manageLocalController($scope, $http, UserService) {
    this.userService = UserService;
    this.selectedLocal = {};
    this.espaces = [];

    this.addLocal = function() {
        delete this.editLocal.edit;
        UserService.user.espaceALouer.push(this.editLocal);
        $http.post('http://localhost:8080/user/edit', UserService.user)
            .then(function(response) {
                UserService.user = response.data;
            });
    }

    this.selectLocal = function(local) {
        this.selectedLocal = local;
        $http.get('http://localhost:8080/espace/findByLocal?id=' + local.id)
            .then(function(response) {
                this.espaces = response.data;
            }.bind(this));
    }

    this.addEspace = function() {
        delete this.editEspace.edit;
        this.editEspace.local = this.selectedLocal;
        $http.post('http://localhost:8080/espace/create', this.editEspace)
            .then(function(response) {
                this.espaces.push(response.data);
                this.editEspace = {};
            }.bind(this));
    }
}
