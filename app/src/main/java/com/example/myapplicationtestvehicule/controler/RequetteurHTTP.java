package com.example.myapplicationtestvehicule.controler;
import com.example.myapplicationtestvehicule.ConfigurationProjet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequetteurHTTP {
    private String url;
    private String URLEnvoyee;

    public RequetteurHTTP(){
        this.URLEnvoyee="";
        this.construitURL();
    }

    private void construitURL(){
        ConfigurationProjet configuration = new ConfigurationProjet();
        if(configuration.isConnexionSecurisee()){
            this.url="https://";
        }else{
            this.url="http://";
        }
        this.url+= configuration.getIPVoiture()+":"+configuration.getPortVoiture()+"/run/?action=";
    }

    public String getURL() {
        return url;
    }

    public void commandeAvancer(int vitesse) throws MalformedURLException {
        this.URLEnvoyee=this.url+"avancer&vitesse="+String.valueOf(vitesse);
        this.envoyerDirectiveServeur();
    }

    private void envoyerDirectiveServeur() throws MalformedURLException {
        try{
            if(this.URLEnvoyee.equals("")){
                throw new MalformedURLException("Merci de demander une action à passer au véhicule");
            }
            URL url = new URL(this.URLEnvoyee);
            this.URLEnvoyee="";
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                //Trouver quoi faire
            }else{
                System.err.println("Le serveur ne répond pas");
            }
        }catch (MalformedURLException e){
            System.err.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
