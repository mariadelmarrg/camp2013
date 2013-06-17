describe("Controller Tests", function() {
	
	var posts = [ {
		id : 1,
		title : "First post",
		content : "Content of first post",
		tags: "tag1 tag2 tag3"
	}, {
		id : 2,
		title : "Second post",
		content : "Content of second post",
		tags: "tag3 tag4 tag5"
	} ];
	
	var $scope = null;
	var $httpBackend = null;
	var $controller = null;
	
	beforeEach(module('library.services'));
	
	beforeEach(inject(function($rootScope, _$controller_, _$httpBackend_) {
		$scope = $rootScope.$new();
		$httpBackend = _$httpBackend_;
		$controller = _$controller_;
	}));
	
	beforeEach(function() {
		this.addMatchers({
			// we need to use toEqualData because the Resource hase extra
			// properties which make simple .toEqual not work.
			toEqualData : function(expect) {
				return angular.equals(expect, this.actual);
			}
		});
	});
	
	describe("PostListController", function(){
		
		it ('shows all posts', function() {
			$httpBackend.expectGET('service/posts?q=').respond( posts );
			$controller(PostListController, {
				$scope : $scope
				
			});	
			expect($scope.posts).not.toBeDefined();
			$scope.$apply();
			$httpBackend.flush();

			expect($scope.posts).toEqualData( posts );

		});
		
	});
	
	describe("PostCreateController", function(){
		
		it ('creating new post and return to home page', inject(function($location) {
			spyOn($location, 'path');
			
			$httpBackend.expectPOST('service/posts').respond({});

			$controller(PostCreateController, { 
				$scope: $scope, 
				$routeParams: {}
			});

			$scope.save({
				title : posts[0].title,
				content : posts[0].content,
				tags: posts[0].tags
			});
			
			$httpBackend.flush();
			
			expect($location.path).toHaveBeenCalledWith('/');
			
		}));

		it ('editing existing post', inject(function($location) {
			spyOn($location, 'path'); 
			
			var editingPost = posts[0];
			$httpBackend.expectGET('service/posts/1').respond(editingPost);
			$httpBackend.expectPOST('service/posts').respond({});
			
			$controller(PostCreateController, { 
				$scope: $scope, 
				$routeParams: { postId : 1 }
			});
			
			$scope.save({
				title : 'edited',
				content : 'edited',
				tags: 'edited'
			});
			
			$httpBackend.flush();
			
			expect($location.path).toHaveBeenCalledWith('/');
			
		}));
		
	});
	
	
});