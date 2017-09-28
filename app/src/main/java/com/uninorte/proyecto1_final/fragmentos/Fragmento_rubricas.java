package com.uninorte.proyecto1_final.fragmentos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_rubricas;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Elemento;
import com.uninorte.proyecto1_final.modelos.Rubrica;

import java.util.List;

public class Fragmento_rubricas extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager linearLayout;
    private Adaptador_rubricas adaptador;

    public Fragmento_rubricas() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_rubricas, container, false);

        reciclador = view.findViewById(R.id.reciclador_rubricas);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        FloatingActionButton btn = view.findViewById(R.id.añadir_rubrica);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View mView = getLayoutInflater().inflate(R.layout.activity_crear_rubrica, null);

                final EditText etNombreRubrica = mView.findViewById(R.id.editText);
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
                        Rubrica r = new Rubrica();
                        r.setName(etNombreRubrica.getText().toString());
                        r.save();

                        Categoria c = new Categoria();
                        c.setName(etNombreCategoria.getText().toString());
                        c.setPeso(Float.parseFloat(etPesoCategoria.getText().toString()));
                        c.setRubrica(r);
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

                        adaptador.addRubrica(r);
                    }
                });
                builder.setNegativeButton("Cancelar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        List<Rubrica> rubricas = SQLite.select().from(Rubrica.class).queryList();
        adaptador = new Adaptador_rubricas(rubricas);
        reciclador.setAdapter(adaptador);

        return view;
    }




}
