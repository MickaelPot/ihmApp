package com.example.myapplicationtestvehicule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtestvehicule.controler.Controleur;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    private Button Avancer;
    private Button Stop;

    private Button gauche;

    private Button droite;

    public int vitesse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Permet d'autoriser le telephone à envoyer des requetes http
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        try {
            this.initialisation();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initialisation() throws MalformedURLException {
        this.vitesse=0;
        Controleur ctrl = new Controleur();
        ctrl.ActiveVehicule();

        this.Avancer= (Button) findViewById(R.id.buttonAvancer);
        this.Avancer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if(vitesse<100){
                        vitesse+=20;
                    }
                    ctrl.Avancer(vitesse);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.Stop=(Button) findViewById(R.id.buttonStop);
        this.Stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    vitesse=0;
                    ctrl.StopVehicule();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.gauche=(Button) findViewById(R.id.tourneGauche);
        this.gauche.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    ctrl.TourneGaucheVehicule();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.droite=(Button) findViewById(R.id.tourneDroite);
        this.droite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    ctrl.TourneDroiteVehicule();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}