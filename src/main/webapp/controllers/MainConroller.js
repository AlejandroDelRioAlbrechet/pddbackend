function MainController( $scope, $http ) 
{
    $( ".nav li" ).click( function( e ) 
    {  
        e.preventDefault(  );  
        $( ".nav li" ).removeClass( "active" );
        $( this ).addClass( "active" );
    } );
}


