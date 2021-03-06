<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">
  <script type="text/javascript" src="./js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/bootstrap.min.js"></script>
  <title>E-breath</title>
</head>


<body>

    <!-- Barre de menus -->

  <nav class="navbar navbar-inverse">
    <h1 align="center"><font color="white">E-Breath</font></h1>
    <h2 align="center"><font color="white">${nom} ${prenom}</font></h2>
    <div class="container-fluid">
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href=Accueil>Accueil</a></li>
          <li class="active"><a href="Projet">Projet</a></li>
          <li><a href="Frequence">Ma fréquence actuelle</a></li>
          <li><a href="Historique">Historique</a></li>
          <li><a href="Jeux">Jeux de respiration</a></li>
          <li><a href="Param">Paramètres du compte</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
          <li><a href="Deconnexion">Se deconnecter</a></li>
        </ul>
      </div>
    </div>
  </nav>

    <section>
  <div class="col-xs-8 col-xs-offset-2" >
    <h1 align="center">Présentation du projet</h1>

    <br><br>
    <p> Nous sommes sept étudiants en 1ère année de cycle ingénieur de l'école d'ingénieurs ISIS (Informatique et Système d'Information pour
        la Santé). Notre projet est de réaliser un vêtement intelligent capable de récupérer la fréquence respiratoire d'une personne.
        Cette application web à donc pour vocation le suivi de cette fréquence.
    </p><br><br>
    <p>Notre groupe est composé de :
      <ul>
        <li>Anaïs Chaumeil</li>
        <li>Léa Friche</li>
        <li>Pauline Gil</li>
        <li>Arthur Laudereau</li>
        <li>Sébastien Moulard</li>
        <li>Baptiste Paulard</li>
        <li>Charlotte Rouvière</li>
      </ul></p>

    </div>
  </div>
</div>
</div>
</section>

</body>
<footer align="center">
      <div class="col-xs-8 col-xs-offset-2" >
          <br><br>
  Copyright 2017 - Team E-Breath - Tous droits réservés.
      </div>
</footer>
</html>
