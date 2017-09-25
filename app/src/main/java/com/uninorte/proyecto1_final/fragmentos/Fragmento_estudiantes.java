package com.uninorte.proyecto1_final.fragmentos;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_estudiante;
import com.uninorte.proyecto1_final.modelos.Estudiante;

import java.util.List;


/**
 * Fragmento para la pestaña "DIRECCIONES" De la sección "Mi Cuenta"
 */
public class Fragmento_estudiantes extends Fragment {


    RecyclerView reciclador;
    private Adaptador_estudiante adaptador;
    private static int[] colors;

    private LinearLayoutManager linearLayout;

    public Fragmento_estudiantes() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_estudiantes, container, false);

        colors = getResources().getIntArray(R.array.initial_colors);

        reciclador = (RecyclerView)view.findViewById(R.id.reciclador);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        List<Estudiante> estudiantes = SQLite.select().from(Estudiante.class).queryList();
        adaptador = new Adaptador_estudiante(estudiantes);
        reciclador.setAdapter(adaptador);



        return view;
    }

}
