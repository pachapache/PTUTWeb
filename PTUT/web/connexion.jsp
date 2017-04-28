<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/traitement_connexion.js"></script>
  <title>E-breath</title>
</head>


<body>

  <nav class="navbar navbar-inverse">
    <h1 align="center"><font color="white">E-Breath</font></h1>
    <h2 align="center"><font color="white">Espace connexion</font></h2>
    <div class="container-fluid">
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="index1.html">Accueil</a></li>
          <li><a href="projet.html">Projet</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li  class="active"><a href="connexion.html">Connexion</a></li>
          <li><a href="inscription.html">S'inscrire</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container" align="center">
    <div class="row" >

      <div id="formulaire" class="col-md-4 col-md-offset-4">
        <form class="connexion" action="Connexion" method="POST">
          <br><br><br>
          <div class="form-group">
            <label>Veuillez saisir votre identifiant</label>
            <input class="form-control" name="identifiant" placeholder="Identifiant" >
            <a href="#" id="lien_identifiant">J'ai oublié mon identifiant ? Je clique ici !</a>
            <div class="texte_identifiant">
              Votre identifiant est votre adresse mail
            </div>
            <br>
            <label>Veuillez saisir votre mot de passe</label>
            <input type="password" class="form-control" name="motDePasse" placeholder="Mot de passe">
            <a href="#" id="lien_identifiant">J'ai oublié mon mot de passe ? Je clique ici !</a>
          </div>

          <div class= "alert alert-danger" id="pbConnexion">
            <b>Identifiant et/ou mot de passe incorrect</b>
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          </div>

          <div class="seCo">
            <button type="submit" class="btn btn-default center-block">
              <span class="glyphicon glyphicon-off" aria-hidden="true"></span> Se connecter
            </button>
          </div>
        </form>

      </div>
    </div>
  </div>


</body>
</html>
