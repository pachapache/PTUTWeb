<%@ page pageEncoding="UTF-8" %>

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
        <div class="container">
            <div class="jumbotron"><h1>Formulaire d'inscription</h1></div>
            <div class="row">
                <div class="col-xs-12">

                    <div class="container">
                        <div class ="row">
                            <div class="col-xs-12" >

                                <form class="form-horizontal" id="formulaire" role="form" action="Inscription" method="POST">
                                    <ol class="breadcrumb"></ol>
                                    <div class="form-group">
                                        <h2>Vos informations personnelles</h2>
                                        <label>Veuillez saisir votre nom</label>
                                        <input type="texte" class="form-control" name="nom" placeholder="Nom" required="">
                                        <br/></br/>
                                        <label>Veuillez saisir votre prénom</label>
                                        <input type="texte" class="form-control" name="prenom" placeholder="Prenom" required="">
                                        <br/></br/>
                                        <label>Veuillez saisir votre sexe</label>
                                        <div class="checkbox">
                                            <label><input type="radio" name="sexe" required=""> Homme </label>
                                            <label><input type="radio" name="sexe" required=""> Femme </label>
                                        </div>
                                        <br/></br/>
                                        <label>Veuillez saisir votre date de naissance</label>
                                        <input type="date" class="form-control" name="ddn" placeholder="DateDeNaissance" max="2000-01-01" min="1900-12-31" required="">
                                        <br/></br/>
                                        <label>Veuillez saisir votre poids</label>
                                        <input type="number" class="form-control" name="poids" placeholder="Poids" min="30" max="150" required="">
                                        <br/></br/>
                                        <label>Etes vous sportif ?</label>
                                        <label><input type="radio" name="sportif" required=""> Oui </label>
                                        <label><input type="radio" name="sportif" required=""> Non </label>
                                        <br/></br/>
                                        <h2>Création de votre compte</h2>
                                        <label>Veuillez saisir votre adresse mail</label>
                                        <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="mail" id="mail" placeholder="Mail" required="">
                                        <br/></br/>
                                        <label>Veuillez confirmer votre adresse mail</label>
                                        <input type="mail" pattern="[^ @]*@[^ @]*" class="form-control" name="confirmMail" id="confirmMail" placeholder="ConfirmerMail" required="">
                                        <br/></br/>
                                        <label>Veuillez saisir un mot de passe</label>
                                        <input type="password"  class="form-control" name="mdp" id="mdp" placeholder="MotDePasse" required="">
                                        <br/></br/>
                                        <label>Veuillez confirmer votre mot de passe</label>
                                        <input type="password" class="form-control" name="confirmMdp" id="confirmMdp" placeholder="ConfirmerMotDePasse" required="">
                                    </div>
                                    <br/></br/>
                                    <div class="form-group">
                                        <div class="valider">
                                            <button class="btn btn-primary" type="submit">
                                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Valider
                                            </button>
                                            <br/></br/><br/></br/>
                                        </div>
                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class ="row">
                        <div class="col-xs-12">
                            <div class= "alert alert-success" id="inscriptionValide">
                                <b>Félicitation!</b> Vous venez de créer votre compte avec succès
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class ="row">
                        <div class="col-xs-12">
                            <div class= "identifiants">
                                <b>Votre identifiant est</b> ${mail} <br/></br/>
                                <b>Votre mot de passe est</b> le mot de passe que vous avez saisi <br/></br/><br/></br/>
                                <b>Vous allez être prochainement redirigé vers la page d'accueil du site</b>
                            </div>
                        </div>
                    </div>
                </div>

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
                                <b>Attention!</b> Les adresses mails saisies sont différentess !
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    ${error}
</body>
</html>
