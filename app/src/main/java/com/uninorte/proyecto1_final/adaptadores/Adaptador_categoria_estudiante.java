package com.uninorte.proyecto1_final.adaptadores;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uninorte.proyecto1_final.MainActivity;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.fragmentos.Fragmento_elemento_estudiante;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Estudiante;
import com.uninorte.proyecto1_final.modelos.Evaluacion;

import java.util.List;

public class Adaptador_categoria_estudiante extends RecyclerView.Adapter<Adaptador_categoria_estudiante.ViewHolder> {

    private List<Categoria> categorias;
    private MainActivity mainActivity;
    private Estudiante estudiante;
    private Evaluacion evaluacion;

    public Adaptador_categoria_estudiante(List<Categoria> categorias, MainActivity mainActivity, Estudiante estudiante, Evaluacion evaluacion) {
        this.categorias = categorias;
        this.mainActivity = mainActivity;
        this.estudiante = estudiante;
        this.evaluacion = evaluacion;
    }

    @Override
    public int getItemCount() {
        return this.categorias.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_categoria_estudiante, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Categoria item = this.categorias.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(String.valueOf(item.getPeso()));
        viewHolder.id.setText((String.valueOf(item.getId())));

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmento_elemento_estudiante f = new Fragmento_elemento_estudiante();

                Bundle bundle = new Bundle();
                bundle.putLong("idEstudiante", estudiante.getId());
                bundle.putLong("idEvaluacion", evaluacion.getId());
                bundle.putLong("idCategoria", item.getId());
                f.setArguments(bundle);

                mainActivity.replaceFragment(f);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView Peso;
        public TextView id;
        public TextView Pes;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.categorias_textview);
            Peso = v.findViewById(R.id.Peso);
            Pes= v.findViewById(R.id.Pes);
            id = v.findViewById(R.id.id);
            cardView = v.findViewById(R.id.card_layout);
        }
    }
}
