package com.uninorte.proyecto1_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Rubrica {


    private long id;
    private String name;

    public Rubrica(String name){
        this.name=name;
    }

    public List<Evaluacion> Categorias;

    public static final List<Rubrica> Rubricas = new ArrayList<Rubrica>();

    public List<Evaluacion> getCategorias()

    {
        return Categorias;
    }

    static {
        Rubricas.add(new Rubrica("rubrica 1"));
        Rubricas.add(new Rubrica("rubrica 2"));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
