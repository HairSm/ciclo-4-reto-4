package com.ciclo3.reto4_festejos_MAP.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)"); //---- Registros
        //db.execSQL("INSERT INTO favoritos VALUES (0, 'Centros de mesa','diferentes estilos de centros de mesa según el tipo de celebración que desee desarrollar en nuestras  sede o por fuera de esta')");
        //db.execSQL("INSERT INTO favoritos VALUES (1, 'Arcos de flores','diferentes estilos de arcos según el tipo de celebración que desee desarrollar en nuestras  sede o por fuera de esta')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        onCreate(db);

    }
}