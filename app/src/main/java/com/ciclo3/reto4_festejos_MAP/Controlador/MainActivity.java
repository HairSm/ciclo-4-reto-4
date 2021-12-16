package com.ciclo3.reto4_festejos_MAP.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.ciclo3.reto4_festejos_MAP.R;
import com.ciclo3.reto4_festejos_MAP.Vista.Fragment_Favoritos;
import com.ciclo3.reto4_festejos_MAP.Vista.Fragment_Inicio;
import com.ciclo3.reto4_festejos_MAP.Vista.Fragment_Productos;
import com.ciclo3.reto4_festejos_MAP.Vista.Fragment_Servicios;
import com.ciclo3.reto4_festejos_MAP.Vista.Fragment_Sucursales;

public class MainActivity extends AppCompatActivity {

    Fragment subPantallaContacto;
    Fragment subPantallaFavoritos;
    Fragment subPantallaProductos;
    Fragment subPantallaServicios;
    Fragment subPantallaInicio;

    FragmentTransaction trasaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantallaProductos = new Fragment_Productos();
        subPantallaServicios = new Fragment_Servicios();
        subPantallaContacto = new Fragment_Sucursales();
        subPantallaFavoritos = new Fragment_Favoritos();
        subPantallaInicio = new Fragment_Inicio();

        getSupportFragmentManager().beginTransaction().add(R.id.base, subPantallaInicio).commit();


    }

    //****************************************** MENU DE OPCIONES ***************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion1) {
            Toast.makeText(this, "ACABAS DE ENTRAR A VER NUESTROS PRODUCTOS", Toast.LENGTH_LONG).show();

            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.base, subPantallaProductos).commit();
        }
        if (id == R.id.opcion2) {
            Toast.makeText(this, "ACABAS DE ENTRAR A NUESTROS SERVICIOS", Toast.LENGTH_LONG).show();

            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.base, subPantallaServicios).commit();
        }
        if (id == R.id.opcion3) {
            Toast.makeText(this, "ESTE ES NUESTRO CONTACTO", Toast.LENGTH_LONG).show();

            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.base, subPantallaContacto).commit();
        }
        if (id == R.id.opcion4) {
            Toast.makeText(this, "MIS FAVORITOS", Toast.LENGTH_LONG).show();

            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.base, subPantallaFavoritos).commit();
        }
        if (id == R.id.opcion5) {
            Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();

            trasaction = getSupportFragmentManager().beginTransaction();
            trasaction.replace(R.id.base, subPantallaInicio).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}