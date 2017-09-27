package com.uninorte.proyecto1_final.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_Evaluaciones;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_elementos;


public class Fragmento_evaluaciones extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_Evaluaciones adaptador;

    public Fragmento_evaluaciones() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_evaluaciones, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador_elementos);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        adaptador = new Adaptador_Evaluaciones();
        reciclador.setAdapter(adaptador);
        return view;
    }




}
