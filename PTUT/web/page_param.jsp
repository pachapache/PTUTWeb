<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script type="text/javascript" src="./js/jquery.min.js"></script>
        <script type="text/javascript" src="./js/bootstrap.min.js"></script>
        <script type="text/javascript" src="./js/traitement_param.js"></script>

        <title>E-breath</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron"><h1>Paramètres</h1></div>
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
                                <li><a href="page_accueil.html">Ma fréquence actuelle</a></li>
                                <li><a href="page_historique.html">Historique</a></li>
                                <li><a href="page_statistique.html">Statistique</a></li>
                                <li><a href="page_chill.html">Chill</a></li>
                                <li class="divider"></li>
                                <li><a href="page_param.jsp">Paramètres du compte</a></li>
                            </ul>
                        </li>
                    </ul>

                    <div class="container">
                        <div class ="row">
                            <div class="col-xs-12" >


                                <form class="form-horizontal" id="formulaire" role="form " action="Settings" method="GET">
                                    <ol class="breadcrumb"></ol>
                                    <div class="form-group">
                                        <h2>Vos informations personnelles</h2>
                                        <label>Votre nom</label>
                                        <input type="texte" class="form-control" id="nom" value='${nom}' disabled="disabled">
                                        <br/></br/>
                                        <label>Votre prénom</label>
                                        <input type="texte" class="form-control" id="prenom" value='${prenom}' disabled="disabled">
                                        <br/></br/>
                                        <label>Votre sexe</label>
                                        <div class="checkbox">
                                            <label><input type="radio" name="sexe" disabled="disabled" ${sexe1}> Homme </label>
                                            <label><input type="radio" name="sexe" disabled="disabled" ${sexe2}> Femme </label>
                                        </div>
                                        <br/></br/>
                                        <label>Votre date de naissance</label>
                                        <input type="date" class="form-control" name="ddn" value='${ddn}' disabled="disabled">
                                        <br/></br/>
                                        <label>Votre poids</label>
                                        <input type="number" class="form-control" value='${poids}' name="poids" placeholder="Poids" min="30" max="150" required="">
                                        <br/></br/>
                                        <label>Etes vous sportif ?</label>
                                        <label><input type="radio" name="sportif" required="" ${sport1}> Oui </label>
                                        <label><input type="radio" name="sportif" required="" ${sport2}> Non </label>
                                        <br/></br/>
                                        <h2>Modification de vos accès</h2>
                                        <h3>Adresse mail</h3>
                                        <label>Veuillez saisir votre adresse mail</label>
                                        <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="ancienMail" id="ancienMail" required="">
                                        <br/></br/>
                                        <label>Veuillez saisir votre nouvelle adresse mail</label>
                                        <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="mail" id="mail"  required="">
                                        <br/></br/>
                                        <label>Veuillez confirmer votre nouvelle adresse mail</label>
                                        <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="newMail" id="newMail" required="">
                                        <br/></br/>
                                        <h3>Mot de passe</h3>
                                        <label>Veuillez saisir votre mot de passe</label>
                                        <input type="password"  class="form-control" name="ancienMdp" id="ancienMdp" required="">
                                        <br/></br/>
                                        <label>Veuillez saisir votre nouveau mot de passe</label>
                                        <input type="password"  class="form-control" name="mdp" id="newMdp" required="">
                                        <br/></br/>
                                        <label>Veuillez confirmer votre mot de passe</label>
                                        <input type="password" class="form-control" name="confirmMdp" id="confirmMdp" required="">
                                    </div>
                            </div>
                            <br/></br/>
                            <div class="form-group">
                                <div class="valider">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Modifier
                                    </button>
                                    <br/></br/><br/></br/>
                                </div>
                            </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
