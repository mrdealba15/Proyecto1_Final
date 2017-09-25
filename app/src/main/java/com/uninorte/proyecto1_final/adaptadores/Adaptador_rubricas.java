package com.uninorte.proyecto1_final.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.modelos.Rubrica;

import java.util.List;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Adaptador_rubricas extends RecyclerView.Adapter<Adaptador_rubricas.ViewHolder> {

    private List<Rubrica> rubricas;

    public Adaptador_rubricas() { }

    public Adaptador_rubricas(List<Rubrica> rubricas) {
        this.rubricas = rubricas;
    }

    public int getItemCount() {
        return this.rubricas.size();
    }

    @Override
    public Adaptador_rubricas.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_rubrica, viewGroup, false);
        return new Adaptador_rubricas.ViewHolder(v);
    }

    public void onBindViewHolder(Adaptador_rubricas.ViewHolder viewHolder, int i) {
        Rubrica item = this.rubricas.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button Editar;
        public Button Eliminar;
        public Button Ver;


        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.rubrica_textView);
            Editar = (Button) v.findViewById(R.id.editar);
            Eliminar = (Button) v.findViewById(R.id.ver);
            Ver = (Button) v.findViewById(R.id.eliminar);
        }


    }


}
