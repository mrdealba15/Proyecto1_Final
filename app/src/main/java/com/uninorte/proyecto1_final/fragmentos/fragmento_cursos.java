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

        List<Curso> cursos = SQLite.select().from(Curso.class).queryList();
        adaptador = new Adaptador_cursos(cursos);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.dialog_crear_curso, null);
                final EditText etNombre = mView.findViewById(R.id.etNombreCurso);
                final EditText etNrc = mView.findViewById(R.id.etNrcCurso);
                builder.setView(mView);
                builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Curso c = new Curso();
                        c.setName(etNombre.getText().toString());
                        c.setNrc(etNrc.getText().toString());
                        c.save();

                        adaptador.addCurso(c);
                    }
                });
                builder.setNegativeButton("Cancelar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        reciclador.setAdapter(adaptador);
        return view;
    }

}
