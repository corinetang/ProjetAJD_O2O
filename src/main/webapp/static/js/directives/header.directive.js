angular.module('O2O')
    .directive('header', function() {
        return {
            restrict: 'E',
            templateUrl: 'partials/directives/header.directive.html',
            controller: ['$location', 'UserService', headerController],
            controllerAs: 'self',
            scope: {},
            replace: true
        };
});

function headerController($location, UserService) {
    console.log($location.path())
	this.userService = UserService;
};
