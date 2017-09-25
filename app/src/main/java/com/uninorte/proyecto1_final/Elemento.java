package com.uninorte.proyecto1_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win 8.1 pro on 24/09/2017.
 */

public class Elemento {

    private String name;
    private String L1;
    private String L2;
    private String L3;
    private String L4;

    private float Peso;

    public Elemento( String nombre, String L1, String L2, String L3, String L4, float Peso) {
        this.name = nombre;
        this.L1= L1;
        this.L2=L2;
        this.L3=L3;
        this.L4=L4;
        this.Peso=Peso;
    }

    public static final List<Elemento> Elementos = new ArrayList<Elemento>();


    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        this.Peso = peso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getL1(){
        return L1;
    }

    public String getL2(){
        return L2;
    }

    public String getL3(){
        return L3;
    }

    public String getL4(){
        return L4;
    }

    static {
        Elementos.add(new Elemento("Elemento 1", "Excelente", "Bueno", "Regular","Malo", (float)0.2));
        Elementos.add(new Elemento("Elemento 2", "Excelente", "Bueno", "Regular","Malo", (float)0.3));

    }


}
