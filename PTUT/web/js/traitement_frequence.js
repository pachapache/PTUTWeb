$(document).ready(function(){
var timerIn = 200;
var timerOut = 200;
var myFqRespiratoire =  12;

$('ul.nav li.dropdown').hover(function() {
    $(this).find('> .dropdown-menu').stop(true, true).fadeIn(timerIn);
    $(this).addClass('open');
}, function() {
    $(this).find('> .dropdown-menu').stop(true, true).fadeOut(timerOut);
    $(this).removeClass('open');
});

google.charts.load('current', {'packages':['gauge']});
     google.charts.setOnLoadCallback(drawChart);

     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['Label', 'Value'],
         ['Fq Respiratoire', myFqRespiratoire],
       ]);
       var options = {
          width: 500, height: 440,
          greenFrom:12, greenTo:18,
          redFrom: 18, redTo: 20,
          max: 20,
          min:5,
          minorTicks: 5
        };
       var chart = new google.visualization.Gauge(document.getElementById('chart_div'));
       chart.draw(data, options);

       /*setInterval(function() { // temps d'interval entre chaque
       data.setValue(Math.floor((Math.random()*25)+1);
         chart.draw(data, options);
     }, 13000);*/
     }
});
