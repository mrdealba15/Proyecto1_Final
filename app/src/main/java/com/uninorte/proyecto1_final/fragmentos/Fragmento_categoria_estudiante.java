package com.uninorte.proyecto1_final.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.MainActivity;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_categoria_estudiante;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Categoria_Table;
import com.uninorte.proyecto1_final.modelos.Estudiante;
import com.uninorte.proyecto1_final.modelos.Estudiante_Table;
import com.uninorte.proyecto1_final.modelos.Evaluacion;
import com.uninorte.proyecto1_final.modelos.Evaluacion_Table;
import com.uninorte.proyecto1_final.modelos.Rubrica;
import com.uninorte.proyecto1_final.modelos.Rubrica_Table;

import java.util.List;

public class Fragmento_categoria_estudiante extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_categoria_estudiante adaptador;
    private Rubrica rubrica;
    private Estudiante estudiante;
    private Evaluacion evaluacion;

    public Fragmento_categoria_estudiante() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categoria_estudiante, container, false);

        reciclador = view.findViewById(R.id.reciclador_categorias_estudiante);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        long idRubrica = getArguments().getLong("idRubrica");
        long idEstudiante = getArguments().getLong("idEstudiante");
        long idEvaluacion = getArguments().getLong("idEvaluacion");
        rubrica = SQLite.select().from(Rubrica.class).where(Rubrica_Table.id.eq(idRubrica)).querySingle();
        evaluacion = SQLite.select().from(Evaluacion.class).where(Evaluacion_Table.id.eq(idEvaluacion)).querySingle();
        estudiante = SQLite.select().from(Estudiante.class).where(Estudiante_Table.id.eq(idEstudiante)).querySingle();

        List<Categoria> categorias = SQLite.select().from(Categoria.class).where(Categoria_Table.rubrica_id.eq(idRubrica)).queryList();
        adaptador = new Adaptador_categoria_estudiante(categorias, (MainActivity) getActivity(), estudiante, evaluacion);
        reciclador.setAdapter(adaptador);


        return view;
    }
}
