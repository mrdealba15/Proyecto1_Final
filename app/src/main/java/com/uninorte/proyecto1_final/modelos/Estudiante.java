package com.uninorte.proyecto1_final.modelos;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.uninorte.proyecto1_final.MyDatabase;

@Table(database = MyDatabase.class)
public class Estudiante extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private String name;
    @Column
    private int color_resource;
    @Column
    private String codigo;

    @ForeignKey
    private Curso curso;

    public Estudiante() {
    }

    public Estudiante(String nombre, int color_resource, String codigo, Curso curso) {
        this.name = nombre;
        this.color_resource = color_resource;
        this.codigo = codigo;
        this.curso = curso;
    }

    public int getColor_resource() {
        return color_resource;
    }

    public void setColor_resource(int color_resource) {
        this.color_resource = color_resource;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getColorResource() {
        return color_resource;
    }

    public void setColorResource(int color_resource) {
        this.color_resource = color_resource;
    }

}
