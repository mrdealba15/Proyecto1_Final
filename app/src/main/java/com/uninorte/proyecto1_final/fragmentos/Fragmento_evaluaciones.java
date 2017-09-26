package com.uninorte.proyecto1_final.fragmentos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_Evaluaciones;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Curso_Table;
import com.uninorte.proyecto1_final.modelos.Evaluacion;
import com.uninorte.proyecto1_final.modelos.Evaluacion_Table;
import com.uninorte.proyecto1_final.modelos.Rubrica;
import com.uninorte.proyecto1_final.modelos.Rubrica_Table;

import java.util.ArrayList;
import java.util.List;

public class Fragmento_evaluaciones extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager linearLayout;
    private Adaptador_Evaluaciones adaptador;
    private Curso curso;

    public Fragmento_evaluaciones() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_evaluaciones, container, false);

        reciclador = view.findViewById(R.id.reciclador_evaluaciones);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        long id = getArguments().getLong("id");
        curso = SQLite.select().from(Curso.class).where(Curso_Table.id.eq(id)).querySingle();

        List<Evaluacion> evaluaciones = SQLite.select().from(Evaluacion.class).where(Evaluacion_Table.curso_id.eq(id)).queryList();
        adaptador = new Adaptador_Evaluaciones(evaluaciones);
        reciclador.setAdapter(adaptador);

        FloatingActionButton fab = view.findViewById(R.id.añadir_evaluacion);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                View mView = getLayoutInflater().inflate(R.layout.activity_crear_evaluacion, null);
                final EditText etNombre = mView.findViewById(R.id.editText);
                final Spinner spRubrica = mView.findViewById(R.id.spinner);

                List<Rubrica> rubricas = SQLite.select(Rubrica_Table.name).from(Rubrica.class).queryList();
                List<String> opts = new ArrayList<String>();
                for (Rubrica rubrica : rubricas) {
                    opts.add(rubrica.getName());
                }

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, opts);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spRubrica.setAdapter(dataAdapter);

                builder.setView(mView);
                builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nRubrica = spRubrica.getSelectedItem().toString();
                        Rubrica rubrica = SQLite.select().from(Rubrica.class).where(Rubrica_Table.name.eq(nRubrica)).querySingle();

                        Evaluacion e = new Evaluacion();
                        e.setName(etNombre.getText().toString());
                        e.setCurso(curso);
                        e.setRubrica(rubrica);
                        e.save();

                        adaptador.addEvaluacion(e);
                    }
                });
                builder.setNegativeButton("Cancelar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }
}
