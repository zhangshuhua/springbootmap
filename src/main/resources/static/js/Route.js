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
        speed: 5000,
        enableRotation: true,//是否设置marker随着道路的走向进行旋转
        landmarkPois: [],
        totalDuration: 2000,
        totalDistance: 10000,
        endContent: "到达灾区",
    };

    var waypoints = {
        'waypoints': [],
    };

    route.addLandPoi = function (point, title, pauseTime) {
        var poi = {
            'lng': point.lng,
            'lat': point.lat,
            'html': title || "休息中",
            'pauseTime': pauseTime || 2,
        };
        lushuOpts.landmarkPois.push(poi);
        waypoints.waypoints.push(point);
        return this;
    };

    route.getAllArrPois = function (plan, waypoints) {
        var routes = plan.dk;
        var allArrPois = [];
        for (var i = 0; i < routes.length; i++) {
            var pois = plan.getRoute(i).getPath();
            if (waypoints && waypoints[i]) {
                console.log(`waypoints[${i}]`, waypoints[i]);
                pois[pois.length - 1].lng = waypoints[i].lng;
                pois[pois.length - 1].lat = waypoints[i].lat;
            }
            allArrPois = allArrPois.concat(pois);
        }
        return allArrPois;
    };


    route.setStart = function (point) {
        var self = this;
        var driving = new BMap.DrivingRoute(map, {
            onSearchComplete: function (res) {
                if (driving.getStatus() == BMAP_STATUS_SUCCESS) {
                    //途径一个点的话，有两个route
                    var plan = res.getPlan(0);

                    var arrPois = self.getAllArrPois(plan, waypoints.waypoints);

                    map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));

                    var lushu = new BMapLib.LuShu(map, arrPois, lushuOpts);
                    window.lushus.push(lushu);
                }

            },
        });
        driving.search(point, end, waypoints);//waypoints表示途经点
        return driving;
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
