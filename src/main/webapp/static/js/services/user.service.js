angular.module('O2O').service('UserService', UserService);

function UserService() {
    this.user = {
        "nom": "",
        "prenom": "",
        "email": "",
        "password": "",
        "telephone": "",
        "espaceALouer": [],
        "espaceLoue": []
    };

    this.isLog = function() {
        return typeof this.user.id != 'undefined';
    }
}
