package com.canudinx.phlnetopac;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.canudinx.phlnetopac.helper.ConsultaHelper;

public class Consulta extends AppCompatActivity {
    private String biblioteca = "";
    private String endereco = "";
    private SharedPreferences config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        config = getSharedPreferences(Bibliotecas.PREFS, MODE_PRIVATE);
        biblioteca = config.getString(Bibliotecas.BIBLIOTECA, "");
        endereco = config.getString(Bibliotecas.ENDERECO, "");

        setTitle("PHL.net " + biblioteca + " > Consulta");
    }

    @Override
    protected void onResume() {
        super.onResume();

        ConsultaHelper helper = new ConsultaHelper(this, endereco);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
