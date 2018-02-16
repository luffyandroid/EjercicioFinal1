package com.example.didact.ejerciciofinal1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DIDACT on 16/02/2018.
 */

public class AdaptadorReserva extends ArrayAdapter<Reserva> {

    ArrayList<Reserva> reservas;
    Context c;

    public AdaptadorReserva(Context c, ArrayList<Reserva> reservas){
        super(c, R.layout.listviewreserva, reservas);
        this.c = c;
        this.reservas = reservas;



    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listviewreserva, null);

        TextView tv_nombre=(TextView)item.findViewById(R.id.listTvNombre);
        tv_nombre.setText(reservas.get(position).getNombre());


        TextView tv_serie=(TextView)item.findViewById(R.id.listTvDia);
        tv_serie.setText(reservas.get(position).getDia());

        TextView tv_frase=(TextView)item.findViewById(R.id.listTvHora);
        tv_frase.setText(reservas.get(position).getHora());

        return item;
    }
}
