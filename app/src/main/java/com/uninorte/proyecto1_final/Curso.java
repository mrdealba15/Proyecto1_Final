package com.uninorte.proyecto1_final;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */
import java.util.ArrayList;
import java.util.List;
public class Curso {

    private long id;
    private String name;
    private String nrc;
    public  ArrayList<Estudiante> estudiantes;
    public ArrayList<Evaluacion> evaluaciones;

    public Curso( String nombre, String nrc) {
        this.name = nombre;
        this.nrc = nrc;
        this.estudiantes = new ArrayList<Estudiante>();
        this.evaluaciones= new ArrayList<Evaluacion>();
    }

    public static final List<Curso> Cursos = new ArrayList<Curso>();


    public void Agregar_estudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

    public void Agregar_evaluacion(Evaluacion evaluacion){
        evaluaciones.add(evaluacion);
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


    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    static {
        Cursos.add(new Curso("Curso 1", "12134"));
        Cursos.add(new Curso("Curso 2", "456343"));

    }


}
