package com.example.myapplicationtestvehicule.controler;

import java.net.MalformedURLException;

public class Controleur {
    private RequetteurHTTP requetteur;
    public Controleur(){
        this.requetteur= new RequetteurHTTP();
    }

    public void ActiveVehicule() throws MalformedURLException {
        this.requetteur.activerVehicule();
    }

    public void Avancer(int vitesse) throws MalformedURLException {
        this.requetteur.commandeAvancer(vitesse);
    }

    public void StopVehicule()throws MalformedURLException {
        this.requetteur.commandeStop();
    }

    public void TourneGaucheVehicule()throws MalformedURLException {
        this.requetteur.commandeGauche();
    }

    public void TourneDroiteVehicule()throws MalformedURLException {
        this.requetteur.commandeDroite();
    }

    public void TourneFaceVehicule()throws MalformedURLException {
        this.requetteur.commandeEnFace();
    }

}
