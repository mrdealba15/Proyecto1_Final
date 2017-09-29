package com.uninorte.proyecto1_final.fragmentos;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.uninorte.proyecto1_final.R;
import com.uninorte.proyecto1_final.modelos.Curso;
import com.uninorte.proyecto1_final.modelos.Curso_Table;

import java.util.ArrayList;
import java.util.List;

public class Fragmento_curso extends Fragment {

    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;
    private Curso curso;

    public Fragmento_curso() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_paginado, container, false);
        long id = getArguments().getLong("idCurso");
        curso = SQLite.select().from(Curso.class).where(Curso_Table.id.eq(id)).querySingle();

        if (savedInstanceState == null) {
            insertarTabs(container);
            // Setear adaptador al viewpager.
            viewPager = view.findViewById(R.id.pager);
            poblarViewPager(viewPager);
            pestanas.setupWithViewPager(viewPager);
        }

        return view;
    }

    private void poblarViewPager(ViewPager viewPager) {
        AdaptadorSecciones adapter = new AdaptadorSecciones(getFragmentManager());

        Fragmento_estudiantes fEstud = new Fragmento_estudiantes();
        Fragmento_evaluaciones fEval = new Fragmento_evaluaciones();

        Bundle bundle = new Bundle();
        bundle.putLong("id", curso.getId());
        fEstud.setArguments(bundle);
        fEval.setArguments(bundle);

        adapter.addFragment(fEstud, "Estudiantes");
        adapter.addFragment(fEval, "Evaluaciones");
        viewPager.setAdapter(adapter);
    }

    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        appBar = padre.findViewById(R.id.appbar);
        pestanas = new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(pestanas);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(pestanas);
    }

    public class AdaptadorSecciones extends FragmentStatePagerAdapter {

        private final List<Fragment> fragmentos = new ArrayList<>();
        private final List<String> titulosFragmentos = new ArrayList<>();

        public AdaptadorSecciones(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            fragmentos.add(fragment);
            titulosFragmentos.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragmentos.get(position);
        }
    }
}

