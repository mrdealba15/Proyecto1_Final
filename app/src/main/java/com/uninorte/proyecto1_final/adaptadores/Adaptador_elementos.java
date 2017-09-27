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

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Adaptador_elementos extends RecyclerView.Adapter<Adaptador_elementos.ViewHolder> {

    private List<Elemento> elementos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button Delete;
        public TextView Peso;
        public Button editar;


        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.elementos_textview);
            Delete = (Button) v.findViewById(R.id.delete_elemento);
            editar = (Button) v.findViewById(R.id.editar_elementos);
            Peso = (TextView) v.findViewById(R.id.Peso);

        }
    }

    public Adaptador_elementos() {
    }


    public int getItemCount() {
        return this.elementos.size();
    }

    @Override
    public Adaptador_elementos.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_elementos, viewGroup, false);
        return new Adaptador_elementos.ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(Adaptador_elementos.ViewHolder viewHolder, int i) {
        Elemento item = this.elementos.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());


        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(item.getPeso()+"");


    }


}
