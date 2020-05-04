google.charts.load('current', {'packages':['bar']});
google.setOnLoadCallback(function() {
    drawStuff();
});

let svar1 = "";
let svar2 = "";
let svar3 = "";
let svar4 = "";
let svar5 = "";

let pr1 = "";
let pr2 = "";
let pr3 = "";
let pr4 = "";
let pr5 = "";

function getDatoer() {

    var getJSON = function(url, callback) {

        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.responseType = 'json';

        xhr.onload = function() {

            var status = xhr.status;

            if (status == 200) {
                callback(null, xhr.response);
            } else {
                callback(status);
            }
        };

        xhr.send();
    };


    getJSON('hentDiagramDatoer', function(err, data) {

        if (err != null) {
            console.error(err);
        } else {

            svar1 = `${data.dag1}`;
            svar2 = `${data.dag2}`;
            svar3 = `${data.dag3}`;
            svar4 = `${data.dag4}`;
            svar5 = `${data.dag5}`;

        }
    });


    getJSON('hentDiagramProcenter', function(err, data) {

        if (err != null) {
            console.error(err);
        } else {

            pr1 = `${data.p1}`;
            pr2 = `${data.p2}`;
            pr3 = `${data.p3}`;
            pr4 = `${data.p4}`;
            pr5 = `${data.p5}`;

        }
    });


}

getDatoer()

function drawStuff() {

    var data = new google.visualization.arrayToDataTable([
        ['Datoer', 'procent'],
        [svar1, pr1],
        [svar2, pr2],
        [svar3, pr3],
        [svar4, pr4],
        [svar5, pr5]

    ]);

    var options = {
        width: 680,
        legend: {position: 'centre'},
        axes: {
            x: {
                0: {side: 'top'}
            }
        },
        bar: {groupWidth: "90%"}
    };

    var chart = new google.charts.Bar(document.getElementById('top_x_div'));
    chart.draw(data, google.charts.Bar.convertOptions(options));

}



