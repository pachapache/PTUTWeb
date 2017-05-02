$(document).ready(function() {
    $("#pbConnexion").hide();
    $('.texte_identifiant').hide();


  $('#lien_identifiant').click(function() {
    $(".texte_identifiant").slideToggle();
    if ($(this).html()=="J'ai oublié mon identifiant je clique ici"){
        $(this).html("J'ai oublié mon identifiant je clique ici");
    }
  })
  
});
