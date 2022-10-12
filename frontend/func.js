var map;
var geocoder;
//var Ireland = "Dublin";

function myMap() {
    //geocoder = new google.maps.Geocoder();
    var mapProp = {
        center: new google.maps.LatLng(33.775373, -84.396847),
        zoom: 12,
    };
    map = new google.maps.Map(document.getElementById('map'), mapProp);
    //setup();
    //codeAddress(Ireland);
}


function setup() {
    var inputAddress1 = document.getElementById('latBox').value;
    var inputAddress2 = document.getElementById('lonBox').value;
    var center = new google.maps.LatLng(inputAddress1,inputAddress2);
    var radius = document.getElementById('radBox').value;
    //test if the inputs get read
    //alert("your radius input: " + radius);
    //alert("your coordinate input: " + center);
    var circle = new google.maps.CircleLiteral({
        center: center,
        radius: radius
    });
    codeAddress(center);
}

/*
function codeAddress() {
    var address = document.getElementById('latBox').value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == 'OK') {
        map.setCenter(results[0].geometry.location);
        var gmarker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
  */

  /*
  function codeAddress(address1,address2) {
        map.setCenter({lat: address1, lng: address2}); //center the map over the result
        //place a marker at the location
        var marker = new google.maps.Marker({
          map: map,
          position: {lat: address1, lng: address2}
        });
  }
  */


  function codeAddress(center) {
        map.setCenter(center); //center the map over the result
        //place a marker at the location
        var marker = new google.maps.Marker({
          map: map,
          position: center
        });
  }


  // 1. passing in lat, long
  // 2. func, lat, long, pin, store var
  // 3. goole map -> rest.distance : 1. distance < radius
  // 4, 