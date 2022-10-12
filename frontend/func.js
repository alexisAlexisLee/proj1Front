var map;

function myMap() {
  var mapProp = {
      center: new google.maps.LatLng(33.775373, -84.396847),
      zoom: 12,
  };
  map = new google.maps.Map(document.getElementById('map'), mapProp);
}


function setup() {
  var inputAddress1 = document.getElementById('latBox').value;
  var inputAddress2 = document.getElementById('lonBox').value;
  var center = new google.maps.LatLng(inputAddress1,inputAddress2);
  var radius = document.getElementById('radBox').value;
  //test if the inputs get read
  //alert("your radius input: " + radius + ", and your coordinate input: " + center);
  var mapProp = {
    center: center,
    zoom: 12,
  };
  map = new google.maps.Map(document.getElementById('map'), mapProp);
  var marker = new google.maps.Marker({
    map: map,
    position: center
  });
}
