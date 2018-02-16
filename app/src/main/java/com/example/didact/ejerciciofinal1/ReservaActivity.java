package com.example.didact.ejerciciofinal1;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ReservaActivity extends AppCompatActivity {
    static final String EXTRA_RESERVA = "RESERVA";

    EditText etNombre, etNPersonas, etObservacion;
    Spinner spDia, spHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etNPersonas = (EditText)findViewById(R.id.etNPersona);
        etObservacion = (EditText)findViewById(R.id.etObservacion);

        spDia = (Spinner)findViewById(R.id.spDia);

        String[] valorDia={"Obligatorio","Lunes","Martes","Miercoles","Jueves","Viernes","Sábado","Domingo"};
        ArrayAdapter<String> adaptadorDia = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,valorDia);
        spDia.setAdapter(adaptadorDia);

        spHora = (Spinner)findViewById(R.id.spHora);

        String[] valorHora={"Obligatorio","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","20:00","20:30","21:00","21:30",
                            "22:00","22:30","23:00","23:30","00:00"};
        ArrayAdapter<String> adaptadorHora = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,valorHora);
        spHora.setAdapter(adaptadorHora);

    }

    public void clickReservar(View view){

        String nombre = etNombre.getText().toString();
        String nPersonas = etNPersonas.getText().toString();
        String dia =  spDia.getSelectedItem().toString();
        String hora = spHora.getSelectedItem().toString();
        String observacion = etObservacion.getText().toString();

        if (nombre.equals("") || nPersonas.equals("") ||dia.equals("Obligatorio") || hora.equals("Obligatorio")){

            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogComprobacion dialogo = new DialogComprobacion();
            dialogo.show(fragmentManager, "dialogAlerta");
        }else{
            int nPersonasint = Integer.parseInt(nPersonas);
            Reserva reservaenviada = new Reserva(nombre, nPersonasint, dia, hora, observacion);

            Intent i=new Intent(getApplicationContext(),InfoActivity.class);

            i.putExtra(EXTRA_RESERVA, reservaenviada);

            startActivity(i);

        }

    }

}
