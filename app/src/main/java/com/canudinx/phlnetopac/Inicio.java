package com.canudinx.phlnetopac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.canudinx.phlnetopac.helper.InicioHelper;

public class Inicio extends AppCompatActivity {
    private String titulo = "UNIFEI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        setTitle("PHL.netopac " + titulo);
    }

    @Override
    protected void onResume() {
        super.onResume();

        InicioHelper helper = new InicioHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicio, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selecet = item.getItemId();
        if(selecet == R.id.sobre){
            Intent irParaSobre = new Intent(this, Sobre.class);
            startActivity(irParaSobre);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
