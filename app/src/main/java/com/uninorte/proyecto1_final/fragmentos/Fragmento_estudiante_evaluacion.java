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
import com.uninorte.proyecto1_final.adaptadores.Adaptador_estudiante_evaluacion;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Curso_Table;
import com.uninorte.proyecto1_final.modelos.Evaluacion;
import com.uninorte.proyecto1_final.modelos.Evaluacion_Table;

import java.util.List;

public class Fragmento_estudiante_evaluacion extends Fragment {

    private Curso curso;
    private LinearLayoutManager linearLayout;
    private Adaptador_estudiante_evaluacion adaptador;
    private RecyclerView reciclador;

    public Fragmento_estudiante_evaluacion() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_estudiante_evaluacion, container, false);

        reciclador = view.findViewById(R.id.reciclador_estudiante_evaluacion);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        long id = getArguments().getLong("id");
        curso = SQLite.select().from(Curso.class).where(Curso_Table.id.eq(id)).querySingle();

        List<Evaluacion> evaluaciones = SQLite.select().from(Evaluacion.class).where(Evaluacion_Table.curso_id.eq(id)).queryList();
        adaptador = new Adaptador_estudiante_evaluacion(evaluaciones);
        reciclador.setAdapter(adaptador);

        //TODO: FAB

        return view;
    }
}
