$(document).ready(function() {
  console.log("page_chargée");
  $("#inscriptionValide").hide();
  $(".identifiants").hide();
  $("#mdpInvalide").hide();
  $("#dateDeNaissInvalide").hide();


// Bouton valider qui vérifie le formulaire:
$("#formulaire").submit(function(event){
  event.preventDefault();
  console.log("formulaire passe au submit ");
  var val1 = document.getElementById("mdp").value;
  var val2 = document.getElementById("confirmMdp").value;
  //calculate_age(); // appel de la fonciton qui calcule l'âge

  //Compare les mots de passe saisis s'ils sont différents: erreur
  if(val1!==val2) {
    console.log("mot de passe ko");
    $("#mdpInvalide").show("slow").delay(3000).hide("slow");

  }
  // Vérifie que l'age de la personne est possible
  /*else if (18<age<=110){
    console.log("date de naissance incorrecte");
    $("#dateDeNaissInvalide").show("slow").delay(3000).hide("slow");


  }*/
  else{ //Tout va bien l'inscription se fait et on passe à l'écran d'accueil
    console.log("mot de passe ok");
    $("#inscriptionValide").show("slow").delay(3000).hide("slow");
    $(".identifiants").show("slow").delay(3000).hide("slow");
    $("#formulaire").hide();
    var delayAccueil = 3000;
    setTimeout(function(){ window.location.href="page_accueil.html"; }, delayAccueil);
  }

// Calcul l'age de la personne à partir de la date de naissance saisie
// ne marche pas
function calculate_age(){
  var dateNaiss = document.getElementById('ddn').value ;
  var today = new Date();
  var dateNaissYear = dateNaiss.getFullYear();
  var todayYear = today.getFullYear();
  var age = todayYear - dateNaissYear ;
  console.log(dateNaiss);
  console.log(today);
  console.log(dateNaissYear);
  console.log(todayYear);
  console.log(age);
  }

}); // Fin du formulaire.submit

}); // Fin du docuemnt.ready
