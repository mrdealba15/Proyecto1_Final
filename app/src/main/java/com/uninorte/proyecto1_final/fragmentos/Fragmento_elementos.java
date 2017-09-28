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
import com.uninorte.proyecto1_final.adaptadores.Adaptador_elementos;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Categoria_Table;
import com.uninorte.proyecto1_final.modelos.Elemento;
import com.uninorte.proyecto1_final.modelos.Elemento_Table;

import java.util.List;

public class Fragmento_elementos extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private Adaptador_elementos adaptador;
    private Categoria categoria;

    public Fragmento_elementos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_elementos, container, false);

        reciclador = view.findViewById(R.id.reciclador_elementos);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        long id = getArguments().getLong("id");
        categoria = SQLite.select().from(Categoria.class).where(Categoria_Table.id.eq(id)).querySingle();

        List<Elemento> elementos = SQLite.select().from(Elemento.class).where(Elemento_Table.categoria_id.eq(id)).queryList();
        adaptador = new Adaptador_elementos(elementos);
        reciclador.setAdapter(adaptador);

        FloatingActionButton fab = view.findViewById(R.id.añadir_elemento);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.activity_crear_rubrica_elemento, null);

                final EditText etNombreElemento = mView.findViewById(R.id.editText18);
                final EditText etPesoElemento = mView.findViewById(R.id.editText25);
                final EditText etL1 = mView.findViewById(R.id.editText17);
                final EditText etL2 = mView.findViewById(R.id.editText19);
                final EditText etL3 = mView.findViewById(R.id.editText20);
                final EditText etL4 = mView.findViewById(R.id.editText21);

                builder.setView(mView);
                builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Elemento e = new Elemento();
                        e.setName(etNombreElemento.getText().toString());
                        e.setPeso(Float.parseFloat(etPesoElemento.getText().toString()));
                        e.setCategoria(categoria);
                        e.setL1(etL1.getText().toString());
                        e.setL2(etL2.getText().toString());
                        e.setL3(etL3.getText().toString());
                        e.setL4(etL4.getText().toString());
                        e.save();

                        adaptador.addElemento(e);
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
