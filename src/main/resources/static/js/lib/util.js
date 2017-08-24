/**
 * Created by zsh7040 on 2017-8-24.
 */
function getNewMarkers(max, center) {
    var newMarkers = [];
    //获取center的坐标
    var lng = parseFloat(center.lng);
    var lat = parseFloat(center.lat);
    for (i = 0; i < max; i++) {
        pt = new BMap.Point((2 * (Math.random() - 0.5)) * 0.1 + lng, (2 * (Math.random() - 0.5)) * 0.1 + lat);
        newMarkers.push(new BMap.Marker(pt));
        // console.info(pt);
    }
    return newMarkers;
}


function $(element) {
    return document.getElementById(element);
}