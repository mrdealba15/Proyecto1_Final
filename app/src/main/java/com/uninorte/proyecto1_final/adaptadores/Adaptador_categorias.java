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



    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button Delete;
        public TextView Peso;
        public Button elementos;


        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.categorias_textview);
            Delete = (Button) v.findViewById(R.id.delete_categoria);
            elementos = (Button) v.findViewById(R.id.evaluation_botton);
            Peso = (TextView) v.findViewById(R.id.Peso);

        }
    }

    public Adaptador_categorias() {
    }


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
    public Adaptador_categorias.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_categorias, viewGroup, false);
        return new Adaptador_categorias.ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(Adaptador_categorias.ViewHolder viewHolder, int i) {
        Categoria item =this.categorias.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());


        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(item.getPeso()+"");


    }


}
