angular.module('O2O').controller("espaceListController", ['$http', '$location', 'UserService', espaceListController]);

function espaceListController($http, $location, UserService) {
    this.userService = UserService;
    this.optionsFilter = [
        {"name": "All", "options": "all"},
        {"name": "Type", "options": ["BUREAU", "SALLE_REUNION", "ETAGE"]},
        {"name": "Prix"},
        {"name": "Superficie"},
        {"name": "Ville", "options": ["Paris", "Levallois", "Puteaux"]},
    ];
    this.selectedFiltre = this.optionsFilter[0];
    this.selectedOption = "";

    this.selectedEspace = {};
    this.locations = [];

    var self = this;

    this.filterOnClick = function(filtre) {
        this.selectedFiltre = filtre;
        if (this.selectedFiltre.name === 'Type' || this.selectedFiltre.name === 'Ville') {
            this.selectedOption = this.selectedFiltre.options[0];
        }
    }

    this.getAll = function() {
        $http.get('http://localhost:8080/espace/findAll').then(function(data) {
            this.espaceList = data.data;
        }.bind(this), function(error) {});
    }

    this.getByType = function() {
        $http.get('http://localhost:8080/espace/findByType?type=' + this.selectedOption).then(function(data) {
            this.espaceList = data.data;
        }.bind(this), function(error) {});
    }

    this.getByPrice = function() {
        $http.get('http://localhost:8080/espace/findByPrice?minimum='+ this.min + '&maximum=' + this.max).then(function(data) {
            this.espaceList = data.data;
        }.bind(this), function(error) {});
    }

    this.getBySuperficie = function() {
        $http.get('http://localhost:8080/espace/findBySuperficie?minimum='+ this.min + '&maximum=' + this.max).then(function(data) {
            this.espaceList = data.data;
        }.bind(this), function(error) {});
    }

    this.getByVille = function() {
        $http.get('http://localhost:8080/espace/findByVille?ville=' + this.ville).then(function(data) {
            this.espaceList = data.data;
        }.bind(this), function(error) {});
    }

    this.search = function() {
        switch(this.selectedFiltre.name) {
            case "All":
                this.getAll();
                break;
            case "Type":
                this.getByType();
                break;
            case "Prix":
                this.getByPrice();
                break;
            case "Superficie":
                this.getBySuperficie();
                break;
            case "Ville":
                this.getByVille();
                break;
            default:
                this.getAll();
        }
    }

    this.selectEspace = function(espace) {
        this.selectedEspace = espace;
        $http.get('http://localhost:8080/location/findByEspace?id=' + espace.id)
            .then(function(response) {
                this.locations = response.data;
            }.bind(this));
    }

    this.disableSelectedDays = function(date) {
        for (var i = 0; i < self.locations.length; i++) {
            console.log(date, self.locations[i].startDate)
            if (date > moment(self.locations[i].startDate) && date < moment(self.locations[i].endDate))
                return false;
        }
        return true;
    }

    this.louerEspace = function() {
        var location = {
            "startDate": this.selectedStartDate,
            "endDate": this.selectedEndDate,
            "espace": this.selectedEspace
        }
        UserService.user.espaceLoue.push(location);
        $http.post('http://localhost:8080/user/edit', UserService.user)
            .then(function(response) {
                UserService.user = response.data;
                $location.path('/location');
            });
    }

    this.getAll();
};

