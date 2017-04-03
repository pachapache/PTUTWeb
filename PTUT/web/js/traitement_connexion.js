$(document).ready(function() {

  $(".texte_identifiant").hide();

  $('#lien_identifiant').click(function() {
    $(".texte_identifiant").slideToggle();
    if ($(this).html()=="J'ai oublié mon identifiant je clique ici"){
      $(this).html("Cacher le texte");
    } else {
      $(this).html("J'ai oublié mon identifiant je clique ici");
    }
  })


});
