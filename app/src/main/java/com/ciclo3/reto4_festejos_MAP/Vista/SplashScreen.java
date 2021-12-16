package com.ciclo3.reto4_festejos_MAP.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.ciclo3.reto4_festejos_MAP.Controlador.MainActivity;
import com.ciclo3.reto4_festejos_MAP.R;


public class SplashScreen extends AppCompatActivity implements Runnable {

    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView cisne = (ImageView)findViewById(R.id.Cisne);
        cisne.setBackgroundResource(R.drawable.cisne);

        AnimationDrawable ejecutarAnimacion = (AnimationDrawable)cisne.getBackground();
        ejecutarAnimacion.start();

        //***********************
        h1= new Thread(this);
        h1.start();
        //***********************

    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}