package com.uninorte.proyecto1_final.modelos;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.uninorte.proyecto1_final.MyDatabase;

@Table(database = MyDatabase.class)
public class CalElemento extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private float nota;

    @ForeignKey
    private CalCategoria calCategoria;

    @ForeignKey
    private Elemento elemento;

    public CalElemento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public CalCategoria getCalCategoria() {
        return calCategoria;
    }

    public void setCalCategoria(CalCategoria calCategoria) {
        this.calCategoria = calCategoria;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }
}
