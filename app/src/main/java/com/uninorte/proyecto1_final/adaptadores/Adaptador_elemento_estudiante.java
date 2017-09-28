package com.uninorte.proyecto1_final.adaptadores;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.uninorte.proyecto1_final.MainActivity;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.modelos.Categoria;
import com.uninorte.proyecto1_final.modelos.Elemento;
import com.uninorte.proyecto1_final.modelos.Estudiante;
import com.uninorte.proyecto1_final.modelos.Evaluacion;

import java.util.List;

public class Adaptador_elemento_estudiante extends RecyclerView.Adapter<Adaptador_elemento_estudiante.ViewHolder> {

    private List<Elemento> elementos;
    private Estudiante estudiante;
    private Evaluacion evaluacion;
    private Categoria categoria;
    private MainActivity mainActivity;
    private Context context;

    public Adaptador_elemento_estudiante(List<Elemento> elementos, Estudiante estudiante, Evaluacion evaluacion, Categoria categoria, MainActivity mainActivity, Context context) {
        this.elementos = elementos;
        this.estudiante = estudiante;
        this.evaluacion = evaluacion;
        this.categoria = categoria;
        this.mainActivity = mainActivity;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return this.elementos.size();
    }

    @Override
    public Adaptador_elemento_estudiante.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_elemento_estudiante, viewGroup, false);
        return new Adaptador_elemento_estudiante.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adaptador_elemento_estudiante.ViewHolder viewHolder, int i) {
        final Elemento item = this.elementos.get(i);

        //Glide.with(viewHolder.itemView.getContext())
        //     .load(item.getName());

        viewHolder.nombre.setText(item.getName());
        viewHolder.Peso.setText(String.valueOf(item.getPeso()));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View mView = mainActivity.getLayoutInflater().inflate(R.layout.calificar_elemento, null);

                RadioButton l1 = mView.findViewById(R.id.L1);
                RadioButton l2 = mView.findViewById(R.id.L2);
                RadioButton l3 = mView.findViewById(R.id.L3);
                RadioButton l4 = mView.findViewById(R.id.L4);
                final RadioGroup radioGroup = mView.findViewById(R.id.rgroup);

                l1.setText(String.format("L1: %s", item.getL1()));
                l2.setText(String.format("L2: %s", item.getL2()));
                l3.setText(String.format("L3: %s", item.getL3()));
                l4.setText(String.format("L4: %s", item.getL4()));

                builder.setView(mView);
                builder.setPositiveButton("Calificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO: Calificar!

                        switch (radioGroup.getCheckedRadioButtonId()) {
                            case R.id.L1:
                                Log.d("TAG", "L1");
                                break;
                            case R.id.L2:
                                Log.d("TAG", "L2");
                                break;
                            case R.id.L3:
                                Log.d("TAG", "L3");
                                break;
                            case R.id.L4:
                                Log.d("TAG", "L4");
                                break;
                            default:
                                return;
                        }
                        if (getItemCount() == 1)
                            mainActivity.popFragment();
                    }
                });
                builder.setNegativeButton("Cancelar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView Peso;
        public TextView w;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.elementos_textview);
            Peso = v.findViewById(R.id.Peso);
            w= v.findViewById(R.id.w);
            cardView = v.findViewById(R.id.card_layout);
        }
    }
}