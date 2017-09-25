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



public class fragmento_cursos extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_cursos adaptador;

    public fragmento_cursos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_cursos, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador_cursos);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        adaptador = new Adaptador_cursos();
        reciclador.setAdapter(adaptador);
        return view;
    }


public void AddCurso(View view){

}

}
