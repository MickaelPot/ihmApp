package com.example.myapplicationtestvehicule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtestvehicule.controler.Controleur;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    private Button Avancer;

    public int vitesse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initialisation();
    }

    private void initialisation(){
        this.vitesse=0;
        Controleur ctrl = new Controleur();
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
    }
}