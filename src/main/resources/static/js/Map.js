/**
 * Created by zsh7040 on 2017-8-24.
 */
var Map = function (container) {
    var map = new BMap.Map(container);


    var isShock = true;

    map.toggleShock = function () {
        isShock = !isShock;
        this.shock(5);
    };

    var shockLevel = 5;

    //time震动时间
    map.shock = function (time) {
        var t = time;
        if (isShock && t > 0) {
            t -= 1 / shockLevel;
            map.panTo(new BMap.Point(116.404, 39.915));
            window.setTimeout(function () {
                map.panTo(new BMap.Point(116.403, 39.914));
                map.shock(t);
            }, 1000 / shockLevel);
        }
    };

    map.addRandomMarkes = function (max, center) {
        let markers = getNewMarkers(max);
    };

    map.addRichMark = function (point, img) {
        var htm1 = "<div id='overLay' style='width:50px;height:75px;background:url(../static/img/markBg.png) left top no-repeat; position: absolute;'>"
                + "<img style='margin-left:2px;margin-top: 2px;width: 41px;height: 41px' src='../static/img/small.jpg' />"
                + "</div>",
            myRichMarker1 = new BMapLib.RichMarker(htm1, point, {
                "anchor": new BMap.Size(-25, -60),
                "enableDragging": true
            });
        map.addOverlay(myRichMarker1);
    };

    map.addOverlays = function (overlays) {
        for (i = 0; i < overlays.length; i++) {
            map.addOverlay(overlays[i])
        }
    };


    return map;
};

