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

    int [] imagen = {R.drawable.cmesa, R.drawable.arcos, R.drawable.cocteles,R.drawable.dulces, R.drawable.salones, R.drawable.tematica,};

    MotorBaseDatosSQLite conectar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__favoritos, container, false);
        //-----------------------------------------------------------------------------

        listaFavoritos= (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(GetListItems(), getContext());
        listaFavoritos.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }
    private ArrayList<Entidad> GetListItems() {
        ArrayList<Entidad> listaItems = new ArrayList<>();

        conectar = new MotorBaseDatosSQLite(getContext(),"Favoritos",null,3);
        SQLiteDatabase db_leer =conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM favoritos",null);
        Log.v(TAG,"leyendo base de datos");
        while(cursor.moveToNext()){
            Log.v(TAG,"debntro de while");
            listaItems.add(new Entidad(imagen[cursor.getInt(0)],cursor.getString(1),cursor.getString(2)));
            Log.v(TAG,"debntro de while");

        }
        return listaItems;
    }
}