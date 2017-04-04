package com.canudinx.phlnetopac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.canudinx.phlnetopac.helper.ConsultaHelper;

public class Consulta extends AppCompatActivity {
    private String titulo = "UNIFEI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        setTitle("PHL.net " + titulo + " > Consulta");
    }

    @Override
    protected void onResume() {
        super.onResume();

        ConsultaHelper helper = new ConsultaHelper(this);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
