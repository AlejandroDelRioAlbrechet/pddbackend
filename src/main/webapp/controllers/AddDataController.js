"use strict"

function AddDataController( $scope, $http, $location ) 
{
    function initialize() 
    {
   
    } 
    
    if ( window.application.cache.user ) 
    {
        initialize();
    }
    else 
    {
        $http.get( "rest/login" ).success( function( data ) 
        {
            initialize();
        } ).error( function( data ) 
        {
            $location.path( "/login" );
        } );
    }
    
};


