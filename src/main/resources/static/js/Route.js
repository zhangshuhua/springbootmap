/**
 * Created by zsh7040 on 2017-8-24.
 */
var Route = function (map, endPoint) {

    var map = map;
    var route = {};
    var end = endPoint;


    var lushuOpts = {
        defaultContent: "一方有难，八方支援",
        autoView: false,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整,会出现抖动
        icon: new BMap.Icon('../static/img/car.png', new BMap.Size(52, 26), {anchor: new BMap.Size(27, 13)}),
        speed: 5500,
        enableRotation: true,//是否设置marker随着道路的走向进行旋转
        landmarkPois: [
            // {lng:116.3814,lat:39.9740,html:'肯德基早餐<div></div>',pauseTime:2}
        ]
    };

    route.setStart = function (point) {
        var drv = new BMap.DrivingRoute('北京', {
            onSearchComplete: function (res) {
                if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
                    var arrPois = res.getPlan(0).getRoute(0).getPath();
                    map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));
                    map.setViewport(arrPois);

                    var lushu = new BMapLib.LuShu(map, arrPois, {
                        defaultContent: "从天安门到百度大厦",//"从天安门到百度大厦"
                        autoView: true,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整
                        icon: new BMap.Icon('../static/img/car.png', new BMap.Size(52, 26), {anchor: new BMap.Size(27, 13)}),
                        speed: 4500,
                        enableRotation: true,//是否设置marker随着道路的走向进行旋转
                        landmarkPois: [
                            {lng: 116.314782, lat: 39.913508, html: '加油站', pauseTime: 8},
                            {
                                lng: 116.315391,
                                lat: 39.964429,
                                html: '高速公路收费<div><img src="http://map.baidu.com/img/logo-map.gif"/></div>',
                                pauseTime: 3
                            },
                            {
                                lng: 116.381476,
                                lat: 39.974073,
                                html: '肯德基早餐<div><img src="http://ishouji.baidu.com/resource/images/map/show_pic04.gif"/></div>',
                                pauseTime: 2
                            }
                        ]
                    });
                    window.lushus.push(lushu);
                }

            }, renderOptions: {
                map: map,
                enableDragging: true //起终点可进行拖拽
            },
        });
        drv.search(point, end);
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
                        map.setViewport(arrPois);

                        var lushu = new BMapLib.LuShu(map, arrPois, lushuOpts);
                        window.lushus.push(lushu);
                    }

                }
            });
            drv.search(p, end);
        }
    };


    return route;
};
