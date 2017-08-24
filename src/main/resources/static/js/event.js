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

