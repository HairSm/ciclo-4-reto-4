package com.ciclo3.reto4_festejos_MAP.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.ciclo3.reto4_festejos_MAP.Modelo.Adaptador;
import com.ciclo3.reto4_festejos_MAP.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.ciclo3.reto4_festejos_MAP.Modelo.Entidad;
import com.ciclo3.reto4_festejos_MAP.R;

import java.util.ArrayList;


public class Fragment_Productos extends Fragment {

    View v;

    ListView listaProductos;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conector = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(GetListItems(), getContext());

        listaProductos.setAdapter(adaptador);


        //-----------------------------------------------------------------------------
        return v;
    }
    private ArrayList<Entidad> GetListItems() {
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.cmesa, "Centros de mesa", "diferentes estilos de centros de mesa según el tipo de celebración que desee desarrollar en nuestras  sede o por fuera de esta"));
        listaItems.add(new Entidad(R.drawable.arcos, "Arcos de flores", "el arco esta constituido con flores artificiales o naturales según su elección , al igual que el tipo de flor"));
        listaItems.add(new Entidad(R.drawable.cocteles, "Coópteles", "ofrecemos Coópteles de todo tipo, pero nos especializamos en coópteles libres de alcohol"));
        return listaItems;
    }


}