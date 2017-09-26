package com.uninorte.proyecto1_final.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.uninorte.proyecto1_final.modelos.Elemento;

import java.util.List;

public class Adaptador_elementos extends RecyclerView.Adapter<Adaptador_elementos.ViewHolder> {

    private List<Elemento> elementos;

    public Adaptador_elementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    public void addElemento(Elemento elemento) {
        elementos.add(elemento);
        this.notifyDataSetChanged();
    }

    public void delElemento(Elemento elemento) {
        elementos.remove(elemento);
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
        Elemento item = elementos.get(position);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
