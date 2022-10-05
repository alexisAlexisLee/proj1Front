function myMap() {
    var mapProp = {
        center: new google.maps.LatLng(51.508742, -0.120850),
        zoom: 8,
    };
    var map = new google.maps.Map(document.getElementById('map'), mapProp);
    var maker = new google.map.Maker({
        position: { lat: 51.508742, lat: -0.120850 },
        map: map
    });
}