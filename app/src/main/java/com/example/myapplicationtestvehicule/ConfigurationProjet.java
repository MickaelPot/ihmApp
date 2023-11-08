package com.example.myapplicationtestvehicule;

public class ConfigurationProjet {
    private String IPVoiture;
    private String portVoiture;
    private boolean connexionSecurisee;
    private int [] vitesses;

    public ConfigurationProjet(){
        this.IPVoiture="10.3.141.1";
        //this.IPVoiture="192.168.1.174";
        this.portVoiture="8000";
        this.connexionSecurisee=false;
        this.vitesses= this.configureVitesse();
    }

    private int[] configureVitesse(){
        int[]tableau= new int[5];
        tableau[0]=20;
        tableau[1]=40;
        tableau[2]=60;
        tableau[3]=80;
        tableau[4]=100;
        return tableau;
    }

    public String getIPVoiture() {
        return IPVoiture;
    }

    public boolean isConnexionSecurisee() {
        return connexionSecurisee;
    }
    public String getPortVoiture(){
        return portVoiture;
    }
}
