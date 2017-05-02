package model;

import java.util.Date;

public class Donnee {
    
    private int id_donnee;
    private int id_utilisateur;
    private Date heure;
    private Date date;
    private int valeur;

    public Donnee(int idD, int idU, Date heure, Date date, int valeur) {
        this.id_donnee = idD;
        this.id_utilisateur = idU;
        this.heure = heure;
        this.date = date;
        this.valeur = valeur;
    }
    
    public int getId_donnee() {
        return id_donnee;
    }

    public void setId_donnee(int id_donnee) {
        this.id_donnee = id_donnee;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
}
