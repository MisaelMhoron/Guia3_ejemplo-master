package org.dev4u.hv.guia3_ejemplo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import android.widget.ArrayAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MensajeActivity extends AppCompatActivity {


    public EditText txtEntrada;
    private ListView list;
    private AdaptadorMensaje adaptadorMensaje;
    private ArrayList<Mensaje> mensajeArrayList;
   // @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        //inicializando varibales
        txtEntrada= (EditText) findViewById(R.id.txtEntrada);
     Button   btnEnviar= (Button) findViewById(R.id.btnEnviar);

//inicializando el array
        mensajeArrayList = new ArrayList<>();

        //inicializando el adaptador
        adaptadorMensaje=new AdaptadorMensaje(this,  mensajeArrayList);
        // incializando el listview

        ListView listView= (ListView) findViewById(R.id.lstMensaje);
        // seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mensaje c= new Mensaje(
                        getfechaActual(),
                        txtEntrada.getText().toString()
                );
                mensajeArrayList.add(c);
                adaptadorMensaje.notifyDataSetChanged();
            }
        });


    }
    public static  String getfechaActual(){
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat(" dd/MM/yyyy  HH:mm:ss ");
        String dateString = sdf.format(date);

        return dateString;

    }


}
