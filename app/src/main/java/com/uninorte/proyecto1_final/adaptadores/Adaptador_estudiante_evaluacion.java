package com.uninorte.proyecto1_final.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.modelos.Evaluacion;

import java.util.List;

public class Adaptador_estudiante_evaluacion extends RecyclerView.Adapter<Adaptador_estudiante_evaluacion.ViewHolder> {

    private List<Evaluacion> evaluaciones;

    public Adaptador_estudiante_evaluacion(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
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
        Evaluacion item = this.evaluaciones.get(i);

        //Glide.with(viewHolder.nombre.getContext())
        //   .load(item.getName());

        viewHolder.nombre.setText(item.getName());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button calificar;
        public Button ver;
        private Evaluacion evaluacion;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.estudiante_eval_textview);
            calificar = v.findViewById(R.id.calificar_button);
            ver = v.findViewById(R.id.ver_button);
        }
    }
}
