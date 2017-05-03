package model;

import java.util.Date;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private Date dateNaissance;
    private int poids;
    private boolean sportif;
    private String mail;
    private String mdp;

    public Utilisateur(int id, String nom, String prenom, String sexe, Date ddn, int poids, boolean sportif, String mail, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = ddn;
        this.poids = poids;
        this.sportif = sportif;
        this.mail = mail;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public int getPoids() {
        return poids;
    }

    public boolean isSportif() {
        return sportif;
    }

    public String getMail() {
        return mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setAge(Date ddn) {
        this.dateNaissance = ddn;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void setSportif(boolean sportif) {
        this.sportif = sportif;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
}