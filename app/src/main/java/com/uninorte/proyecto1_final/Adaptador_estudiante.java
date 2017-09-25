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

public class Adaptador_estudiante extends RecyclerView.Adapter<Adaptador_estudiante.ViewHolder> {




    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView inicial;
        public Button Delete;
        public TextView nombre;
        public Button evaluaciones;


        public ViewHolder(View v) {
            super(v);
            inicial = (TextView) v.findViewById(R.id.initial);
            Delete = (Button) v.findViewById(R.id.delete_button);
            evaluaciones = (Button) v.findViewById(R.id.evaluation_botton);
            nombre = (TextView) v.findViewById(R.id.name);

        }
    }

    public Adaptador_estudiante() {
    }


    public int getItemCount() {
        return Estudiante.Estudiantes.size();
    }

    @Override
    public Adaptador_estudiante.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_estudiantes, viewGroup, false);
        return new Adaptador_estudiante.ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(Adaptador_estudiante.ViewHolder viewHolder, int i) {
        Estudiante item = Estudiante.Estudiantes.get(i);

        //Glide.with(viewHolder.itemView.getContext())
           //     .load(item.getName());



        viewHolder.inicial.setText(item.getName());
        viewHolder.nombre.setText(item.getCodigo());


    }


}
