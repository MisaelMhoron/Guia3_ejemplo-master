package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by missa on 09/09/2017.
 */

public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {

    public AdaptadorMensaje(Context context, List<Mensaje> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //obteniendo el dato
        Mensaje mensaje= getItem(position);
        // Todo inicializando el layout correspondiente al item (mensaje)
        if(convertView == null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_mensaje, parent ,false);
        }
        TextView lblFecha= (TextView) convertView.findViewById(R.id.txtEntrada);
        //Mostrar Datos
        lblFecha.setText(mensaje.contenido + " " +mensaje.fecha);

        return convertView;
    }

}

