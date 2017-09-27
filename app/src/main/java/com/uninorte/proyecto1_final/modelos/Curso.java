package com.uninorte.proyecto1_final.modelos;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.uninorte.proyecto1_final.MyDatabase;

@Table(database = MyDatabase.class)
public class Curso extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private String name;

    @Column
    private String nrc;

    public Curso() {
    }

    public Curso(String nombre, String nrc) {
        this.name = nombre;
        this.nrc = nrc;
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

}
