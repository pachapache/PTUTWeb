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
  <script type="text/javascript" src="./js/traitement_accueil.js"></script>

  <title>E-breath</title>
</head>
  <body>
    <div class="container">
    <div class="jumbotron"><h1>Ma fréquence respiratoire</h1></div>
    <div class="row">
    <div class="col-xs-12">

      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="" class="dropdown-toggle" data-toggle="dropdown">
            <div class="menu">
              <span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span>
                Menu
          </div>
          </a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="../html/page_accueil.html">Ma fréquence actuelle</a></li>
            <li><a href="../html/page_historique.html">Historique</a></li>
            <li><a href="../html/page_statistique.html">Statistique</a></li>
            <li><a href="../html/page_chill.html">Chill</a></li>
            <li class="divider"></li>
            <li><a href="../html/page_param.html">ParamÃ¨tres</a></li>
          </ul>
        </li>
      </ul>

      <div class="container">
      <div class="row">
      <div class="col-xs-12">
        <div id="chart_div" style="width: 4000px; height: 1200px"></div>

      </div>
      </div>
      </div>

    </div>
    </div>
    </div>
  </body>
</html>
