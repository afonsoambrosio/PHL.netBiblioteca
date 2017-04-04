package com.canudinx.phlnetopac.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.canudinx.phlnetopac.R;

public class ListaObrasAdapter extends BaseAdapter{
    private Activity activity;
    private String[] lista;

    public ListaObrasAdapter(Activity activity, String[] lista){
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length - 1;
    }

    @Override
    public Object getItem(int i) {
        return lista[i + 1];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View linha = inflater.inflate(R.layout.item_lista_obras, null);

        TextView titulo = (TextView) linha.findViewById(R.id.tv_titulo_obra);

        // Remove as tags HTML que estão misturadas com os itens da busca e acescenta as devidas quebras de linha
        String descricao = lista[i].replaceFirst("</td>", " - ").replaceAll("(<br>|<p>|<b>)", "\n").replaceAll("<[^>]*>", "");

        titulo.setText(descricao);

        return linha;
    }
}
