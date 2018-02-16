package com.example.didact.ejerciciofinal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView tvNombre, tvNPersonas, tvDia, tvHora, tvObservaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvNombre = (TextView)findViewById(R.id.infoTvNombre);
        tvNPersonas = (TextView)findViewById(R.id.infoTvNPersonas);
        tvDia = (TextView)findViewById(R.id.infoTvDia);
        tvHora = (TextView)findViewById(R.id.infoTvHora);
        tvObservaciones = (TextView)findViewById(R.id.infoTvObservaciones);

        Bundle b= getIntent().getExtras();

        if (b!=null){

            Reserva r = b.getParcelable(ReservaActivity.EXTRA_RESERVA);

            tvNombre.setText("-Nombre: "+r.nombre);
            tvNPersonas.setText("-Número de personas: "+r.nPersona);
            tvDia.setText("-Dia: "+r.dia);
            tvHora.setText("-Hora: "+r.hora);
            tvObservaciones.setText("-Observaciones: "+r.observacion);

        }

    }

    public void clickInicioinfo (View view){

        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }


}
