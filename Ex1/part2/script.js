$(document).on('click', '#form button', function (e) {
    $.ajax({
        url: "calculate.php",
        type: "POST",
        data: {lat1: $('#lat1').val(), lat2: $('#lat2').val(), lon1: $('#lon1').val(), lon2: $('#lon2').val()}
    }).done(function(data) {
        $('#result').html(data);
    })
})