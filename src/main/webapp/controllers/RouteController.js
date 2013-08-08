"use strict";

angular.module( "phonecat",[] ).config( [ "$routeProvider", function( $routeProvider ) 
{
    $routeProvider.when( "/variants", { templateUrl : "templates/variant.html", controller : VariantController } )
        .when( "/variants/:variant", { templateUrl : "templates/variant-detail.html", controller : VariantDetailController } )
        .when( "/pdd", { templateUrl : "templates/pdd.html", controller : MainController } )
        .when( "/login", { templateUrl : "templates/login.html", controller : LoginController } )
        .when( "/add-data", { templateUrl : "templates/add-data.html", controller : AddDataController } )
        .otherwise( {redirectTo: '/pdd'} );
} ] );

