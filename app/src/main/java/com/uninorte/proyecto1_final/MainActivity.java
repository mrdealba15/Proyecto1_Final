package com.uninorte.proyecto1_final;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.uninorte.proyecto1_final.fragmentos.Fragmento_categorias;
import com.uninorte.proyecto1_final.fragmentos.Fragmento_curso;
import com.uninorte.proyecto1_final.fragmentos.Fragmento_elementos;
import com.uninorte.proyecto1_final.fragmentos.Fragmento_rubricas;
import com.uninorte.proyecto1_final.fragmentos.fragmento_cursos;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarToolbar();

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        if (navigationView != null) {
            prepararDrawer(navigationView);
            // Seleccionar item por defecto
            seleccionarItem(navigationView.getMenu().getItem(0));
        }
    }

    private void prepararDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        seleccionarItem(menuItem);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void seleccionarItem(MenuItem itemDrawer) {
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (itemDrawer.getItemId()) {
            case R.id.cursos:
                fragmentoGenerico = new fragmento_cursos();
                break;
            case R.id.rubricas:
                fragmentoGenerico = new Fragmento_rubricas();
                break;
        }

        if (fragmentoGenerico != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal, fragmentoGenerico)
                    .commit();
        }

        // Setear título actual
        setTitle(itemDrawer.getTitle());
    }

    public void replaceFragment(Fragment f) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.contenedor_principal, f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void popFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

    public void OnclickCurso(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_curso();

        Bundle bundle = new Bundle();
        TextView id = view.findViewById(R.id.id);
        bundle.putLong("idCurso", Long.valueOf(id.getText().toString()));
        fragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.contenedor_principal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void agregarToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();

        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.drawer_toggle);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnclickEditar_rubrica(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_categorias();

        Bundle bundle = new Bundle();
        TextView id = view.findViewById(R.id.id);
        bundle.putLong("id", Long.valueOf(id.getText().toString()));
        fragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.contenedor_principal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClickElementos(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_elementos();

        Bundle bundle = new Bundle();
        TextView id = view.findViewById(R.id.id);
        bundle.putLong("id", Long.valueOf(id.getText().toString()));
        fragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.contenedor_principal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}


