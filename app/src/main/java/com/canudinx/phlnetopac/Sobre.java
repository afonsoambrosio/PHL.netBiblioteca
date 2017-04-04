package com.canudinx.phlnetopac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sobre extends AppCompatActivity {
    private String titulo = "UNIFEI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        setTitle("PHL.net " + titulo + " > Sobre");
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
