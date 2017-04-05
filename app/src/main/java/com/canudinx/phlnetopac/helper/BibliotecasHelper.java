package com.canudinx.phlnetopac.helper;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.canudinx.phlnetopac.Bibliotecas;
import com.canudinx.phlnetopac.R;
import com.canudinx.phlnetopac.adapter.ListaBibliotecasAdapter;

public class BibliotecasHelper {
    private Activity activity;
    private ListView lista_bibliotecas;
    private String[] bibliotecas_disp;
    private String[] config;
    private ListaBibliotecasAdapter adapter;

    public BibliotecasHelper(final Activity activity){
        lista_bibliotecas = (ListView) activity.findViewById(R.id.lista_bibliotecas);

        bibliotecas_disp = activity.getResources().getStringArray(R.array.bibliotecas_disp);

        adapter = new ListaBibliotecasAdapter(activity, bibliotecas_disp);

        lista_bibliotecas.setAdapter(adapter);

        lista_bibliotecas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                config = adapter.getItem(i).toString().split("##");

                SharedPreferences.Editor editor = activity.getSharedPreferences(Bibliotecas.PREFS, Context.MODE_PRIVATE).edit();
                editor.putString(Bibliotecas.BIBLIOTECA, config[0]);
                editor.putString(Bibliotecas.ENDERECO, config[1]);
                editor.commit();

                activity.setResult(0);
                activity.finish();
            }
        });
    }
}
