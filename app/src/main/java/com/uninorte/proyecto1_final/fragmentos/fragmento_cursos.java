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
import com.uninorte.proyecto1_final.modelos.Curso;

import java.util.List;


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

        Curso newC = new Curso();
        newC.setName("Nuevo Curso");
        newC.setNrc("K-25");
        newC.save();

        List<Curso> cursos = SQLite.select().from(Curso.class).queryList();
        adaptador = new Adaptador_cursos(cursos);

        reciclador.setAdapter(adaptador);
        return view;
    }


public void AddCurso(View view){

}

}
