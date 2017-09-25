package com.uninorte.proyecto1_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Categoria {

    private long id;
    private String name;
    private float Peso;

    public Categoria(String nombre, float Peso){
       this.name=nombre;
       this.Peso=Peso;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        this.Peso = peso;
    }

    public static final List<Categoria> Categorias = new ArrayList<Categoria>();

    public  List<Elemento> Elementos = new ArrayList<Elemento>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Elemento> getElementos()

    {
        return Elementos;
    }

    public void setEvaluaciones(List<Elemento> Elementos){
        for (Elemento elemento : this.Elementos = Elementos) {

        }

    }

    static {
        Categorias.add(new Categoria("Categoria 1",(float) 0.2));
        Categorias.add(new Categoria("Categoria 2", (float) 0.3));

    }






}
