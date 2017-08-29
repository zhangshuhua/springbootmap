/**
 * Created by zsh7040 on 2017-8-24.
 */
var Route = function (map, endPoint) {

    var map = map;
    var route = {};
    var end = endPoint;


    var lushuOpts = {
        defaultContent: "一方有难，八方支援",
        // autoView: false,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整,会出现抖动
        icon: new BMap.Icon('../static/img/car.png', new BMap.Size(52, 26), {anchor: new BMap.Size(27, 13)}),
        speed: 100,
        enableRotation: true,//是否设置marker随着道路的走向进行旋转
        landmarkPois: [
            // {lng:116.3814,lat:39.9740,html:'肯德基早餐<div></div>',pauseTime:2}
        ]
    };

    var waypoints = {
        'waypoints': [],
    };

    var shockPoint = new BMap.Point(116.404, 39.915);
    route.addLandPois = function (point, title, pauseTime) {
        var poi = {
            'lng': point.lng,
            'lat': point.lat,
            'html': "早餐",
            'pauseTime': pauseTime,
        };
        lushuOpts.landmarkPois.push(poi);
        // waypoints.waypoints.push(point);
    };


    route.setStart = function (point) {
        var drv = new BMap.DrivingRoute(map, {
            onSearchComplete: function (res) {
                if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
                    var arrPois = res.getPlan(0).getRoute(0).getPath();

                    console.info(arrPois);
                    map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));
                    // map.setViewport(arrPois);

                    var lushu = new BMapLib.LuShu(map, arrPois, lushuOpts);
                    window.lushus.push(lushu);
                }

            }
        });
        drv.disableAutoViewport();
        drv.search(point, end, waypoints);
        return drv;
    };

    route.setStarts = function (points) {
        for (let i = 0; i < points.length; i++) {
            let p = points[i];
            let drv = new BMap.DrivingRoute(map, {
                onSearchComplete: function (res) {
                    if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
                        let arrPois = res.getPlan(0).getRoute(0).getPath();
                        map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));
                        // map.setViewport(arrPois);

                        var lushu = new BMapLib.LuShu(map, arrPois, lushuOpts);
                        window.lushus.push(lushu);
                    }

                },
                renderOptions: {
                    map: map,
                    enableDragging: true //起终点可进行拖拽
                },
            });

            drv.search(p, end);
            drv.disableAutoViewport()
        }
    };


    return route;
};
