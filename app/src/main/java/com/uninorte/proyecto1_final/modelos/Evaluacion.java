package com.uninorte.proyecto1_final.modelos;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.uninorte.proyecto1_final.MyDatabase;

@Table(database = MyDatabase.class)
public class Evaluacion extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;
    @Column
    private String name;
    @ForeignKey
    private Rubrica rubrica;
    @ForeignKey
    private Curso curso;

    public Evaluacion() {
    }

    public Evaluacion(String nombre, Rubrica rubrica, Curso curso) {
        this.name = nombre;
        this.rubrica = rubrica;
        this.curso = curso;
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

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
