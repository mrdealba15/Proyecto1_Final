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

public class Adaptador_Evaluaciones extends RecyclerView.Adapter<Adaptador_Evaluaciones.ViewHolder> {

    private List<Evaluacion> evaluaciones;

    public Adaptador_Evaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public int getItemCount() {
        return this.evaluaciones.size();
    }

    @Override
    public Adaptador_Evaluaciones.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_evaluaciones, viewGroup, false);
        return new Adaptador_Evaluaciones.ViewHolder(v);
    }

    public void onBindViewHolder(Adaptador_Evaluaciones.ViewHolder viewHolder, int i) {
        Evaluacion item = this.evaluaciones.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());
    }

    public void addEvaluacion(Evaluacion evaluacion) {
        evaluaciones.add(evaluacion);
        this.notifyDataSetChanged();
    }

    public void delEvaluacion(Evaluacion evaluacion) {
        evaluaciones.remove(evaluacion);
        this.notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button Eliminar;


        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.evaluaciones_textview);
            Eliminar = (Button) v.findViewById(R.id.eliminar_evaluacion);
        }
    }
}
