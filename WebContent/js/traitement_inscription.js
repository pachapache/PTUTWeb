$(document).ready(function() {
  $("#inscriptionValide").hide();
  $(".identifiants").hide();

$("#formulaire").submit(function(event){
  console.log("coucou");
  console.log($("#mdp").val());
  var val1 = $("#mdp").val();
  var val2 = $("#confirmMdp").val();
  if(val1==val2) {
    console.log("mot de passe ok");
    $("#inscriptionValide").show("slow").delay(3000).hide("slow");
    $(".identifiants").show("slow").delay(3000).hide("slow");
    $("#formulaire").hide();
  }
  else if(val1!=val2){
    console.log("mot de passe ko");
  }

});

/*
$("#ddn").date({
       autoclose: true,
       todayBtn: true,
       startDate: "01/01/1917",
       minuteStep: 10
   });*/

});
