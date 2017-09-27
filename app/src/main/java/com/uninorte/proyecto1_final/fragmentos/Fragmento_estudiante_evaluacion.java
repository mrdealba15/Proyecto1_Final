package com.uninorte.proyecto1_final.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_estudiante_evaluacion;


public class Fragmento_estudiante_evaluacion extends Fragment {

    private LinearLayoutManager linearLayout;

    public Fragmento_estudiante_evaluacion() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_estudiante_evaluacion, container, false);

        RecyclerView reciclador = (RecyclerView)view.findViewById(R.id.reciclador_estudiante_evaluacion);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        Adaptador_estudiante_evaluacion adaptador = new Adaptador_estudiante_evaluacion();
        reciclador.setAdapter(adaptador);


        return view;
    }
}
