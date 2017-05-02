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
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="./js/traitement_param.js"></script>
  <title>E-breath</title>
</head>

<body>

  <!-- Barre de menus -->
  <nav class="navbar navbar-inverse">
    <h1 align="center"><font color="white">E-Breath</font></h1>
    <h2 align="center"><font color="white">${sessionScope.nom} ${sessionScope.prenom} </font></h2>
    <div class="container-fluid">
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="Accueil">Accueil</a></li>
          <li><a href="Projet">Projet</a></li>
          <li><a href="Frequence">Ma fréquence actuelle</a></li>
          <li><a href="Historique">Historique</a></li>
          <li><a href="Jeux">Jeux de respiration</a></li>
          <li class="active"><a href="Param">Paramètres du compte</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="Deconnexion">Se deconnecter</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Formulaire -->
  <div class="container">
    <div class ="row">
      <div class="col-xs-8 col-xs-offset-2" >
        <form class="form-horizontal" id="formulaire" role="form " action="traitementParam" method="POST">
          <h2 align="center">Vos informations personnelles</h2><br>
          <label>Votre nom</label>
          <input type="texte" class="form-control" id="nom" value='${sessionScope.nom}' disabled="disabled">
          <br><br>
          <label>Votre prénom</label>
          <input type="texte" class="form-control" id="prenom" value='${sessionScope.prenom}' disabled="disabled">
          <br/></br/>
          <label>Votre sexe</label>
          <div class="checkbox">
            <label><input type="radio" name="sexe" disabled="disabled" ${sexe1}> Homme </label>
            <label><input type="radio" name="sexe" disabled="disabled" ${sexe2}> Femme </label>
          </div>
          <br><br>
          <label>Votre date de naissance</label>
          <input type="date" class="form-control" name="ddn" value='${sessionScope.date_naissance}' disabled="disabled">
          <br><br>
          <label>Votre poids</label>
          <input type="number" class="form-control" value='${sessionScope.poids}' name="poids" placeholder="Poids" min="30" max="150" required="">
          <br><br>
          <label>Etes vous sportif ?</label>
          <label><input type="radio" name="sportif" required="" ${sport1}> Oui </label>
          <label><input type="radio" name="sportif" required="" ${sport2}> Non </label>
          <br><br><br><br>
          <ol class="breadcrumb"></ol>
          <h2 align="center">Modification de vos accès</h2>
          <h3>Adresse mail</h3>
          <label>Veuillez saisir votre adresse mail</label>
          <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="ancienMail" id="ancienMail" required="">
          <br><br>
          <label>Veuillez saisir votre nouvelle adresse mail</label>
          <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="mail" id="mail"  required="">
          <br><br>
          <label>Veuillez confirmer votre nouvelle adresse mail</label>
          <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="newMail" id="newMail" required="">
          <br>
          <h3>Mot de passe</h3>
          <label>Veuillez saisir votre mot de passe</label>
          <input type="password"  class="form-control" name="ancienMdp" id="ancienMdp" required="">
          <br></br>
          <label>Veuillez saisir votre nouveau mot de passe</label>
          <input type="password"  class="form-control" name="mdp" id="mdp" required="">
          <br><br>
          <label>Veuillez confirmer votre mot de passe</label>
          <input type="password" class="form-control" name="newMdp" id="newMdp" required="">
        </div>
      </div>
      <br><br>

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

      <div class="valider">
        <button class="btn btn-default center-block" type="submit">
          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Modifier
        </button>
      </div>
    </form>
  </div>

</body>

<footer align="center">
  Copyright 2017 - Team E-Breath - Tous droits réservés.
</footer>
</html>
