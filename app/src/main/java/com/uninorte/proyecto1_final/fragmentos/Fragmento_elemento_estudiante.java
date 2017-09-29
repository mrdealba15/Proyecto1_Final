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
import com.uninorte.proyecto1_final.adaptadores.Adaptador_elemento_estudiante;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Categoria_Table;
import com.uninorte.proyecto1_final.modelos.Elemento;
import com.uninorte.proyecto1_final.modelos.Elemento_Table;
import com.uninorte.proyecto1_final.modelos.Estudiante;
import com.uninorte.proyecto1_final.modelos.Estudiante_Table;
import com.uninorte.proyecto1_final.modelos.Evaluacion;
import com.uninorte.proyecto1_final.modelos.Evaluacion_Table;

import java.util.List;

public class Fragmento_elemento_estudiante extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_elemento_estudiante adaptador;
    private Categoria categoria;
    private Evaluacion evaluacion;
    private Estudiante estudiante;

    public Fragmento_elemento_estudiante() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_elemento_estudiante, container, false);

        reciclador = view.findViewById(R.id.reciclador_elemento_estudiante);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        long idCategoria = getArguments().getLong("idCategoria");
        long idEstudiante = getArguments().getLong("idEstudiante");
        long idEvaluacion = getArguments().getLong("idEvaluacion");
        categoria = SQLite.select().from(Categoria.class).where(Categoria_Table.id.eq(idCategoria)).querySingle();
        evaluacion = SQLite.select().from(Evaluacion.class).where(Evaluacion_Table.id.eq(idEvaluacion)).querySingle();
        estudiante = SQLite.select().from(Estudiante.class).where(Estudiante_Table.id.eq(idEstudiante)).querySingle();

        List<Elemento> elementos = SQLite.select().from(Elemento.class).where(Elemento_Table.categoria_id.eq(idCategoria)).queryList();
        adaptador = new Adaptador_elemento_estudiante(elementos, estudiante, evaluacion, categoria, (MainActivity) getActivity(), getContext());
        reciclador.setAdapter(adaptador);


        return view;
    }
}
