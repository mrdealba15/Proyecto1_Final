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
import com.uninorte.proyecto1_final.adaptadores.Adaptador_categorias;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Categoria_Table;
import com.uninorte.proyecto1_final.modelos.Elemento;
import com.uninorte.proyecto1_final.modelos.Rubrica;
import com.uninorte.proyecto1_final.modelos.Rubrica_Table;

import java.util.List;

public class Fragmento_categoria_estudiante extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_categorias adaptador;
    private Rubrica rubrica;

    public Fragmento_categoria_estudiante() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categoria_estudiante, container, false);

        reciclador = view.findViewById(R.id.reciclador_categorias_estudiante);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        long id = getArguments().getLong("id");
        rubrica = SQLite.select().from(Rubrica.class).where(Rubrica_Table.id.eq(id)).querySingle();

        List<Categoria> categorias = SQLite.select().from(Categoria.class).where(Categoria_Table.rubrica_id.eq(id)).queryList();
        adaptador = new Adaptador_categorias(categorias);
        reciclador.setAdapter(adaptador);


        return view;
    }
}
