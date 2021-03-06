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
import android.widget.EditText;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.MainActivity;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_estudiante;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Curso_Table;
import com.uninorte.proyecto1_final.modelos.Estudiante;
import com.uninorte.proyecto1_final.modelos.Estudiante_Table;

import java.util.List;

public class Fragmento_estudiantes extends Fragment {

    private static int[] colors;
    private RecyclerView reciclador;
    private Adaptador_estudiante adaptador;
    private Curso curso;
    private LinearLayoutManager linearLayout;

    public Fragmento_estudiantes() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_estudiantes, container, false);

        colors = getResources().getIntArray(R.array.initial_colors);

        reciclador = view.findViewById(R.id.reciclador);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        long id = getArguments().getLong("id");
        curso = SQLite.select().from(Curso.class).where(Curso_Table.id.eq(id)).querySingle();

        List<Estudiante> estudiantes = SQLite.select().from(Estudiante.class).where(Estudiante_Table.curso_id.eq(id)).queryList();
        adaptador = new Adaptador_estudiante(estudiantes, curso, (MainActivity) getActivity());
        reciclador.setAdapter(adaptador);

        FloatingActionButton fab = view.findViewById(R.id.añadir_estudiante);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                View mView = getLayoutInflater().inflate(R.layout.activity_crear_estudiante, null);
                final EditText etNombre = mView.findViewById(R.id.editText16);
                final EditText etCodigo = mView.findViewById(R.id.editText10);

                builder.setView(mView);
                builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Estudiante e = new Estudiante();
                        e.setName(etNombre.getText().toString());
                        e.setCodigo(etCodigo.getText().toString());
                        e.setCurso(curso);
                        e.save();

                        adaptador.addEstudiante(e);
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
