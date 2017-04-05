package com.canudinx.phlnetopac.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.canudinx.phlnetopac.R;

public class ListaBibliotecasAdapter extends BaseAdapter{
    private Activity activity;
    private String[] lista;

    public ListaBibliotecasAdapter(Activity activity, String[] lista){
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View linha = inflater.inflate(R.layout.item_lista_bibbliotecas, null);

        TextView titulo = (TextView) linha.findViewById(R.id.tv_bibblioteca);

        titulo.setText(lista[i].split("##")[0]);

        return linha;
    }
}
