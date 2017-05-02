<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/freq.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
          <li class="active"><a href="Frequence">Ma fréquence actuelle</a></li>
          <li><a href="Historique">Historique</a></li>
          <li><a href="Jeux">Jeux de respiration</a></li>
          <li><a href="Param">Paramètres du compte</a></li>
        </ul>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Deconnexion">Se deconnecter</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Frequence actuelle -->

<div class="col-md-4 col-md-offset-5">
  <figure class="chart" data-percent="75">
    <figcaption>${valeur}</figcaption>
    <svg width="200" height="200">
      <circle class="outer" cx="95" cy="95" r="85" transform="rotate(-90, 95, 95)"/>
    </svg>
  </figure>
</div>


<section class="container">
  <div class="col-md-4 col-md-offset-4">
    <br><br><br>
    <p><b>Date de la mesure : </b> ${date}<br><br>
      <b>Heure de la mesure : </b> ${heure}
    </p>
  </div>
</section>

</body>

<footer align="center">
  Copyright© 2017 - Team E-Breath - Tous droits réservés.
</footer>

</html>
