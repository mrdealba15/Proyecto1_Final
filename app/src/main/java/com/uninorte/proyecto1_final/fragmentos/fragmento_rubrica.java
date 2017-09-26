package com.uninorte.proyecto1_final.fragmentos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

public class fragmento_rubrica extends Fragment {

    private Adaptador_categorias adaptador;
    private Rubrica rubrica;

    public fragmento_rubrica() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_fragmento_rubrica, container, false);

        long id = getArguments().getLong("id");
        rubrica = SQLite.select().from(Rubrica.class).where(Rubrica_Table.id.eq(id)).querySingle();

        List<Categoria> categorias = SQLite.select().from(Categoria.class).where(Categoria_Table.rubrica_id.eq(id)).queryList();
        adaptador = new Adaptador_categorias(categorias);

        FloatingActionButton fab = mView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View mView = getLayoutInflater().inflate(R.layout.activity_crear_rubrica_categoria, null);

                final EditText etNombreCategoria = mView.findViewById(R.id.editText16);
                final EditText etPesoCategoria = mView.findViewById(R.id.editText10);
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
                        Categoria c = new Categoria();
                        c.setName(etNombreCategoria.getText().toString());
                        c.setPeso(Float.parseFloat(etPesoCategoria.getText().toString()));
                        c.setRubrica(rubrica);
                        c.save();

                        Elemento e = new Elemento();
                        e.setName(etNombreElemento.getText().toString());
                        e.setPeso(Float.parseFloat(etPesoElemento.getText().toString()));
                        e.setCategoria(c);
                        e.setL1(etL1.getText().toString());
                        e.setL2(etL2.getText().toString());
                        e.setL3(etL3.getText().toString());
                        e.setL4(etL4.getText().toString());
                        e.save();

                        adaptador.addCategoria(c);
                    }
                }).setNegativeButton("Cancelar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return mView;
    }

}
