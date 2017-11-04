function initMap() {
  var umass = {lat: 42.391016, lng: -72.527137};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 15,
    center: umass
  });
  var marker = new google.maps.Marker({
    position: umass,
    map: map
  });

  /* Code to create an overaly over the map
  var imageBounds = {
      north: 42.404583,
      south: 42.379333,
      east: -72.514917,
      west: -72.541361
    };

    umassOverlay = new google.maps.GroundOverlay(
        "images/campusmap.jpg",
        imageBounds);
    umassOverlay.setMap(map);
    */
}
