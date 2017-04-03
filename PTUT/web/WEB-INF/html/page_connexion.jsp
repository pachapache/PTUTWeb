<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/npm.js"></script>
    <script type="text/javascript" src="../js/traitement_connexion.js"></script>


    <title>E-breath</title>

  </head>

  <body>
  <div class="container">
	<div class="jumbotron"><h1>E-breath</h1></div>
	<div class="row">

  <div id="formulaire" class="col-md-9">
  	<ol class="breadcrumb"></ol>
    <form class="connexion" action="traitement_connexion.js" method="post">
      <div class="form-group">
        <label for="identifiant">Veuillez saisir votre identifiant</label>
        <input type="identifiant" class="form-control" id="identifiant" placeholder="Identifiant">
        <a href="#" id="lien_identifiant">J'ai oublié mon identifiant je clique ici</a>
        <div class="texte_identifiant">
          Votre identifiant est votre adresse mail
        </div>
      </div>
      <div class="form-group">
        <label for="motDePasse">Veuillez saisir votre mot de passe</label>
        <input type="password" class="form-control" id="motDePasse" placeholder="motDePasse">
        <a href="#" id="lien_identifiant">J'ai oublié mon mot de passe je clique ici</a>
      </div>
    </form>
    <div class="seCo">
      <button type="button" class="btn btn-primary" value="page_accueil" onclick="self.location.href='page_accueil.html'">
      <span class="glyphicon glyphicon-off" aria-hidden="true"></span> Se connecter
      </button>
    </div>
  </div>

  <div class="inscription">
    Pas encore de compte je m'inscris
    <br/>
    <button type="button" class="btn btn-primary" value="form_inscription" onclick="self.location.href='form_inscription.html'">
    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> S'inscrire
    </button>
  </div>

  </div>
  </div>
  </body>
</html>