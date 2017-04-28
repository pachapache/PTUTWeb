$(document).ready(function(){
  $("#quotidien").show();
  $("#hebdomadaire").hide();
  $("#mensuel").hide();
  $("#annuel").hide();

  $('#q').click(function() {
    $("#quotidien").show();
    $("#hebdomadaire").hide();
    $("#mensuel").hide();
    $("#annuel").hide();
  })

  $('#h').click(function() {
    $("#quotidien").hide();
    $("#hebdomadaire").show();
    $("#mensuel").hide();
    $("#annuel").hide();
  })

  $('#m').click(function() {
    $("#quotidien").hide();
    $("#hebdomadaire").hide();
    $("#mensuel").show();
    $("#annuel").hide();
  })

  $('#a').click(function() {
    $("#quotidien").hide();
    $("#hebdomadaire").hide();
    $("#mensuel").hide();
    $("#annuel").show();
  })

  google.charts.load('current', {'packages':['corechart']});
       google.charts.setOnLoadCallback(drawChart);

       function drawChart() {

         // Affiche le graphique quotidien
         var data = google.visualization.arrayToDataTable([
           // il faut devenir les intervalles à laquelle on prend la fréquence respiratoire
           ['Heure', 'Fréquence respiratoire'],
           ['00h00',  12],
           ['01h00',  10],
           ['02h00',   9 ],
           ['03h00',   9 ],
           ['04h00',   9 ],
           ['05h00',   9 ],
           ['07h00',   9 ],
           ['06h00',  12]
         ]);
         var options = {
           title: 'Ma fréquence respiratoire quotidienne',
           curveType: 'function',
           legend: { position: 'bottom' },
           width:1500,
           height:500
         };
         var chart = new google.visualization.LineChart(document.getElementById('quotidien'));
        chart.draw(data, options);

        //Affcihe le graphique hebdomadaire
         var data = google.visualization.arrayToDataTable([
           // Prend la fréquence moyenne/jour
           ['Jour', 'Fréquence respiratoire'],
           ['Lundi',  12],
           ['Mardi',  10],
           ['Mercredi',   9 ],
           ['Jeudi',   13 ],
           ['Vendredi',   12 ],
           ['Samedi',   14 ],
           ['Dimanche',  12]
         ]);
         var options = {
           title: 'Ma fréquence respiratoire hebdomadaire',
           curveType: 'function',
           legend: { position: 'bottom' },
           width:1500,
           height:500
         };
         var chart = new google.visualization.LineChart(document.getElementById('hebdomadaire'));
        chart.draw(data, options);

        //Affcihe le graphique mensuel
         var data = google.visualization.arrayToDataTable([
           // Prend la fréquence moyenne/jour
           ['Mois', 'Fréquence respiratoire'],
           ['Janvier',  12],
           ['Février',  10],
           ['Mars',   9 ],
           ['Avril',   13 ],
           ['Mai',   12 ],
           ['Juin',   14 ],
           ['Juillet',  12],
           ['Aout',  12],
           ['Septembre',  12],
           ['Octobre',  12],
           ['Novembre',  12],
           ['Décembre',  12]
         ]);
         var options = {
           title: 'Ma fréquence respiratoire mensuelle',
           curveType: 'function',
           legend: { position: 'bottom' },
           width:1500,
           height:500
         };
         var chart = new google.visualization.LineChart(document.getElementById('mensuel'));
        chart.draw(data, options);

        //Affcihe le graphique annuel
         var data = google.visualization.arrayToDataTable([
           // Prend la fréquence moyenne/jour
           ['Annee', 'Fréquence respiratoire'],
           ['2016',  12],
           ['2017',  10],
           ['2018',   14 ]
         ]);
         var options = {
           title: 'Ma fréquence respiratoire annuelle',
           curveType: 'function',
           legend: { position: 'bottom' },
           width:1500,
           height:500
         };
         var chart = new google.visualization.LineChart(document.getElementById('annuel'));
        chart.draw(data, options);


       }


});
