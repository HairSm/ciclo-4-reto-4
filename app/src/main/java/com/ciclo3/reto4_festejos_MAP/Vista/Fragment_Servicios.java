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


public class Fragment_Servicios extends Fragment {


    View v;

    ListView listaServicios;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conector = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(GetArrayItems(), getContext());

        listaServicios.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }
    private ArrayList<Entidad> GetArrayItems() {
        ArrayList<Entidad> listaItems = new ArrayList<Entidad>();
        listaItems.add(new Entidad(R.drawable.dulces, "confiteria", "Ofrecemos gran variedad de golocinas, y productos relacionados con la decoracion de nuestros eventos "));
        listaItems.add(new Entidad(R.drawable.salones, "Salones de eventos", "ponemos a tu dipocision diferentes salones de acuerdo a la ubicacion o caracteristicas de tus eventos"));
        listaItems.add(new Entidad(R.drawable.tematica, "Tematicas de festividades", "Te ofrecemos el servicio de tematicas para tus celebraciones de acuerdo al tipo de celebracion que quieras realizar"));

        return listaItems;
    }
}