package com.uninorte.proyecto1_final.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.modelos.Elemento;

import java.util.List;

public class Adaptador_elemento_estudiante extends RecyclerView.Adapter<Adaptador_elemento_estudiante.ViewHolder> {

    private List<Elemento> elementos;

    public Adaptador_elemento_estudiante(List<Elemento> elementos) {
        this.elementos = elementos;
    }



    @Override
    public int getItemCount() {
        return this.elementos.size();
    }

    @Override
    public Adaptador_elemento_estudiante.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_elemento_estudiante, viewGroup, false);
        return new Adaptador_elemento_estudiante.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adaptador_elemento_estudiante.ViewHolder viewHolder, int i) {
        Elemento item = this.elementos.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(String.valueOf(item.getPeso()));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView Peso;
        public TextView w;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.elementos_textview);
            Peso = v.findViewById(R.id.Peso);
            w= v.findViewById(R.id.w);
        }
    }
}
