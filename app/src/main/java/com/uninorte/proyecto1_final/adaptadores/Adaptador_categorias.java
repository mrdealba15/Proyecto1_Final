package com.uninorte.proyecto1_final.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.modelos.Categoria;

import java.util.List;

public class Adaptador_categorias extends RecyclerView.Adapter<Adaptador_categorias.ViewHolder> {

    private List<Categoria> categorias;

    public Adaptador_categorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public int getItemCount() {
        return this.categorias.size();
    }

    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
        this.notifyDataSetChanged();
    }

    public void delCategoria(Categoria categoria) {
        categorias.remove(categoria);
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_categorias, viewGroup, false);
        return new Adaptador_categorias.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Categoria item = this.categorias.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(String.valueOf(item.getPeso()));
        viewHolder.id.setText((String.valueOf(item.getId())));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView Peso;
        public TextView id;
        public TextView Pes;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.categorias_textview);
            Peso = v.findViewById(R.id.Peso);
            Pes= v.findViewById(R.id.Pes);
            id = v.findViewById(R.id.id);
        }
    }
}
