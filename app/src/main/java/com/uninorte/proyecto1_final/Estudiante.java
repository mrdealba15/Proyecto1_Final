package com.uninorte.proyecto1_final;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

import java.util.ArrayList;
import java.util.List;


public class Estudiante {

    private long id;
    private String name;
    private int color_resource;
    private String codigo;
    private List<Evaluacion> Evaluaciones;


    public Estudiante( String nombre,  int color_resource, String codigo) {
        this.name = nombre;
        this.color_resource = color_resource;
        this.codigo = codigo;
    }

    public static final List<Estudiante> Estudiantes = new ArrayList<Estudiante>();

    public List<Evaluacion> getEvaluacion()

    {
        return Evaluaciones;
    }

    public void setEvaluaciones(Evaluacion evaluacion){

        Evaluaciones.add(evaluacion);
    }


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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String name) {
        this.codigo = codigo;
    }


    public int getColorResource() {
        return color_resource;
    }

    public void setColorResource(int color_resource) {
        this.color_resource = color_resource;
    }

    static {
        Estudiantes.add(new Estudiante("Maria", 1, "200056545"));
        Estudiantes.add(new Estudiante("Paola", 2, "200054342"));

    }


}
