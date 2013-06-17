angular.module('library.directives', [])

.directive('navbar', function() {
	return {
		replace : true,
		templateUrl : "partials/navbar.html",
		link : function(scope, element, attrs) {
			$(element).find('ul.nav li').each(function() {
				if ($(this).hasClass(attrs.selected)) {
					$(this).addClass('active');
				}
			});
		}
	};
	
});

