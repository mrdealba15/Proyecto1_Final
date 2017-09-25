package com.uninorte.proyecto1_final;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragmento_evaluaciones extends Fragment {

    private LinearLayoutManager linearLayout;

    public Fragmento_evaluaciones() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_evaluaciones, container, false);

        RecyclerView reciclador = (RecyclerView)view.findViewById(R.id.reciclador_evaluaciones);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        Adaptador_Evaluaciones adaptador = new Adaptador_Evaluaciones();
        reciclador.setAdapter(adaptador);


        return view;
    }
}