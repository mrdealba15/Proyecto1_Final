package com.uninorte.proyecto1_final.modelos;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

public class CalCategoria extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private float nota;

    @ForeignKey
    private CalRubrica calRubrica;

    @ForeignKey
    private Categoria categoria;

    public CalCategoria() {
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

    public CalRubrica getCalRubrica() {
        return calRubrica;
    }

    public void setCalRubrica(CalRubrica calRubrica) {
        this.calRubrica = calRubrica;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
