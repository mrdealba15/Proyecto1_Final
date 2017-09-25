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

public class Adaptador_estudiante_evaluacion extends RecyclerView.Adapter<Adaptador_estudiante_evaluacion.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public Button calificar;
        public Button ver;


        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.estudiante_eval_textview);
            calificar = (Button) v.findViewById(R.id.calificar_button);
            ver = (Button) v.findViewById(R.id.ver_button);


        }
    }

    public Adaptador_estudiante_evaluacion() {
    }


    public int getItemCount() {
        return Evaluacion.Evaluaciones.size();
    }

    @Override
    public Adaptador_estudiante_evaluacion.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_evaluaciones_estudiantes, viewGroup, false);
        return new Adaptador_estudiante_evaluacion.ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(Adaptador_estudiante_evaluacion.ViewHolder viewHolder, int i) {
        Evaluacion item = Evaluacion.Evaluaciones.get(i);

        //Glide.with(viewHolder.nombre.getContext())
          //   .load(item.getName());



        viewHolder.nombre.setText(item.getName());


    }


}
