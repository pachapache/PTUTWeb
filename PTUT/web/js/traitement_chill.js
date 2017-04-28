$(document).ready(function(){

  document.getElementById('BreatheWithTheShape').src = "./img/BreatheWithTheShape" + Math.round(Math.random()*4+1) + ".gif";
  console.log("hey");

//easter egg enjoy 
  cheet('↑ ↑ ↓ ↓ ← → ← → b a', function () {
    alert('Voilà!');
  });

});
