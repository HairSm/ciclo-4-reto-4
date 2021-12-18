package com.ciclo3.reto4_festejos_MAP.Vista;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ciclo3.reto4_festejos_MAP.Modelo.Adaptador;
import com.ciclo3.reto4_festejos_MAP.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.ciclo3.reto4_festejos_MAP.Modelo.Entidad;
import com.ciclo3.reto4_festejos_MAP.R;

import java.util.ArrayList;


public class Fragment_Favoritos extends Fragment {

    View v;
    ListView listaFavoritos;
    Adaptador adaptador;
    String TAG = "Fragment_Favoritos";
    String Arcos="Arcos de flores";
    String Coptel="Coópteles";
    String dulces="confiteria";
    String salones="Salones de eventos";
    String tematica="Tematicas de festividades";

    int [] imagen = {R.drawable.cmesa, R.drawable.arcos, R.drawable.cocteles,R.drawable.dulces, R.drawable.salones, R.drawable.tematica,};

    MotorBaseDatosSQLite conectar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__favoritos, container, false);
        //-----------------------------------------------------------------------------

        listaFavoritos = (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(getTablaFavoritos(), getContext());

        listaFavoritos.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }
    private ArrayList<Entidad> getTablaFavoritos(){
        ArrayList<Entidad> listaFavoritos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"Mis productos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM favoritos", null);
        Log.v(TAG, "leyendo bas de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            int dato;
            String Dato2 = cursor.getString(1);

            if (Dato2.equals(Arcos)){
                dato=1;
            }else if(Dato2.equals(Coptel)){
                dato=2;
            }else if(Dato2.equals(dulces)){
                dato=3;
            }else if(Dato2.equals(salones)){
                dato=4;
            }else if(Dato2.equals(tematica)){
                dato=5;
            }else{
                dato=0;
            }
            listaFavoritos.add(new Entidad(imagen[dato],Dato2, cursor.getString(2)));
            Log.v(TAG, "despues del while");
        }


        return listaFavoritos;
    }
}