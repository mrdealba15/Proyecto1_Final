package com.uninorte.proyecto1_final;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.View;


public class MainActivity extends AppCompatActivity{



        private DrawerLayout drawerLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            agregarToolbar();

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

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
                    .addToBackStack(null)
                    .commit();
        }

        // Setear título actual
        setTitle(itemDrawer.getTitle());
    }

    @Override
    public void onBackPressed(){
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0){
            super.onBackPressed();

        } else{
            getFragmentManager().popBackStack();
        }
    }



    public void OnclickCurso(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_curso();
        fragmentTransaction.replace(R.id.contenedor_principal, fragment).addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClickEvaluations(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_estudiante_evaluacion();
        fragmentTransaction.replace(R.id.contenedor_principal, fragment).addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void OnclickEditar_rubrica(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_categorias();
        fragmentTransaction.replace(R.id.contenedor_principal, fragment).addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClickElementos(View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragmento_elementos();
        fragmentTransaction.replace(R.id.contenedor_principal, fragment).addToBackStack(null);
        fragmentTransaction.commit();

    }



        private void agregarToolbar() {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            final ActionBar ab = getSupportActionBar();
            if (ab != null) {
                // Poner ícono del drawer toggle
                ab.setHomeAsUpIndicator(R.drawable.drawer_toggle);
                ab.setDisplayHomeAsUpEnabled(true);
            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_drawer, menu);
            return true;
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







}


