$(document).ready(function () {
    $("#inscriptionValide").hide();
    $(".identifiants").hide();
    $("#mdpInvalide").hide();
    $("#adrInvalide").hide();

var form = document.getElementById("formulaire");
form.addEventListener("focus", function( event ) {    
    var mdp1 = $("#mdp").val();
    var mdp2 = $("#confirmMdp").val();
    var adr1 = $("#mail").val();
    var adr2 = $("#confirmMail").val();
    //Compare les mots de passes et adresses mails, si différents : erreur
    if (mdp1 === mdp2 & adr1 === adr2 & mdp1 !== null & mdp2 !== null & adr1 !== null & adr2 !== null) {
        console.log("mot de passe et adresse ok");
        //$("#inscriptionValide").show("slow").delay(3000).hide("slow");
        //$(".identifiants").show("slow").delay(3000).hide("slow");
        //$("#formulaire").hide();
        //$("#adrInvalide").hide();
        //$("#mdpInvalide").hide();
        } else {
            if (mdp1 === mdp2 & adr1 !== adr2 & mdp1 !== null & mdp2 !== null & adr1 !== null & adr2 !== null) {
            console.log("mails ko");
            $("#mdpInvalide").hide();
            $("#adrInvalide").show("slow");
            } else {
                if (mdp1 !== mdp2 & adr1 !== adr2 & mdp1 !== null & mdp2 !== null & adr1 !== null & adr2 !== null) {
                console.log("mails et mdp ko");
                $("#adrInvalide").show("slow");
                $("#mdpInvalide").show("slow");
                } else {
                    if (mdp1 !== mdp2 & adr1 === adr2 & mdp1 !== null & mdp2 !== null & adr1 !== null & adr2 !== null){
                    $("#adrInvalide").hide();
                    $("#mdpInvalide").show("slow");                  
                    }}}}
} ,true );
})



// Bouton valider qui vérifie le formulaire:
 //   $("#formulaire").submit(function (event) {
   //     event.preventDefault();
      



// Vérifie que l'age de la personne est possible
/*else if (18<age<=110){
 console.log("date de naissance incorrecte");
 $("#dateDeNaissInvalide").show("slow").delay(3000).hide("slow");
 
 
 }*/
//Tout va bien l'inscription se fait et on passe à l'écran d'accueil

//setTimeout(function(){ window.location.href="page_accueil.html"; }, delayAccueil);
// };

//}
//}
//   }); // Fin du formulaire.submit

// }); // Fin du docuemnt.ready
