<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Max-Age: 3600");
    header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
    
    $lat1 = floatval($_POST['lat1']);
    $lon1 = floatval($_POST['lon1']);
    $lat2 = floatval($_POST['lat2']);
    $lon2 = floatval($_POST['lon2']);

    $earthRadiusKm = 6371;

    $dLat = deg2rad($lat2 - $lat1);
    $dLon = deg2rad($lon2 - $lon1);

    $a = sin($dLat/2) * sin($dLat/2) + sin($dLon/2) * sin($dLon/2) * cos(deg2rad($lat1)) * cos(deg2rad($lat2));
    $c = 2 * atan2(sqrt($a), sqrt(1-$a));

    echo $earthRadiusKm * $c;
?>