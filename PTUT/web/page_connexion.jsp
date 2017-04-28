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
        ${error}
        
    </head>

    <body>
        <div class="container">
            <div class="jumbotron"><h1>E-breath</h1></div>
            <div class="row">

                <div id="formulaire" class="col-md-9">
                    <ol class="breadcrumb"></ol>
                    <form class="connexion" action="Connexion" method="POST">
                        <div class="form-group">
                            <label for="identifiant">Veuillez saisir votre identifiant</label>
                            <input class="form-control" name="identifiant" placeholder="Identifiant">
                            <a href="#" id="lien_identifiant">J'ai oublié mon identifiant ? Je clique ici</a>
                            <div class="texte_identifiant">
                                Votre identifiant est votre adresse mail
                            </div>         
                        </div>

                        <div class="form-group">
                            <label for="motDePasse">Veuillez saisir votre mot de passe</label>
                            <input type="password" class="form-control" name="motDePasse" placeholder="motDePasse">
                            <a href="#" id="lien_identifiant">J'ai oublié mon mot de passe ? Je clique ici</a>
                        </div>
                                           <div class="container">
                        <div class ="row">
                            <div class="col-xs-12">
                                <div class= "alert alert-danger" id="pbConnexion">
                                    <b>Attention!</b> Identifiant et/ou mot de passe incorrect
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                </div>
                            </div>
                        </div>
                    </div>
                        <div class="seCo">
                            <button type="submit" class="btn btn-primary">
                                <span class="glyphicon glyphicon-off" aria-hidden="true"></span> Se connecter
                            </button>
                        </div>
                    </form>                  

                </div>

                <div class="inscription">
                    Pas encore de compte ? Je m'inscris
                    <br/>
                    <button type="button" class="btn btn-primary" value="form_inscription" onclick="self.location.href = 'form_inscription.jsp'">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> S'inscrire
                    </button>
                </div>

            </div>
        </div>
    </body>
</html>