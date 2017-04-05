package com.canudinx.phlnetopac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.canudinx.phlnetopac.helper.BibliotecasHelper;

public class Bibliotecas extends AppCompatActivity {
    public static final String PREFS = "PHLNET_PREFS";
    public static final String BIBLIOTECA = "BIBLIOTECA";
    public static final String ENDERECO = "ENDERECO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliotecas);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new BibliotecasHelper(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selecione uma biblioteca!", Toast.LENGTH_SHORT).show();
    }
}
