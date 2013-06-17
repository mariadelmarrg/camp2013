var postModule = angular.module('library', ['library.services', 'library.directives']);

postModule.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/',{ 
    	templateUrl: 'partials/post-list.html',
    	controller: PostListController
    })
    .when('/posts/create',{
    	templateUrl: 'partials/post-create.html',
    	controller: PostCreateController
    })
    .when('/posts/create/:postId',{
    	templateUrl: 'partials/post-create.html',
    	controller: PostCreateController
    })
    .when('/posts/delete/:postId',{
    	templateUrl: 'partials/post-list.html',
    	controller: PostDeleteController
    });
//    .otherwise({
//		redirectTo : '/index.html'
//	});
}]);