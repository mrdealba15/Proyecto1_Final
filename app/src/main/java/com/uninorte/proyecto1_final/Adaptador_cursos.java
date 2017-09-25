package com.uninorte.proyecto1_final;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;



public class Adaptador_cursos extends RecyclerView.Adapter<Adaptador_cursos.ViewHolder>{


        public static class ViewHolder extends RecyclerView.ViewHolder {
            // Campos respectivos de un item
            public TextView inicial;
            public Button Ir;
            public TextView nombre;

            public ViewHolder(View v) {
                super(v);
                inicial = (TextView) v.findViewById(R.id.cursos_textView);
                Ir = (Button) v.findViewById(R.id.Ir);
                nombre = (TextView) v.findViewById(R.id.name_curso);
            }
        }

        public Adaptador_cursos() {
        }





        @Override
        public int getItemCount() {
            return Curso.Cursos.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_cursos, viewGroup, false);
            return new ViewHolder(v);
        }




        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Curso item = Curso.Cursos.get(i);

            Glide.with(viewHolder.itemView.getContext())
                    .load(item.getName());
            viewHolder.inicial.setText(item.getName());
            viewHolder.nombre.setText(item.getNrc());


        }


    }


