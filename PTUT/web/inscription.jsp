<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/traitement_inscription.js"></script>
  <title>E-breath</title>
</head>

<body>

  <!-- Barre de menus -->
  <nav class="navbar navbar-inverse">
    <h1 align="center"><font color="white">E-Breath</font></h1>
    <div class="container-fluid">
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="Accueil">Accueil</a></li>
          <li><a href="Projet">Projet</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="Connexion">Connexion</a></li>
          <li class="active"><a href="Inscription">S'inscrire</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class ="row">
      <div class="col-xs-8 col-xs-offset-2" >
        <form class="form-horizontal" id="formulaire" role="form" action="traitementInscription" method="POST">
          <div class="form-group">
            <h2 align="center">Vos informations personnelles</h2><br>
            <label>Veuillez saisir votre nom</label>
            <input type="texte" class="form-control" name="nom" placeholder="Nom" required="">
            <br><br>
            <label>Veuillez saisir votre prénom</label>
            <input type="texte" class="form-control" name="prenom" placeholder="Prenom" required="">
            <br><br>
            <label>Veuillez saisir votre sexe</label>
            <div class="checkbox">
              <label><input type="radio" name="sexe" required=""> Homme </label>
              <label><input type="radio" name="sexe" required=""> Femme </label>
            </div>
            <br><br>
            <label>Veuillez saisir votre date de naissance</label>
            <input type="date" class="form-control" name="ddn" placeholder="DateDeNaissance" max="2000-01-01" min="1900-12-31" required="">
            <br><br>
            <label>Veuillez saisir votre poids</label>
            <input type="number" class="form-control" name="poids" placeholder="Poids" min="30" max="150" required="">
            <br><br>
            <label>Etes vous sportif ?</label>
            <label><input type="radio" name="sportif" required=""> Oui </label>
            <label><input type="radio" name="sportif" required=""> Non </label>
            <ol class="breadcrumb"></ol>
            <h2  align="center">Création de votre compte</h2><br>
            <label>Veuillez saisir votre adresse mail</label>
            <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="mail" id="mail" placeholder="Mail" required="">
            <br><br>
            <label>Veuillez confirmer votre adresse mail</label>
            <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="confirmMail" id="confirmMail" placeholder="Retaper votre mail" required="">
            <br><br>
            <label>Veuillez saisir un mot de passe</label>
            <input type="password"  class="form-control" name="mdp" id="mdp" placeholder="Mot de passe" required="">
            <br><br>
            <label>Veuillez confirmer votre mot de passe</label>
            <input type="password" class="form-control" name="confirmMdp" id="confirmMdp" placeholder="Retaper votre mot de passe" required="">
          </div>
          <br>
          <div class="container">
            <div class ="row">
              <div class="col-xs-12">
                <div class= "alert alert-danger" id="mdpInvalide">
                  <b>Attention!</b> Vos mots de passe sont différents !
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                </div>
              </div>
            </div>
          </div>

          <div class="container">
            <div class ="row">
              <div class="col-xs-12">
                <div class= "alert alert-danger" id="adrInvalide">
                  <b>Attention!</b> Les adresses mails saisies sont différentes !
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                </div>
              </div>
            </div>
          </div><br>

          <div class="form-group">
            <div class="valider">
              <button class="btn btn-default center-block" type="submit">
                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Valider
              </button>
              <br><br><br><br>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

${error}
</body>

<footer align="center">
  Copyright© 2017 - Team E-Breath - Tous droits réservés.
</footer>

</html>
