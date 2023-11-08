package com.example.myapplicationtestvehicule.controler;
import com.example.myapplicationtestvehicule.ConfigurationProjet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

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
        this.url+= configuration.getIPVoiture()+":"+configuration.getPortVoiture()+"/run/?";
    }

    public String getURL() {
        return url;
    }

    public void activerVehicule() throws MalformedURLException {
        this.URLEnvoyee=this.url;
        this.envoyerDirectiveServeur("action=setup");
        this.envoyerDirectiveServeur("action=bwready");
        this.envoyerDirectiveServeur("action=fwready");
        this.envoyerDirectiveServeur("action=camready");
    }
    public void commandeAvancer(int vitesse) throws MalformedURLException {
        this.URLEnvoyee=this.url;
        this.envoyerDirectiveServeur("action=avancer&vitesse="+String.valueOf(vitesse));
    }

    public void commandeStop() throws MalformedURLException {
        this.URLEnvoyee=this.url;
        this.envoyerDirectiveServeur("action=stop");
    }

    public void commandeGauche() throws MalformedURLException {
        this.URLEnvoyee=this.url;
        this.envoyerDirectiveServeur("action=gauche");
    }

    public void commandeDroite() throws MalformedURLException {
        this.URLEnvoyee=this.url;
        this.envoyerDirectiveServeur("action=droite");
    }

    public void commandeEnFace() throws MalformedURLException {
        this.URLEnvoyee=this.url;
        this.envoyerDirectiveServeur("action=face");
    }

    private void envoyerDirectiveServeur(String parametres) throws MalformedURLException {
        //TEST
        BufferedReader reader = null;
        try{
            if(this.URLEnvoyee.equals("")){
                throw new MalformedURLException("Merci de demander une action à passer au véhicule");
            }
            URL url = new URL(this.URLEnvoyee+parametres);
            System.out.println(this.URLEnvoyee+parametres);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //int responseCode = connection.getResponseCode();
            //System.out.println("Code de réponse: " + responseCode);

            InputStream inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Réponse : " + response.toString());

        }catch (MalformedURLException e){
            System.err.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
