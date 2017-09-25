package com.uninorte.proyecto1_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Evaluacion {

    private long id;
    private String name;
    private Rubrica rubrica;
    public List<Estudiante> Estudiantes;

    public Evaluacion( String nombre, Rubrica rubrica) {
        this.name = nombre;
        this.rubrica=rubrica;

    }


    public static final List<Evaluacion> Evaluaciones = new ArrayList<Evaluacion>();



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

    public void setRubrica(Rubrica rubrica){
        this.rubrica=rubrica;
    }

    public Rubrica getRubrica(){
        return rubrica;
    }


    static {
        Evaluaciones.add(new Evaluacion("Evaluacion 1",Rubrica.Rubricas.get(0)));
        Evaluaciones.add(new Evaluacion("Evaluacion 2",Rubrica.Rubricas.get(0)));

    }





}
