"use strict"

function LoginController( $scope, $http, $location ) 
{
    $scope.login = function() 
    {
        var loginData = 
            {
                email    : $( "#username" ).val().trim()
            ,   password : $( "#password" ).val().trim()
            };
        $http.post( "rest/login", loginData ).success( function( data ) 
        {
            var phonecat = {};
            phonecat.cache = {};
            phonecat.cache.user = data;
            window.application = phonecat;
            $location.path("/add-data");
        } ).error( function( data ) 
        {
            
        } );
    };
};

