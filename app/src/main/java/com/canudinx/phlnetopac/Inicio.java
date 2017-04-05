package com.canudinx.phlnetopac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.canudinx.phlnetopac.helper.InicioHelper;

public class Inicio extends AppCompatActivity {
    private String biblioteca = "";
    private SharedPreferences config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        config = getSharedPreferences(Bibliotecas.PREFS, MODE_PRIVATE);
        if((biblioteca = config.getString(Bibliotecas.BIBLIOTECA, "")) == ""){
            Intent selecionaBiblioteca = new Intent(this, Bibliotecas.class);
            startActivityForResult(selecionaBiblioteca, 0);
        }

        setTitle("PHL.net " + biblioteca);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new InicioHelper(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setTitle("PHL.net " + config.getString(Bibliotecas.BIBLIOTECA, null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicio, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sobre:
                Intent irParaSobre = new Intent(this, Sobre.class);
                startActivity(irParaSobre);
                break;

            case R.id.alterar_bib:
                Intent selecionaBiblioteca = new Intent(this, Bibliotecas.class);
                startActivityForResult(selecionaBiblioteca, 0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
