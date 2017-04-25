
DROP DATABASE IF EXISTS ptut_freq_res;

CREATE DATABASE IF NOT EXISTS ptut_freq_res;
USE ptut_freq_res;
# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   ID_UTILISATEUR INT UNSIGNED AUTO_INCREMENT,
   NOM CHAR(255) NOT NULL  ,
   PRENOM CHAR(255) NOT NULL  ,
   SEXE CHAR(32) NOT NULL  ,
   DATE DATE NOT NULL  ,
   POIDS INT(3) NOT NULL  ,
   SPORTIF INT(1) NOT NULL  ,
   ADRESSE_MAIL CHAR(255) NOT NULL  ,
   MDP CHAR(255) NOT NULL  
   , PRIMARY KEY (ID_UTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DONNEES
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DONNEES
 (
   ID_DONNEES INT(8) NOT NULL  ,
   ID_UTILISATEUR INT(4) NOT NULL  ,
   HEURE_MESURE TIME NOT NULL  ,
   DATE_MESURE DATE NOT NULL  ,
   VALEUR INT(4) NOT NULL  
   , PRIMARY KEY (ID_DONNEES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE DONNEES
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_DONNEES_UTILISATEUR
     ON DONNEES (ID_UTILISATEUR ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE DONNEES 
ADD FOREIGN KEY FK_DONNEES_UTILISATEUR (ID_UTILISATEUR)
REFERENCES UTILISATEUR (ID_UTILISATEUR) ;

ALTER TABLE UTILISATEUR AUTO_INCREMENT=1;

commit;

