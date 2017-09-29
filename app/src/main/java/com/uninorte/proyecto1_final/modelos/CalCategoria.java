package com.uninorte.proyecto1_final.modelos;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.uninorte.proyecto1_final.MyDatabase;

import java.util.List;

@Table(database = MyDatabase.class)
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

    public void updateNota() {
        List<CalElemento> calElementos = SQLite.select().from(CalElemento.class)
                .where(CalElemento_Table.calCategoria_id.eq(getId()))
                .queryList();

        float n = 0;
        for (CalElemento el :
                calElementos) {
            n += el.getNota() * el.getElemento().getPeso() / 100;
        }
        setNota(n);
        save();
    }
}
