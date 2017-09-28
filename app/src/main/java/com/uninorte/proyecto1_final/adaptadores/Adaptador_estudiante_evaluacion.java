package com.uninorte.proyecto1_final.adaptadores;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uninorte.proyecto1_final.MainActivity;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.fragmentos.Fragmento_categoria_estudiante;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Estudiante;
import com.uninorte.proyecto1_final.modelos.Evaluacion;

import java.util.List;

public class Adaptador_estudiante_evaluacion extends RecyclerView.Adapter<Adaptador_estudiante_evaluacion.ViewHolder> {

    private List<Evaluacion> evaluaciones;
    private Estudiante estudiante;
    private Curso curso;
    private MainActivity mainActivity;

    public Adaptador_estudiante_evaluacion(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Adaptador_estudiante_evaluacion(List<Evaluacion> evaluaciones, Estudiante estudiante, Curso curso, MainActivity mainActivity) {
        this.evaluaciones = evaluaciones;
        this.estudiante = estudiante;
        this.curso = curso;
        this.mainActivity = mainActivity;
    }

    public void addEvaluacion(Evaluacion evaluacion) {
        evaluaciones.add(evaluacion);
        this.notifyDataSetChanged();
    }

    public void delEvaluacion(Evaluacion evaluacion) {
        evaluaciones.remove(evaluacion);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.evaluaciones.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_evaluaciones_estudiantes, viewGroup, false);
        return new Adaptador_estudiante_evaluacion.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Evaluacion item = this.evaluaciones.get(i);

        //Glide.with(viewHolder.nombre.getContext())
        //   .load(item.getName());

        viewHolder.nombre.setText(item.getName());
        viewHolder.calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragmento_categoria_estudiante();

                Bundle bundle = new Bundle();
                bundle.putLong("idEstudiante", estudiante.getId());
                bundle.putLong("idCurso", curso.getId());
                bundle.putLong("idEvaluacion", item.getId());
                bundle.putLong("idRubrica", item.getRubrica().getId());
                fragment.setArguments(bundle);

                mainActivity.replaceFragment(fragment);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button calificar;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.estudiante_eval_textview);
            calificar = v.findViewById(R.id.calificar_button);
        }
    }
}
