package com.uninorte.proyecto1_final.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.uninorte.proyecto1_final.modelos.Categoria;

import java.util.List;

public class Adaptador_categorias extends RecyclerView.Adapter<Adaptador_categorias.ViewHolder> {

    private List<Categoria> categorias;

    public Adaptador_categorias(List<Categoria> categorias) {
        this.categorias = categorias;
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(viewGroup.getContext())
        //       .inflate(R.layout.layout_rubrica, viewGroup, false);
        //return new Adaptador_rubricas.ViewHolder(v);

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Categoria item = categorias.get(position);
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
