$(document).ready(function () {
    $("#quotidien").show();
    $("#hebdomadaire").hide();
    $("#mensuel").hide();
    $("#annuel").hide();

    $('#q').click(function () {
        $("#quotidien").show();
        $("#hebdomadaire").hide();
        $("#mensuel").hide();
        $("#annuel").hide();
    })

    $('#h').click(function () {
        $("#quotidien").hide();
        $("#hebdomadaire").show();
        $("#mensuel").hide();
        $("#annuel").hide();
    })

    $('#m').click(function () {
        $("#quotidien").hide();
        $("#hebdomadaire").hide();
        $("#mensuel").show();
        $("#annuel").hide();
    })

    $('#a').click(function () {
        $("#quotidien").hide();
        $("#hebdomadaire").hide();
        $("#mensuel").hide();
        $("#annuel").show();
    })


    //JSON pour historique
    $.getJSON('./Output.json', function (data) {
        c1 = null;
        c2 = null;
        c3 = null;
        c4 = null;
        c5 = null;
        c6 = null;
        c7 = null;
        c8 = null;
        c9 = null;
        c10 = null;
        c11 = null;
        c12 = null;
        lundi = null;
        mardi = null;
        mercredi = null;
        jeudi = null;
        vendredi = null;
        samedi = null;
        dimanche = null;
        janvier = null;
        fevrier = null;
        mars = null;
        avril = null;
        mai = null;
        juin = null;
        juillet = null;
        aout = null;
        septembre = null;
        octobre = null;
        novembre = null;
        decembre = null;
        y2015 = null;
        y2016 = null;
        y2017 = null;
        $.each(data, function (key, val) {
            if (key === "h0" || key === "h1") {
                c1 = val + c1;
            }
            if (key === "h2" || key === "h3") {
                c2 = val + c2;
            }
            if (key === "h4" || key === "h5") {
                c3 = val + c3;
            }
            if (key === "h6" || key === "h7") {
                c4 = val + c4;
            }
            if (key === "h8" || key === "h9") {
                c5 = val + c5;
            }
            if (key === "h10" || key === "h11") {
                c6 = val + c6;
            }
            if (key === "h12" || key === "h13") {
                c7 = val + c7;
            }
            if (key === "h14" || key === "h15") {
                c8 = val + c8;
            }
            if (key === "h16" || key === "h17") {
                c9 = val + c9;
            }
            if (key === "h18" || key === "h19") {
                c10 = val + c10;
            }
            if (key === "h20" || key === "h21") {
                c11 = val + c11;
            }
            if (key === "h22" || key === "h23") {
                c12 = val + c12;
            }
            if (key === "j2") {
                lundi = val;
            }
            if (key === "j3") {
                mardi = val;
            }
            if (key === "j4") {
                mercredi = val;
            }
            if (key === "j5") {
                jeudi = val;
            }
            if (key === "j6") {
                vendredi = val;
            }
            if (key === "j7") {
                samedi = val;
            }
            if (key === "j1") {
                dimanche = val;
            }
            if (key === "m1") {
                janvier = val;
            }
            if (key === "m2") {
                fevrier = val;
            }
            if (key === "m3") {
                mars = val;
            }
            if (key === "m4") {
                avril = val;
            }
            if (key === "m5") {
                mai = val;
            }
            if (key === "m6") {
                juin = val;
            }
            if (key === "m7") {
                juillet = val;
            }
            if (key === "m8") {
                aout = val;
            }
            if (key === "m9") {
                septembre = val;
            }
            if (key === "m10") {
                octobre = val;
            }
            if (key === "m11") {
                novembre = val;
            }
            if (key === "m12") {
                decembre = val;
            }
            if (key === "a2015") {
                y2015 = val;
            }
            if (key === "a2016") {
                y2016 = val;
            }
            if (key === "a2017") {
                y2017 = val;
            }
        });
    });

    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        // Affiche le graphique quotidien
        var data = google.visualization.arrayToDataTable([
            ['Heure', 'Fréquence respiratoire'],
            ['00h00', c1],
            ['02h00', c2],
            ['04h00', c3],
            ['06h00', c4],
            ['08h00', c5],
            ['10h00', c6],
            ['12h00', c7],
            ['14h00', c8],
            ['16h00', c9],
            ['18h00', c10],
            ['20h00', c11],
            ['22h00', c12],
        ]);
        var options = {
            title: 'Ma fréquence respiratoire quotidienne',
            curveType: 'function',
            legend: {position: 'bottom'},
            width: 1200,
            height: 500
        };
        var chart = new google.visualization.LineChart(document.getElementById('quotidien'));
        chart.draw(data, options);

        //Affcihe le graphique hebdomadaire
        var data = google.visualization.arrayToDataTable([
            // Prend la fréquence moyenne/jour
            ['Jour', 'Fréquence respiratoire'],
            ['Lundi', lundi],
            ['Mardi', mardi],
            ['Mercredi', mercredi],
            ['Jeudi', jeudi],
            ['Vendredi', vendredi],
            ['Samedi', samedi],
            ['Dimanche', dimanche]
        ]);
        var options = {
            title: 'Ma fréquence respiratoire hebdomadaire',
            curveType: 'function',
            legend: {position: 'bottom'},
            width: 1200,
            height: 500
        };
        var chart = new google.visualization.LineChart(document.getElementById('hebdomadaire'));
        chart.draw(data, options);

        //Affcihe le graphique mensuel
        var data = google.visualization.arrayToDataTable([
            // Prend la fréquence moyenne/jour
            ['Mois', 'Fréquence respiratoire'],
            ['Janvier', janvier],
            ['Février', fevrier],
            ['Mars', mars],
            ['Avril', avril],
            ['Mai', mai],
            ['Juin', juin],
            ['Juillet', juillet],
            ['Aout', aout],
            ['Septembre', septembre],
            ['Octobre', octobre],
            ['Novembre', novembre],
            ['Décembre', decembre]
        ]);
        var options = {
            title: 'Ma fréquence respiratoire mensuelle',
            curveType: 'function',
            legend: {position: 'bottom'},
            width: 1200,
            height: 500
        };
        var chart = new google.visualization.LineChart(document.getElementById('mensuel'));
        chart.draw(data, options);

        //Affcihe le graphique annuel
        var data = google.visualization.arrayToDataTable([
            // Prend la fréquence moyenne/jour
            ['Annee', 'Fréquence respiratoire'],
            ['2015', y2015],
            ['2016', y2017],
            ['2017', y2017]
        ]);
        var options = {
            title: 'Ma fréquence respiratoire annuelle',
            curveType: 'function',
            legend: {position: 'bottom'},
            width: 1200,
            height: 500
        };
        var chart = new google.visualization.LineChart(document.getElementById('annuel'));
        chart.draw(data, options);


    }


});
