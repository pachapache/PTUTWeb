<!DOCTYPE html>

<html>

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/traitement_chill.js"></script>
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
          <li><a href="Historique">Historique</a></li>
          <li class="active"><a href="Jeux">Jeux de respiration</a></li>
          <li><a href="Param">Paramètres du compte</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        <li><a href="Deconnexion">Se deconnecter</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Exercice de relaxation -->
  <div class="container">
    <div class ="row">
      <div class="col-xs-12" >
        <h3> Cette page a pour vocation de vous relaxer <br>
          Pour cela vous devez respirer en même temps que l'image s'anime</h3>
        </div>
        <img src="" id="BreatheWithTheShape" />
      </div>
    </div>

  </body>

  <footer align="center">
    Copyright 2017 - Team E-Breath - Tous droits réservés.
  </footer>
  </html>
