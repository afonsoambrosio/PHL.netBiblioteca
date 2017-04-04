package com.canudinx.phlnetopac.helper;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.canudinx.phlnetopac.R;
import com.canudinx.phlnetopac.task.ConsultarTask;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ConsultaHelper {
    Activity activity;
    FrameLayout loader;
    EditText txt_busca;
    ImageButton btn_buscar;
    AdView adview;
    AdRequest adRequest;

    // Realiza a busca ao acervo atravez da AsyncTask

    public ConsultaHelper(final Activity activity){
        this.activity = activity;

        loader = (FrameLayout) activity.findViewById(R.id.loader);
        txt_busca = (EditText) activity.findViewById(R.id.txt_busca);
        btn_buscar = (ImageButton) activity.findViewById(R.id.btn_buscar);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }
        });

        txt_busca.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                consultar();
                return false;
            }
        });

        adview = (AdView) activity.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);

    }

    private void consultar(){
        String chave = txt_busca.getText().toString();

        if(chave.length() > 1) {
            txt_busca.setEnabled(false);
            btn_buscar.setClickable(false);
            loader.setVisibility(FrameLayout.VISIBLE);

            // Efetua a consulta no link indicado
            ConsultarTask task = new ConsultarTask(activity, "http://unifeiitajuba.phlnet.com.br/cgi-bin/wxis.exe?IsisScript=searchterm.xis&searchterm=", chave);

            task.execute();
        }
    }
}
