package com.uninorte.proyecto1_final.adaptadores;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uninorte.proyecto1_final.MainActivity;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.fragmentos.Fragmento_estudiante_evaluacion;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Estudiante;

import java.util.List;

public class Adaptador_estudiante extends RecyclerView.Adapter<Adaptador_estudiante.ViewHolder> {

    private List<Estudiante> estudiantes;
    private Curso curso;
    private MainActivity mainActivity;

    public Adaptador_estudiante(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Adaptador_estudiante(List<Estudiante> estudiantes, Curso curso, MainActivity mainActivity) {
        this.estudiantes = estudiantes;
        this.curso = curso;
        this.mainActivity = mainActivity;
    }

    public int getItemCount() {
        return this.estudiantes.size();
    }

    @Override
    public Adaptador_estudiante.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_estudiantes, viewGroup, false);
        return new Adaptador_estudiante.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adaptador_estudiante.ViewHolder viewHolder, int i) {
        final Estudiante item = this.estudiantes.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.inicial.setText(item.getName());
        viewHolder.nombre.setText(item.getCodigo());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragmento_estudiante_evaluacion();

                Bundle bundle = new Bundle();
                bundle.putLong("idCurso", curso.getId());
                bundle.putLong("idEstudiante", item.getId());
                fragment.setArguments(bundle);

                mainActivity.replaceFragment(fragment);
            }
        });
    }

    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        this.notifyDataSetChanged();
    }

    public void delEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
        this.notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Campos respectivos de un item
        public TextView inicial;
        public TextView nombre;
        public TextView codigo;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            inicial = v.findViewById(R.id.initial);
            nombre = v.findViewById(R.id.name);
            codigo= v.findViewById(R.id.codigo);
            cardView = v.findViewById(R.id.card_layout);
        }
    }
}
