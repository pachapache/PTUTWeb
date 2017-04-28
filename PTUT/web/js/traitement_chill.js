$(document).ready(function(){
  function randomGif(){
    document.getElementById('BreatheWithTheShape').src = "./img/BreatheWithTheShape" + Math.round(Math.random()*4+1) + ".gif";
  }
}
