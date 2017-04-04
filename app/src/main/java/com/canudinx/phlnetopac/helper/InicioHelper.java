package com.canudinx.phlnetopac.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.canudinx.phlnetopac.Consulta;
import com.canudinx.phlnetopac.Conta;
import com.canudinx.phlnetopac.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class InicioHelper {
    Button btn_consulta;
    Button btn_conta;
    AdView adview;
    AdRequest adRequest;

    public InicioHelper(final Activity activity){
        btn_consulta = (Button) activity.findViewById(R.id.btn_consulta);
        btn_conta = (Button) activity.findViewById(R.id.btn_conta);

        btn_consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaConsulta = new Intent(activity, Consulta.class);
                activity.startActivity(irParaConsulta);
            }
        });

        btn_conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaConta = new Intent(activity, Conta.class);
                activity.startActivity(irParaConta);
            }
        });

        adview = (AdView) activity.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);
    }


}
