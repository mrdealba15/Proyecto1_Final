package com.uninorte.proyecto1_final.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_cursos;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_rubricas;
import com.uninorte.proyecto1_final.modelos.Rubrica;

import java.util.List;


public class Fragmento_rubricas extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager linearLayout;
    private Adaptador_rubricas adaptador;

    public Fragmento_rubricas() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_rubricas, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador_rubricas);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        List<Rubrica> rubricas = SQLite.select().from(Rubrica.class).queryList();
        adaptador = new Adaptador_rubricas(rubricas);
        reciclador.setAdapter(adaptador);

        return view;
    }


}
