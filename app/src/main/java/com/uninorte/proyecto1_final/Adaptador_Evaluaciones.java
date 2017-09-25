package com.uninorte.proyecto1_final;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Adaptador_Evaluaciones  extends RecyclerView.Adapter<Adaptador_Evaluaciones.ViewHolder>{

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


    public int getItemCount() {
        return Evaluacion.Evaluaciones.size();
    }

    public Adaptador_Evaluaciones (){

    }

    @Override
    public Adaptador_Evaluaciones.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_evaluaciones, viewGroup, false);
        return new Adaptador_Evaluaciones.ViewHolder(v);
    }

    public void onBindViewHolder(Adaptador_Evaluaciones.ViewHolder viewHolder, int i) {
        Evaluacion item = Evaluacion.Evaluaciones.get(i);


        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());


    }

}
