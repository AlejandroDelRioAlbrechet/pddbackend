"use strict"

function VariantController( $scope, $http ) 
{
    var random = function( from, to ) 
    {
        return Math.floor( Math.random() * ( to - from + 1 ) + from );
    };
    
    $http.get( "localdata/variants.json" ).success( function( data ) 
    {
       var variants = [];
       for( var i = data.range[ 0 ]; i <= data.range[ 1 ]; i++ ) 
       {
           variants.push( i );
       } 
       $scope.variants = variants;
       $scope.randomVariant = function() {
            $( ".variant" ).removeClass( "selected" );
            var number = random( data.range[ 0 ], data.range[ 1 ] );
            $( ".variant" ).eq( number ).addClass( "selected" );
       };
    } );
};

//VariantDetailController.$inject = ['$scope', '$routeParams'];