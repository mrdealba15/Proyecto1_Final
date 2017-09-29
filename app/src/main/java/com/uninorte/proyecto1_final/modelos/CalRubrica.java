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
public class CalRubrica extends BaseModel {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private float nota;

    @ForeignKey
    private Estudiante estudiante;

    @ForeignKey
    private Evaluacion evaluacion;

    public CalRubrica() {
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void updateNota() {
        List<CalCategoria> calCategorias = SQLite.select().from(CalCategoria.class)
                .where(CalCategoria_Table.calRubrica_id.eq(getId()))
                .queryList();

        float n = 0;
        for (CalCategoria calCategoria :
                calCategorias) {
            n += calCategoria.getNota() * calCategoria.getCategoria().getPeso() / 100;
        }
        setNota(n);
        save();
    }
}
