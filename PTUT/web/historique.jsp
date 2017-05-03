<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="./js/traitement_historique.js"></script>
  <title>E-breath</title>
</head>
<body>

  <!-- Barre de menus -->
  <nav class="navbar navbar-inverse">
    <h1 align="center"><font color="white">E-Breath</font></h1>
    <h2 align="center"><font color="white">${ sessionScope.nom } ${ sessionScope.prenom}</font></h2>
    <div class="container-fluid">
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="Accueil">Accueil</a></li>
          <li><a href="Projet">Projet</a></li>
          <li><a href="Frequence">Ma fréquence actuelle</a></li>
          <li class="active"><a href="Historique">Historique</a></li>
          <li><a href="Jeux">Jeux de respiration</a></li>
          <li><a href="Param">Paramètres du compte</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
           <li><a href="Deconnexion">Se deconnecter</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Statistiques -->
  <h3>Mes statistiques</h3><br><br>
  <div class="container">
    <div class ="row">
      <div class="col-md-12" >
        <div id="choix" class="btn-group btn-group-lg center-block" role="group" aria-label="...">
          <button id="q" type="button" class="btn btn-default">Quotidien</button>
          <button id="h"type="button" class="btn btn-default">Hebdomadaire</button>
          <button id="m" type="button" class="btn btn-default">Mensuel</button>
          <button id="a" type="button" class="btn btn-default">Annuel</button>
        </div>
      </div>

      <div class="col-xs-12" >
        <div class = "stat" id="quotidien" style="width: 300px; height: 500px"></div>
        <div class = "stat" id="hebdomadaire" style="width: 300px; height: 500px"></div>
        <div class = "stat" id="mensuel" style="width: 300px; height: 500px"></div>
        <div class = "stat" id="annuel" style="width: 300px; height: 500px"></div>
        <p>
          <h4>Ma moyenne: ${moyenne}</h4>
          <h4>Mon écart type: ${ecart}</h4>
          <h4>Ma fréquence min : ${min}</h4>
          <h4>Ma fréquence max : ${max}</h4>
        </p>

      </div>
    </div>
  </div>

</div>
</div>
</div>
<br><br>

</body>
<footer align="center">
  Copyright 2017 - Team E-Breath - Tous droits réservés.
</footer>
</html>
