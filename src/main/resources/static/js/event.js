/**
 * Created by zsh7040 on 2017-8-24.
 */
var keydownEvent = function (map) {
    var m = map;

    window.addEventListener("keydown", function (event) {

        if (event.key == "p") {
            m.toggleShock();
        }
        if (event.key == "k") {
            m.shock(1);
        }
    })

};
var sContent =
    "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>应急物资</h4>" +
    "<img style='float:right;margin:4px' id='imgDemo' src='../static/img/car.png' width='100' height='70' title='物资'/>" +
    "<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>点击运输物资，可以启动运输工具，进行运输，在运输过程过程中实时展示运输过程中的剩余时间和距离...</p>" +
    "</div>";
var infoWindow = new BMap.InfoWindow(sContent);

var showInfoWindow = function (marker) {
    marker.addEventListener("click", function () {

        this.openInfoWindow(infoWindow);
        //图片加载完毕重绘infowindow
        e('#imgDemo').onload = function () {
            infoWindow.redraw();   //防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏
        }
    });
};

