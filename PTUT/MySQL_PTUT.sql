/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  HP
 * Created: 31 mars 2017
 */

DROP DATABASE IF EXISTS ptut_freq_res;

CREATE DATABASE IF NOT EXISTS ptut_freq_res;
USE ptut_freq_res;
# -----------------------------------------------------------------------------
#       TABLE : INDIVIDU
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS INDIVIDU
 (
   ID_INDIVIDU INT(4) NOT NULL,
   NOM CHAR(255) NOT NULL  ,
   PRENOM CHAR(255) NOT NULL  ,
   SEXE CHAR(32) NOT NULL  ,
   AGE INT(2) NOT NULL  ,
   POIDS INT(3) NOT NULL  ,
   SPORTIF INT(1) NOT NULL  ,
   ADRESSE_MAIL CHAR(255) NOT NULL  ,
   MDP CHAR(255) NOT NULL  
   , PRIMARY KEY (ID_INDIVIDU) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DONNEES
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DONNEES
 (
   ID_DONNEES INT(8) NOT NULL  ,
   ID_INDIVIDU INT(4) NOT NULL  ,
   HEURE_MESURE TIME NOT NULL  ,
   DATE_MESURE DATE NOT NULL  ,
   VALEUR INT(4) NOT NULL  
   , PRIMARY KEY (ID_DONNEES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE DONNEES
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_DONNEES_INDIVIDU
     ON DONNEES (ID_INDIVIDU ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


--ALTER TABLE DONNEES 
  --ADD FOREIGN KEY FK_DONNEES_INDIVIDU (ID_INDIVIDU)
      --REFERENCES INDIVIDU (ID_INDIVIDU) ;


commit;

