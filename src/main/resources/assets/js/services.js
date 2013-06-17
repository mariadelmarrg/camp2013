angular.module('library.services', [ 'ngResource' ])

.factory('postService', function($resource) {
	return $resource('service/posts/:postId', {}, {});
});

