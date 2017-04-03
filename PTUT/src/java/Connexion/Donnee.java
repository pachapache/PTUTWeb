/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Donnee {
    
    private int id;
    private Date heure;
    private Date date;
    private int valeur;
    
    
    public Donnee(int id, Date heure, Date date, int valeur) {
        this.id = id;
        this.heure = heure;
        this.date = date;
        this.valeur = valeur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getId() {
        return id;
    }

    public Date getHeure() {
        return heure;
    }

    public Date getDate() {
        return date;
    }

    public int getValeur() {
        return valeur;
    }

    
    
}
