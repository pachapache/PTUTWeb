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

        <nav class="navbar navbar-inverse">
            <h1 align="center"><font color="white">E-Breath</font></h1>
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Accueil</a></li>
                        <li><a href="projet.html">Projet</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="connexion.jsp">Connexion</a></li>
                        <li><a href="inscription.html">S'inscrire</a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div id="my_carousel" class="carousel slide" data-ride="carousel">
            <!-- Bulles -->
            <ol class="carousel-indicators">
                <li data-target="#my_carousel" data-slide-to="0" class="active"></li>
                <li data-target="#my_carousel" data-slide-to="1"></li>
                <li data-target="#my_carousel" data-slide-to="2"></li>
            </ol>
            <!-- Slides -->
            <div class="carousel-inner">
                <!-- Page 1 -->
                <div class="item active">
                    <div class="carousel-page">
                        <img src="./img/girl_run.jpg" class="img-responsive" style="margin:0px auto;" />
                    </div>
                    <div class="carousel-caption"></div>
                </div>
                <!-- Page 2 -->
                <div class="item">
                    <div class="carousel-page">
                        <img src="./img/girl_breath.jpg" class="img-responsive img-rounded" style="margin:0px auto;"  /></div>
                    <div class="carousel-caption"></div>
                </div>
                <!-- Page 3 -->
                <div class="item">
                    <div class="carousel-page">
                        <img src="./img/health.jpg" class="img-responsive img-rounded" style="margin:0px auto;"  />
                    </div>
                    <div class="carousel-caption"></div>
                </div>
            </div>
            <!-- ContrÃ´les -->
            <a class="left carousel-control" href="#my_carousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#my_carousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>

        <br><br>



        <div class="col-md-4">
            <div class="circle">Suivi régulier</div>
        </div>

        <div class="col-md-4">
            <div class="circle">Statistiques</div>
        </div>

        <div class="col-md-4">
            <div class="circle">Exercices de respiration</div>
        </div>


    </div>
</div>
</div>

</body>
<footer align="center">
    Copyright 2017 - Team E-Breath - Tous droits réservés.
</footer>


</html>
