package com.uninorte.proyecto1_final.fragmentos;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_Evaluaciones;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_elementos;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Curso_Table;
import com.uninorte.proyecto1_final.modelos.Evaluacion;
import com.uninorte.proyecto1_final.modelos.Evaluacion_Table;
import com.uninorte.proyecto1_final.modelos.Rubrica;

import java.util.List;


public class Fragmento_evaluaciones extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_Evaluaciones adaptador;
    private Curso curso;

    public Fragmento_evaluaciones() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long id = getArguments().getLong("id");
        curso = SQLite.select().from(Curso.class).where(Curso_Table.id.eq(id)).querySingle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_evaluaciones, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador_evaluaciones);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        List<Evaluacion> evaluaciones = SQLite.select().from(Evaluacion.class).where(Evaluacion_Table.curso_id.eq(curso.getId())).queryList();
        adaptador = new Adaptador_Evaluaciones(evaluaciones);
        reciclador.setAdapter(adaptador);


        FloatingActionButton fab = view.findViewById(R.id.añadir_evaluacion);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.activity_crear_evaluacion, null);
                final EditText etNombre = mView.findViewById(R.id.editText);
                final Spinner spinner = mView.findViewById(R.id.spinner);


                List<Rubrica> rubricas = SQLite.select().from(Rubrica.class).queryList();

                builder.setView(mView);
                builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Evaluacion e = new Evaluacion();
                        e.setCurso(curso);

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
