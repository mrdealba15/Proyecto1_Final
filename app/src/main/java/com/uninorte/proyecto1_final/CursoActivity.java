package com.uninorte.proyecto1_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.adaptadores.Adaptador_cursos;
import com.uninorte.proyecto1_final.modelos.Curso;

import java.util.List;

public class CursoActivity extends AppCompatActivity {

    private Adaptador_cursos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Curso> cursos = SQLite.select().from(Curso.class).queryList();
        adapter = new Adaptador_cursos(cursos);
    }


}
