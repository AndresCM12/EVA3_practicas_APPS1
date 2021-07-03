package com.example.eva1_12_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ClimaAdaptador extends ArrayAdapter<Clima> {
    private Context context;
    private int layout;
    //private Clima[] cCiudades;
    private List<Clima> cCiudades;


    public ClimaAdaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.cCiudades = objects;
    }


    //
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //fila: no existe la fila
        if(convertView == null) { //primera vez que se muestra la lista, no existe
            convertView = ((Activity)context).getLayoutInflater().inflate(layout, parent,false);
        }else{//fila: si existe y hay que llenar

        }

        ImageView imgVwClima;
        TextView txtVwCd, txtVwTemp, txtVwDesc;

        //vincularlas para poder usarlas
        imgVwClima = convertView.findViewById(R.id.imgVwImagen);
        txtVwCd = convertView.findViewById(R.id.txtVwTitulo);
        txtVwTemp = convertView.findViewById(R.id.txtVwTemp);
        txtVwDesc = convertView.findViewById(R.id.txtVwDesc);

        Clima climaCiudad = cCiudades.get(position);
        //llenar los widgets con datos(lista cCiudades)
        imgVwClima.setImageResource(climaCiudad.getImagen());
        txtVwCd.setText(climaCiudad.getCiudad());
        txtVwTemp.setText(climaCiudad.getTemp()+" C");
        txtVwDesc.setText(climaCiudad.getDesc());

        return convertView;
    }

}
