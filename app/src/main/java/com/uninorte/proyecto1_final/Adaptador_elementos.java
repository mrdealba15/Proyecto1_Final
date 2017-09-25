package com.uninorte.proyecto1_final;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Adaptador_elementos extends RecyclerView.Adapter<Adaptador_elementos.ViewHolder> {


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
        return Elemento.Elementos.size();
    }

    @Override
    public Adaptador_elementos.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_elementos, viewGroup, false);
        return new Adaptador_elementos.ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(Adaptador_elementos.ViewHolder viewHolder, int i) {
        Elemento item = Elemento.Elementos.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());


        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(item.getPeso()+"");


    }


}
