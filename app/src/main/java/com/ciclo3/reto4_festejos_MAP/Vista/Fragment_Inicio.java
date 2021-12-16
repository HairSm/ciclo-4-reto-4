package com.ciclo3.reto4_festejos_MAP.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ciclo3.reto4_festejos_MAP.R;

public class Fragment_Inicio extends Fragment {


    View v;
    Resources res4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__inicio, container, false);
        //-----------------------------------------------------------------------------
        res4 = getResources();
        Drawable drawable = res4.getDrawable(R.drawable.logo,v.getContext().getTheme());

        ImageView imagenLogo = (ImageView) v.findViewById(R.id.logo1);
        imagenLogo.setImageDrawable(drawable);

        //-----------------------------------------------------------------------------
        return v;
    }
}