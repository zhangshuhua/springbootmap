/**
 * Created by zsh7040 on 2017-8-24.
 */
function getNewMarkers(max, center) {
    var newMarkers = [];
    var newPoints = getNewPoints(max, center);
    //获取center的坐标
    for (var p of newPoints) {
        newMarkers.push(new BMap.Marker(p));
    }
    return newMarkers;
}

function getNewMarkers(points) {
    var newMarkers = [];
    //获取center的坐标
    for (var p of points) {
        newMarkers.push(new BMap.Marker(p));
    }
    return newMarkers;
}


function getNewPoints(max, center) {
    var newPoints = [];
    //获取center的坐标
    var lng = parseFloat(center.lng);
    var lat = parseFloat(center.lat);
    for (i = 0; i < max; i++) {
        //获取周边poi点
        pt = new BMap.Point((2 * (Math.random() - 0.5)) * 0.1 + lng, (2 * (Math.random() - 0.5)) * 0.1 + lat);
        newPoints.push(pt);
        // console.info(pt);
    }
    return newPoints;
}

function e(element) {
    return document.querySelector(element)
}

function showInfo(e) {
    alert(e.point.lng + ", " + e.point.lat);
}