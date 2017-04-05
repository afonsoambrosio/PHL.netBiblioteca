package com.canudinx.phlnetopac.task;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import com.canudinx.phlnetopac.R;
import com.canudinx.phlnetopac.adapter.ListaObrasAdapter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ConsultarTask extends AsyncTask<String, Integer, Void>{
    private final int SUCESSO = 0;
    private final int ERRO_DESCONECTADO = 1;
    private final int ERRO_DESCONHECIDO = 2;

    private Activity activity;
    private int status;
    private InputStream istream = null;
    private StringBuilder builder;
    private BufferedReader reader;
    private String endereco = "";
    private String chave = "";
    private String[] parts;
    private ListView lista_obras;

    public ConsultarTask(Activity activity, String endereco, String chave){
        this.activity = activity;
        this.endereco = endereco;
        this.chave = chave;

        lista_obras = (ListView) activity.findViewById(R.id.resultado_busca);

        lista_obras.setAdapter(null);
    }

    @Override
    protected Void doInBackground(String... strings) {
        builder = new StringBuilder();

        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(cm.getActiveNetworkInfo() != null) {

            try {

                // Concatena o endereço com o termo a ser buscado
                endereco += URLEncoder.encode(chave, "iso-8859-1");

                URL url = new URL(endereco);

                // Abre uma conexão HTTP com o servidor
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);

                conn.connect();

                if (conn.getResponseCode() == 200) {
                    istream = conn.getInputStream();

                    if (istream != null) {

                        // Leitura e processamento dos dados recebidos
                        reader = new BufferedReader(new InputStreamReader(istream, "iso-8859-1"));

                        int ch;
                        while ((ch = reader.read()) > 0) {
                            builder.append((char)ch);
                        }

                        parts = builder.substring(builder.indexOf("Total encontrado")).split("<hr>");

                    }

                    istream.close();

                } else {
                    status = ERRO_DESCONHECIDO;
                }
            } catch (Exception e) {
                status = ERRO_DESCONHECIDO;
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        FrameLayout loader = (FrameLayout) activity.findViewById(R.id.loader);
        EditText txt_busca = (EditText) activity.findViewById(R.id.txt_busca);
        ImageButton btn_buscar = (ImageButton) activity.findViewById(R.id.btn_buscar);

        txt_busca.setEnabled(true);
        btn_buscar.setClickable(true);
        loader.setVisibility(FrameLayout.GONE);

        if(parts != null) {
            // Lista os 20 primeiros resultados
            ListaObrasAdapter adapter = new ListaObrasAdapter(activity, parts);

            lista_obras.setAdapter(adapter);
        }
    }
}
