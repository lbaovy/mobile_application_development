$(document).on('click', '#form button', function (e) {
    $url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+ $('#lat').val() +","+ $('#lon').val() +"&key=AIzaSyB1nZ_vxMM1a1gx_-tA6lvtYF7f6CWkNew";
    $.getJSON($url).done(function(data) {
        $('#result').html(data['results'][0]['formatted_address']);
    })
})