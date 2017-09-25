package com.uninorte.proyecto1_final.modelos;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.uninorte.proyecto1_final.MyDatabase;

import java.util.ArrayList;
import java.util.List;

@Table(database = MyDatabase.class)
public class Categoria extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private String name;

    @Column
    private float peso;

    @ForeignKey(saveForeignKeyModel = false)
    private Rubrica rubrica;

    public Categoria() {
    }

    public Categoria(String nombre, float Peso, Rubrica rubrica) {
        this.name = nombre;
        this.peso = Peso;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
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
}
