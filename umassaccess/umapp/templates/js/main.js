$(function() {
    /* START OF DEMO JS - NOT NEEDED */
    if (window.location == window.parent.location) {
        $('#fullscreen').html('<span class="glyphicon glyphicon-resize-small"></span>');
        $('#fullscreen').attr('href', 'http://bootsnipp.com/mouse0270/snippets/PbDb5');
        $('#fullscreen').attr('title', 'Back To Bootsnipp');
    }

    $('#fullscreen').on('click', function(event) {
        event.preventDefault();
        window.parent.location = $('#fullscreen').attr('href');
    });

    $('body').on('swiperight', function(e) {
        document.getElementById('mySidenav').style.width = '250px';
    });
    $('body').on('swiperleft', function(e) {
        document.getElementById('mySidenav').style.width = '0px';
    });

});

function initMap() {
    var umass = {
        lat: 42.391016,
        lng: -72.527137,
    };
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: umass,
    });
    var marker = new google.maps.Marker({
        position: umass,
        map: map,
    });

    //   //Code to create an overaly over the map
    //   var imageBounds = {
    //       north: 42.404583,
    //       south: 42.379333,
    //       east: -72.514917,
    //       west: -72.541361
    //     };
    //
    //     umassOverlay = new google.maps.GroundOverlay(
    //         "images/campusmap.jpg",
    //         imageBounds);
    //     umassOverlay.setMap(map);
}

/* Set the width of the side navigation to 250px */
function openNav() {
    document.getElementById('mySidenav').style.width = '250px';
}
/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById('mySidenav').style.width = '0';
}