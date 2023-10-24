package com.example.myapplicationtestvehicule.controler;

import java.net.MalformedURLException;

public class Controleur {
    private RequetteurHTTP requetteur;
    public Controleur(){
        this.requetteur= new RequetteurHTTP();
    }

    public void Avancer(int vitesse) throws MalformedURLException {
        this.requetteur.commandeAvancer(vitesse);
    }
}
